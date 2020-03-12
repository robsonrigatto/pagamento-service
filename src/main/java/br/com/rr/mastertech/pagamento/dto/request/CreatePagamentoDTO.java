package br.com.rr.mastertech.pagamento.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreatePagamentoDTO {

    @JsonProperty("cartao_id")
    @NotNull
    private Integer idCartao;

    @NotNull
    private String descricao;

    @NotNull
    private Double valor;
}
