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

	public Beneficiario toEntity(BeneficiarioRequest beneficiarioRequest) {
			Beneficiario beneficiario = mapper.map(beneficiarioRequest, Beneficiario.class);
			List<Documento> documentos = documentoConverter.toEntityList(beneficiarioRequest.getDocumentos());
			documentos.stream().forEach(documento -> {
				documento.setBeneficiario(beneficiario);
			});
			beneficiario.setDocumentos(documentos);
		return beneficiario;
	}

	public BeneficiarioResponse toResponse(Beneficiario beneficiario) {
		return mapper.map(beneficiario, BeneficiarioResponse.class);
	}

	public List<BeneficiarioResponse> toResponseList(List<Beneficiario> beneficiarios) {
		return mapper.map(beneficiarios, new TypeToken<List<BeneficiarioResponse>>() {
		}.getType());
	}

}
