package br.com.rr.mastertech.pagamento.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;


public class CreatePagamentoDTO {

    @JsonProperty("cartao_id")
    @NotNull
    private Integer idCartao;

    @NotNull
    private String descricao;

    @NotNull
    private Double valor;

    public Integer getIdCartao() {
        return idCartao;
    }

    public void setIdCartao(Integer idCartao) {
        this.idCartao = idCartao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
