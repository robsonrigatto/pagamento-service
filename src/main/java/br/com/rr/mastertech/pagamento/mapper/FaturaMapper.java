package br.com.rr.mastertech.pagamento.mapper;

import br.com.rr.mastertech.pagamento.domain.Fatura;
import br.com.rr.mastertech.pagamento.dto.response.FaturaDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class FaturaMapper {

    public FaturaDTO toFaturaDTO(Fatura fatura) {
        FaturaDTO dto = new FaturaDTO();
        dto.setId(fatura.getId());
        dto.setValorPago(fatura.getValorPago());
        dto.setPagoEm(fatura.getDataPagamento());

        return dto;
    }

    public Fatura toFatura(Integer clienteId, Integer cartaoId, Double valorPago) {
        Fatura fatura = new Fatura();

        fatura.setClienteId(clienteId);
        fatura.setCartaoId(cartaoId);
        fatura.setValorPago(valorPago);
        fatura.setDataPagamento(LocalDate.now());

        return fatura;
    }
}
