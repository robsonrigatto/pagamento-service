package br.com.rr.mastertech.pagamento.controller;

import br.com.rr.mastertech.pagamento.domain.Pagamento;
import br.com.rr.mastertech.pagamento.dto.response.FaturaDTO;
import br.com.rr.mastertech.pagamento.dto.response.PagamentoDTO;
import br.com.rr.mastertech.pagamento.dto.response.StatusDTO;
import br.com.rr.mastertech.pagamento.mapper.PagamentoMapper;
import br.com.rr.mastertech.pagamento.service.FaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/fatura")
public class FaturaController {

    @Autowired
    private PagamentoMapper pagamentoMapper;

    @Autowired
    private FaturaService faturaService;

    @GetMapping("/{clienteId}/{cartaoId}")
    public List<PagamentoDTO> findByClienteAndCartao(@PathVariable Integer clienteId, @PathVariable Integer cartaoId) {
        List<Pagamento> pagamentos = faturaService.getFatura(clienteId, cartaoId);
        return pagamentos.stream().map(e -> pagamentoMapper.toPagamentoDTO(e))
                .collect(Collectors.toList());
    }

    @PostMapping("/{clienteId}/{cartaoId}/pagar")
    public FaturaDTO pagar(@PathVariable Integer clienteId, @PathVariable Integer cartaoId) {
        return faturaService.pagar(clienteId, cartaoId);
    }

    @PostMapping("/{clienteId}/{cartaoId}/expirar")
    public StatusDTO expirar(@PathVariable Integer clienteId, @PathVariable Integer cartaoId) {
        faturaService.expirar(clienteId, cartaoId);
        return new StatusDTO("ok");
    }

}