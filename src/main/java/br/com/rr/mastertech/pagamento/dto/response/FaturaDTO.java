package br.com.rr.mastertech.pagamento.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class FaturaDTO {

    private Integer id;
    private Double valorPago;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "America/Sao_Paulo")
    private LocalDate pagoEm;
}
