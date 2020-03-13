package br.com.rr.mastertech.pagamento.client.decoder;

import br.com.rr.mastertech.pagamento.client.exception.ClienteErroInesperadoException;
import br.com.rr.mastertech.pagamento.client.exception.ClienteNaoEncontradoException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;

//public class ClienteErrorDecoder implements ErrorDecoder {
//
//    @Override
//    public Exception decode(String s, Response response) {
//        if(response.status() == HttpStatus.NOT_FOUND.value()) {
//            return new ClienteNaoEncontradoException();
//        }
//        return new ClienteErroInesperadoException();
//    }
//}
