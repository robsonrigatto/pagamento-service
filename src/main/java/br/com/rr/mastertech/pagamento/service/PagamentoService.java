package br.com.rr.mastertech.pagamento.service;

import br.com.rr.mastertech.pagamento.client.CartaoClient;
import br.com.rr.mastertech.pagamento.client.dto.CartaoDTO;
import br.com.rr.mastertech.pagamento.domain.Pagamento;
import br.com.rr.mastertech.pagamento.exception.CartaoInativoException;
import br.com.rr.mastertech.pagamento.exception.CartaoNaoEncontradoException;
import br.com.rr.mastertech.pagamento.exception.ClienteNaoVinculadoAoCartaoException;
import br.com.rr.mastertech.pagamento.repository.PagamentoRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private CartaoClient cartaoClient;

    public Pagamento create(String descricao, Integer cartaoId, Double valor) {
        try {
            CartaoDTO cartao = cartaoClient.findById(cartaoId);
            if(!cartao.getAtivo()) throw new CartaoInativoException();

            Pagamento entity = Pagamento.builder().descricao(descricao).cartaoId(cartao.getId()).valor(valor).build();
            return pagamentoRepository.save(entity);

        } catch (FeignException.FeignClientException.NotFound ex) {
            throw new CartaoNaoEncontradoException();
        }
    }

    public List<Pagamento> findAllByCartaoId(Integer cartaoId) {
        try {
            CartaoDTO cartao = cartaoClient.findById(cartaoId);
            return pagamentoRepository.findAllByCartaoId(cartao.getClienteId());

        } catch (FeignException.FeignClientException.NotFound ex) {
            throw new CartaoNaoEncontradoException();
        }
    }

    public List<Pagamento> findAllByClienteIdAndCartaoId(Integer clienteId, Integer cartaoId) {
        try {
            CartaoDTO cartao = cartaoClient.findById(cartaoId);
            if(!Objects.equals(cartao.getClienteId(), clienteId)) throw new ClienteNaoVinculadoAoCartaoException();

            return pagamentoRepository.findAllByCartaoId(cartao.getClienteId());

        } catch (FeignException.FeignClientException.NotFound ex) {
            throw new CartaoNaoEncontradoException();
        }
    }

}
