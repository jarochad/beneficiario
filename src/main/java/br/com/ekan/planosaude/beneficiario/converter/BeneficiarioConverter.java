package br.com.ekan.planosaude.beneficiario.converter;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import br.com.ekan.planosaude.beneficiario.model.Beneficiario;
import br.com.ekan.planosaude.beneficiario.model.BeneficiarioRequest;
import br.com.ekan.planosaude.beneficiario.model.BeneficiarioResponse;
import br.com.ekan.planosaude.beneficiario.model.Documento;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BeneficiarioConverter {

	private final ModelMapper mapper;
	
	private final DocumentoConverter documentoConverter;
	
	public Beneficiario toEntity(BeneficiarioRequest request) {
		Beneficiario b = mapper.map(request, Beneficiario.class);
		List<Documento> d = documentoConverter.toEntityList(request.getDocumentos());
		for (Documento documento : d) {
				documento.setBeneficiario(b);
		}
		b.setDocumentos(d);
		return b;
		
	}
	
	public BeneficiarioResponse toResponse(Beneficiario beneficiario) {
		return mapper.map(beneficiario, BeneficiarioResponse.class);
	}
	
	public List<BeneficiarioResponse> toResponseList(List<Beneficiario> beneficiarios) {
		return mapper.map(beneficiarios,new TypeToken<List<BeneficiarioResponse>>() {}.getType());
	}

}
