package br.com.ekan.planosaude.beneficiario.converter;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import br.com.ekan.planosaude.beneficiario.model.Beneficiario;
import br.com.ekan.planosaude.beneficiario.model.BeneficiarioRequest;
import br.com.ekan.planosaude.beneficiario.model.Documento;
import br.com.ekan.planosaude.beneficiario.model.DocumentoRequest;
import br.com.ekan.planosaude.beneficiario.model.DocumentoResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DocumentoConverter {

	private final ModelMapper mapper;
	
	public Documento toEntity(DocumentoRequest request) {
		return mapper.map(request, Documento.class);
		
	}
	
	public List<Documento> toEntityList(List<DocumentoRequest> request) {
		return mapper.map(request,new TypeToken<List<Documento>>() {}.getType());
	}
	
	public List<Documento> toEntityListd(List<Documento> request) {
		return mapper.map(request,new TypeToken<List<Documento>>() {}.getType());
	}
	
	public DocumentoResponse toResponse(Documento documento) {
		return mapper.map(documento, DocumentoResponse.class);
	}
	
	public List<DocumentoResponse> toResponseList(List<Documento> documentos) {
		return mapper.map(documentos,new TypeToken<List<DocumentoResponse>>() {}.getType());
	}
	
	public List<DocumentoRequest> toListaDocumentoRequest(List<Documento> documentos) {
		return mapper.map(documentos,new TypeToken<List<DocumentoResponse>>() {}.getType());
	}
	
	
}
