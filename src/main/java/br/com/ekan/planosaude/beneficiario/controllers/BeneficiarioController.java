package br.com.ekan.planosaude.beneficiario.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ekan.planosaude.beneficiario.model.BeneficiarioResponse;
import br.com.ekan.planosaude.beneficiario.model.BeneficiarioRequest;
import br.com.ekan.planosaude.beneficiario.service.BeneficiarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/beneficiarios")
@RequiredArgsConstructor
public class BeneficiarioController {
	
	
	private final BeneficiarioService service;
	
	@PostMapping(value = "create")
	@ResponseStatus(code = HttpStatus.CREATED)
	@Operation(summary = "Cria um novo Beneficiario", description = "Para executar a criação de um novo beneficiario é necessário autenticar.")
	@ApiResponse(responseCode = "409", description = "Error undefined",content =@Content(schema = @Schema(ref = "ApiErrorResponse"), mediaType = MediaType.APPLICATION_JSON_VALUE))
	public ResponseEntity<BeneficiarioResponse> create (@Valid @RequestBody BeneficiarioRequest beneficiario) {
		return ResponseEntity.ok(service.create(beneficiario)); 
		
	}

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<List<BeneficiarioResponse>> findAll(){
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping(value = "findByUuid/{uuid}")
	public ResponseEntity<BeneficiarioResponse> findByUuid(@PathVariable("uuid") String id){
		return ResponseEntity.ok(service.findByUuid(id));
				
	}
	
	@DeleteMapping("remove/{uuid}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> remove(@PathVariable("uuid") String id) {
		 service.remove(id);
		 return ResponseEntity.status(HttpStatus.OK).build();
		
	}
	
	@PutMapping("update/{uuid}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public ResponseEntity<BeneficiarioResponse> replace(@PathVariable("uuid")Long uuid, @RequestBody BeneficiarioRequest beneficiario) {
		return ResponseEntity.ok(service.create(beneficiario));
		
	}

}
