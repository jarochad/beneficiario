package br.com.ekan.planosaude.beneficiario.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
public class DocumentoRequest {
	
	@NotBlank(message = "Tipo Documento é obrigario")
	private String tipoDocumento;

	@NotBlank(message = "Descrição é obrigario")
	private String descricao;
	

}
