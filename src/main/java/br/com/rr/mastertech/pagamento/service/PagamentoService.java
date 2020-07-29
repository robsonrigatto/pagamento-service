package br.com.rr.mastertech.pagamento.service;

import br.com.rr.mastertech.pagamento.client.CartaoClient;
import br.com.rr.mastertech.pagamento.client.dto.CartaoDTO;
import br.com.rr.mastertech.pagamento.client.exception.CartaoOfflineException;
import br.com.rr.mastertech.pagamento.domain.Pagamento;
import br.com.rr.mastertech.pagamento.exception.CartaoInativoException;
import br.com.rr.mastertech.pagamento.exception.CartaoNaoEncontradoException;
import br.com.rr.mastertech.pagamento.exception.ClienteNaoVinculadoAoCartaoException;
import br.com.rr.mastertech.pagamento.mapper.PagamentoMapper;
import br.com.rr.mastertech.pagamento.repository.PagamentoRepository;
import com.netflix.hystrix.exception.HystrixRuntimeException;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoMapper mapper;

    @Autowired
    private PagamentoRepository repository;

    @Autowired
    private CartaoClient cartaoClient;

    public Pagamento create(String descricao, Integer cartaoId, Double valor) {
        try {
            CartaoDTO cartao = cartaoClient.findById(cartaoId);
            if(!cartao.getAtivo()) throw new CartaoInativoException();

            Pagamento entity = mapper.toPagamento(descricao, cartao, valor);
            return repository.save(entity);

        } catch (HystrixRuntimeException ex) {
            if(ex.getCause() instanceof FeignException.NotFound) {
                throw new CartaoNaoEncontradoException();
            }
            throw new CartaoOfflineException();
        }
    }

    public List<Pagamento> findAllByCartaoId(Integer cartaoId) {
        try {
            CartaoDTO cartao = cartaoClient.findById(cartaoId);
            return repository.findAllByCartaoId(cartao.getClienteId());

        } catch (HystrixRuntimeException ex) {
            if(ex.getCause() instanceof FeignException.NotFound) {
                throw new CartaoNaoEncontradoException();
            }
            throw new CartaoOfflineException();
        }
    }

    public List<Pagamento> findAllByClienteIdAndCartaoId(Integer clienteId, Integer cartaoId) {
        try {
            CartaoDTO cartao = cartaoClient.findById(cartaoId);
            if(!Objects.equals(cartao.getClienteId(), clienteId)) throw new ClienteNaoVinculadoAoCartaoException();

            return repository.findAllByCartaoId(cartao.getClienteId());

        } catch (HystrixRuntimeException ex) {
            if(ex.getCause() instanceof FeignException.NotFound) {
                throw new CartaoNaoEncontradoException();
            }
            throw new CartaoOfflineException();
        }
    }

}
