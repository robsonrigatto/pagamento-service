package br.com.rr.mastertech.pagamento.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "cartao não encontrado")
public class CartaoNaoEncontradoException extends RuntimeException {
}
