package br.com.rr.mastertech.pagamento.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class FaturaDTO {

    private Integer id;
    private Double valorPago;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "America/Sao_Paulo")
    private LocalDate pagoEm;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public LocalDate getPagoEm() {
        return pagoEm;
    }

    public void setPagoEm(LocalDate pagoEm) {
        this.pagoEm = pagoEm;
    }
}
