package br.com.rr.mastertech.pagamento.configuration;

import br.com.rr.mastertech.pagamento.client.decoder.CartaoErrorDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//public class CartaoClientConfiguration {
//
//    @Bean
//    public ErrorDecoder getCartaoErrorDecoder() {
//        return new CartaoErrorDecoder();
//    }
//}
