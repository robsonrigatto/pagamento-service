package br.com.rr.mastertech.pagamento.configuration;

import br.com.rr.mastertech.pagamento.client.decoder.ClienteErrorDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//public class ClienteClientConfiguration {
//
//    @Bean
//    public ErrorDecoder getClienteErrorDecoder() {
//        return new ClienteErrorDecoder();
//    }
//}