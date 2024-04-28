package br.com.ekan.planosaude.beneficiario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.com.ekan.planosaude.beneficiario")
public class BeneficiarioApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(BeneficiarioApplication.class, args);
	}

}
