package br.com.rr.mastertech.pagamento.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pagamento {

    @Id
    @GeneratedValue
    private Integer id;

    private String descricao;

    @Column(name = "ID_CARTAO")
    private Integer cartaoId;

    private Double valor;
}
