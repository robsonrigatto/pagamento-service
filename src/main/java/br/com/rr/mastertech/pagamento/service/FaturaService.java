package br.com.rr.mastertech.pagamento.service;

import br.com.rr.mastertech.pagamento.client.CartaoClient;
import br.com.rr.mastertech.pagamento.client.dto.CartaoDTO;
import br.com.rr.mastertech.pagamento.client.dto.UpdateCartaoDTO;
import br.com.rr.mastertech.pagamento.domain.Fatura;
import br.com.rr.mastertech.pagamento.domain.Pagamento;
import br.com.rr.mastertech.pagamento.dto.response.FaturaDTO;
import br.com.rr.mastertech.pagamento.exception.CartaoNaoEncontradoException;
import br.com.rr.mastertech.pagamento.exception.ClienteNaoVinculadoAoCartaoException;
import br.com.rr.mastertech.pagamento.exception.FaturaSemLancamentosException;
import br.com.rr.mastertech.pagamento.mapper.FaturaMapper;
import br.com.rr.mastertech.pagamento.repository.FaturaRepository;
import br.com.rr.mastertech.pagamento.repository.PagamentoRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class FaturaService {

    @Autowired
    private CartaoClient cartaoClient;

    @Autowired
    private FaturaRepository faturaRepository;

    @Autowired
    private FaturaMapper faturaMapper;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private PagamentoService pagamentoService;

    public List<Pagamento> getFatura(Integer clienteId, Integer cartaoId) {
        return pagamentoService.findAllByClienteIdAndCartaoId(clienteId, cartaoId);
    }

    @Transactional
    public FaturaDTO pagar(Integer clienteId, Integer cartaoId) {
        List<Pagamento> pagamentos = this.getFatura(clienteId, cartaoId);
        if(pagamentos.isEmpty()) throw new FaturaSemLancamentosException();

        Double valorPago = pagamentos.stream().reduce(0.0, (a, b) -> a + b.getValor(), Double::sum);

        Fatura fatura = Fatura.builder().clienteId(clienteId).cartaoId(cartaoId)
                .valorPago(valorPago).dataPagamento(LocalDate.now()).build();
        fatura = faturaRepository.save(fatura);

        pagamentoRepository.deleteByCartaoId(cartaoId);

        return faturaMapper.toDTO(fatura);
    }

    public void expirar(Integer clienteId, Integer cartaoId) {
        try {
            CartaoDTO cartaoDTO = cartaoClient.findById(cartaoId);
            if(!cartaoDTO.getClienteId().equals(clienteId)) throw new ClienteNaoVinculadoAoCartaoException();

            UpdateCartaoDTO updateDTO = new UpdateCartaoDTO();
            updateDTO.setAtivo(false);
            cartaoClient.update(cartaoId, updateDTO);

        } catch (FeignException.FeignClientException.NotFound ex) {
            throw new CartaoNaoEncontradoException();
        }
    }
}
