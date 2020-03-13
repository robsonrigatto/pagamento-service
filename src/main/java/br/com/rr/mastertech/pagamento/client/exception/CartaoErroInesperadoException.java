package br.com.rr.mastertech.pagamento.client.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "serviço de cartao com erro inesperado")
public class CartaoErroInesperadoException extends RuntimeException {
}
