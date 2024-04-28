package br.com.ekan.planosaude.beneficiario.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EkanEntityNotFoundException extends RuntimeException {
	
	private HttpStatus status = HttpStatus.NOT_FOUND;
	
	public EkanEntityNotFoundException(String msg) {
		super(msg);
	}
}
