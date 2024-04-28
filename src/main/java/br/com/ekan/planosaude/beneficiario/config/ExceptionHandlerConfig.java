package br.com.ekan.planosaude.beneficiario.config;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.ekan.planosaude.beneficiario.exception.ApiErrorResponse;
import br.com.ekan.planosaude.beneficiario.exception.EkanEntityNotFoundException;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerConfig {
	
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> handleMethodArgumentNotValidExceptions(MethodArgumentNotValidException ex) {
        return ResponseEntity.badRequest().body(getErrorResponse(ex));
    }
    
    @ExceptionHandler(EkanEntityNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleEkanEntityNotFoundException(EkanEntityNotFoundException ex) {
        return ResponseEntity.badRequest().body(
        		new ApiErrorResponse(
                        ex.getStatus()
        				, ex.getStatus().value()
                        , "Requisição invalida"
                        , ex.getMessage()
                        , null)
        		);
    }
    
    /**
     * Get ErrorResponse for MethodArgumentNotValidException.
     * @param ex is MethodArgumentNotValidException.
     * @param status is HttpStatus.
     * @return ErrorResponse is response.
     */
    public ApiErrorResponse getErrorResponse(final MethodArgumentNotValidException ex) {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(
                HttpStatus.BAD_REQUEST
                , HttpStatus.BAD_REQUEST.value()
                , "Requisição invalida"
                , "Dados invalidos"
                , getErrors(ex));
        
        log.error("Error request {}", apiErrorResponse.toString());
        
        return apiErrorResponse;
    }
    
    /**
     * Get List errors for MethodArgumentNotValidException.
     * @param ex is MethodArgumentNotValidException.
     * @return List list errors.
     */
    public List<String> getErrors(final MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors().stream()
                .sorted((FieldError o1, FieldError o2) -> o1.getField().compareTo(o2.getField()))
                .map(error -> String.valueOf(error.getDefaultMessage()))
                .collect(Collectors.toList());
    }  

}
