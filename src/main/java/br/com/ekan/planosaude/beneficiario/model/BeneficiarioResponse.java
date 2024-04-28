package br.com.ekan.planosaude.beneficiario.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
public class BeneficiarioResponse {
	
	private String nome;
	
	private String telefone;
	
	private String dataNascimento;
	
	private String uuid;
	
	private List<DocumentoResponse> documentos;
}
