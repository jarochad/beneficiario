package br.com.ekan.planosaude.beneficiario.exception;

import java.time.Instant;

import java.util.Optional;

import org.slf4j.MDC;

import org.springframework.http.HttpStatus;

public class ApiErrorResponse {

	private String timestamp = Instant.now().toString();

	private HttpStatus httpStatus = null;

	private Integer errorCode = null;

	private String title = null;

	private String message = null;

	private String transactionId = null;

	private Object details = null;

	final static String MDC_CORRELATION_ID_KEY = "transaction.id";

	public ApiErrorResponse(HttpStatus httpStatus, Integer errorCode, String title, String message, Object details) {

		this.httpStatus = httpStatus;

		this.errorCode = errorCode;

		this.title = title;

		this.message = message;

		this.details = details;

		Optional<String> currentCid = Optional.ofNullable(MDC.get(MDC_CORRELATION_ID_KEY));

		if (currentCid.isPresent()) {

			this.transactionId = currentCid.get();

		} else {

			this.transactionId = null;

		}

	}

	public String getTimestamp() {

		return timestamp;

	}

	public HttpStatus getHttpStatus() {

		return httpStatus;

	}

	public Integer getErrorCode() {

		return errorCode;

	}

	public String getTitle() {

		return title;

	}

	public String getMessage() {

		return message;

	}

	public String getTransactionId() {

		return transactionId;

	}

	public Object getDetails() {

		return details;

	}

}
