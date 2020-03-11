package br.com.rr.mastertech.pagamento.client.dto;

import lombok.Data;

@Data
public class CartaoDTO {

    private Integer id;
    private String numero;
    private Integer clienteId;
    private Boolean ativo;
}
