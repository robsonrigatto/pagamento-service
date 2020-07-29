package br.com.rr.mastertech.pagamento.mapper;

import br.com.rr.mastertech.pagamento.domain.Pagamento;
import br.com.rr.mastertech.pagamento.dto.response.PagamentoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class PagamentoMapperTest {

    @Autowired
    private PagamentoMapper mapper;

    @Test
    public void entityToDTOTest() {
        Pagamento pagamento = new Pagamento();
        pagamento.setId(1); pagamento.setDescricao("descricao"); pagamento.setCartaoId(2); pagamento.setValor(10.5);
        PagamentoDTO dto = mapper.toPagamentoDTO(pagamento);

        assertNotNull(dto);
        assertEquals(1, dto.getId());
        assertEquals(10.5, dto.getValor());
        assertEquals(2, dto.getIdCartao());
    }
}
