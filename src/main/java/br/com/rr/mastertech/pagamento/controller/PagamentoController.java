package br.com.rr.mastertech.pagamento.controller;

import br.com.rr.mastertech.pagamento.domain.Pagamento;
import br.com.rr.mastertech.pagamento.dto.request.CreatePagamentoDTO;
import br.com.rr.mastertech.pagamento.dto.response.PagamentoDTO;
import br.com.rr.mastertech.pagamento.exception.CartaoNaoEncontradoException;
import br.com.rr.mastertech.pagamento.mapper.PagamentoMapper;
import br.com.rr.mastertech.pagamento.service.PagamentoService;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @Autowired
    private PagamentoMapper pagamentoMapper;

    @PostMapping
    public ResponseEntity<PagamentoDTO> create(@Valid @RequestBody CreatePagamentoDTO createDTO) {
        try {
            Pagamento entity = pagamentoService.create(createDTO.getDescricao(), createDTO.getIdCartao(), createDTO.getValor());
            return new ResponseEntity<>(pagamentoMapper.toPagamentoDTO(entity), HttpStatus.CREATED);

        } catch (FeignException.FeignClientException.NotFound ex) {
            throw new CartaoNaoEncontradoException();
        }
    }

    @GetMapping("/{idCartao}")
    public ResponseEntity<List<PagamentoDTO>> findAllByIdCartao(@PathVariable Integer idCartao) {
        List<Pagamento> entities = pagamentoService.findAllByCartaoId(idCartao);
        List<PagamentoDTO> dtos = entities.stream().map(e -> pagamentoMapper.toPagamentoDTO(e))
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }
}
