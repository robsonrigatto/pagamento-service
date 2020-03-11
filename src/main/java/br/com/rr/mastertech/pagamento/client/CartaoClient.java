package br.com.rr.mastertech.pagamento.client;

import br.com.rr.mastertech.pagamento.client.dto.CartaoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("cartao")
public interface CartaoClient {

    @GetMapping("/cartao/id/{id}")
    CartaoDTO findById(@PathVariable Integer id);
}
