package br.com.ekan.planosaude.beneficiario.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EkanBadRequestException extends RuntimeException {
	
	private HttpStatus status = HttpStatus.BAD_REQUEST;
	
	public EkanBadRequestException(String msg) {
		super(msg);
	}
}
