package br.com.rr.mastertech.pagamento.mapper;

import br.com.rr.mastertech.pagamento.client.dto.CartaoDTO;
import br.com.rr.mastertech.pagamento.domain.Pagamento;
import br.com.rr.mastertech.pagamento.dto.response.PagamentoDTO;
import org.springframework.stereotype.Component;

@Component
public class PagamentoMapper {

    public PagamentoDTO toPagamentoDTO(Pagamento entity) {
        PagamentoDTO dto = new PagamentoDTO();
        dto.setId(entity.getId());
        dto.setDescricao(entity.getDescricao());
        dto.setIdCartao(entity.getCartaoId());
        dto.setValor(entity.getValor());

        return dto;
    }

    public Pagamento toPagamento(String descricao, CartaoDTO cartao, Double valor) {
        Pagamento pagamento = new Pagamento();

        pagamento.setDescricao(descricao);
        pagamento.setCartaoId(cartao.getId());
        pagamento.setValor(valor);

        return pagamento;
    }
}
