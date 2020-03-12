package br.com.rr.mastertech.pagamento.client;

import br.com.rr.mastertech.pagamento.client.dto.CartaoDTO;
import br.com.rr.mastertech.pagamento.client.dto.UpdateCartaoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("cartao")
public interface CartaoClient {

    @GetMapping("/cartao/id/{id}")
    CartaoDTO findById(@PathVariable Integer id);

    @PatchMapping("/cartao/id/{id}")
    CartaoDTO update(@PathVariable Integer id, @RequestBody UpdateCartaoDTO updateDTO);
}
