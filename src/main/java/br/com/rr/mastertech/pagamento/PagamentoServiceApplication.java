package br.com.rr.mastertech.pagamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PagamentoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PagamentoServiceApplication.class, args);
	}

}
