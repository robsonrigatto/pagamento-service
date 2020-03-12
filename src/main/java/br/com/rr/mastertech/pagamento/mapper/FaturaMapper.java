package br.com.rr.mastertech.pagamento.mapper;

import br.com.rr.mastertech.pagamento.domain.Fatura;
import br.com.rr.mastertech.pagamento.dto.response.FaturaDTO;
import org.springframework.stereotype.Component;

@Component
public class FaturaMapper {

    public FaturaDTO toDTO(Fatura fatura) {
        return FaturaDTO.builder().id(fatura.getId()).valorPago(fatura.getValorPago()).pagoEm(fatura.getDataPagamento()).build();
    }
}
