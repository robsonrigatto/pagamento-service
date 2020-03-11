package br.com.rr.mastertech.pagamento.service;

import br.com.rr.mastertech.pagamento.client.CartaoClient;
import br.com.rr.mastertech.pagamento.client.dto.CartaoDTO;
import br.com.rr.mastertech.pagamento.domain.Pagamento;
import br.com.rr.mastertech.pagamento.exception.CartaoInativoException;
import br.com.rr.mastertech.pagamento.exception.CartaoNaoEncontradoException;
import br.com.rr.mastertech.pagamento.repository.PagamentoRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Pagamento> findAllByIdCartao(Integer idCartao) {
        try {
            CartaoDTO cartao = cartaoClient.findById(idCartao);
            return pagamentoRepository.findAllByIdCartao(cartao.getClienteId());

        } catch (FeignException.FeignClientException.NotFound ex) {
            throw new CartaoNaoEncontradoException();
        }
    }

}
