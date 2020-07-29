package br.com.rr.mastertech.pagamento.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PagamentoDTO {

    private Integer id;

    @JsonProperty("cartao_id")
    private Integer idCartao;

    private String descricao;

    private Double valor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
