package br.com.rr.mastertech.pagamento.client.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.SERVICE_UNAVAILABLE, reason = "serviço de cartão indisponível")
public class CartaoOfflineException extends RuntimeException {
}
