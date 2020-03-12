package br.com.rr.mastertech.pagamento.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Fatura {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "ID_CARTAO")
    private Integer cartaoId;

    @Column(name = "ID_CLIENTE")
    private Integer clienteId;

    private Double valorPago;

    @Column(name = "DATA_PAGAMENTO")
    private LocalDate dataPagamento;

}
