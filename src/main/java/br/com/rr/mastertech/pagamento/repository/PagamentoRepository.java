package br.com.rr.mastertech.pagamento.repository;

import br.com.rr.mastertech.pagamento.domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

    List<Pagamento> findAllByCartaoId(Integer cartaoId);

    long deleteByCartaoId(Integer cartaoId);
}
