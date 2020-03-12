package br.com.rr.mastertech.pagamento.repository;

import br.com.rr.mastertech.pagamento.domain.Fatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaturaRepository extends JpaRepository<Fatura, Integer> {
}
