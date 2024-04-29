package br.com.ekan.planosaude.beneficiario.service;

import java.util.List;
import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import br.com.ekan.planosaude.beneficiario.converter.BeneficiarioConverter;
import br.com.ekan.planosaude.beneficiario.converter.DocumentoConverter;
import br.com.ekan.planosaude.beneficiario.exception.EkanEntityNotFoundException;
import br.com.ekan.planosaude.beneficiario.model.Beneficiario;
import br.com.ekan.planosaude.beneficiario.model.BeneficiarioRequest;
import br.com.ekan.planosaude.beneficiario.model.BeneficiarioResponse;
import br.com.ekan.planosaude.beneficiario.model.Documento;
import br.com.ekan.planosaude.beneficiario.repositories.BeneficiarioRepository;
import br.com.ekan.planosaude.beneficiario.repositories.DocumentoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BeneficiarioServiceImpl implements BeneficiarioService {

	private final BeneficiarioRepository repository;
	private final DocumentoRepository documentoRepository;
	private final BeneficiarioConverter converter;
	private final DocumentoConverter docConverter;

	private final ModelMapper mapper;

	public List<BeneficiarioResponse> findAll() {
		return converter.toResponseList(repository.findAll());
	}

	public BeneficiarioResponse findByUuid(String uuid) {
		Beneficiario beneficiario = repository.findByUuid(uuid);
		if (Objects.isNull(beneficiario)) {
			throw new EkanEntityNotFoundException("Beneficiario nao Existe");
		}
		return converter.toResponse(beneficiario);
	}

	public BeneficiarioResponse create(BeneficiarioRequest beneficiario) {
		return converter.toResponse(repository.saveAndFlush(converter.toEntity(beneficiario)));
	}

	public void remove(String uuid) {
		findByUuid(uuid);
		repository.delete(repository.findByUuid(uuid));
	}

	public BeneficiarioResponse update(String uuid, BeneficiarioRequest beneficiarioUpdate) {

		findByUuid(uuid);

		Beneficiario beneficiarioBase = repository.findByUuid(uuid);

		mapper.map(beneficiarioUpdate, beneficiarioBase);

		if (!CollectionUtils.isEmpty(beneficiarioUpdate.getDocumentos())) {
			if (!CollectionUtils.isEmpty(beneficiarioBase.getDocumentos())) {
				beneficiarioBase.getDocumentos().stream().forEach(doc -> {
					documentoRepository.delete(doc);
				});

			}
			List<Documento> documentos = docConverter.toEntityList(beneficiarioUpdate.getDocumentos());

			documentos.stream().forEach(docEntity -> {
				docEntity.setBeneficiario(beneficiarioBase);
			});
			beneficiarioBase.setDocumentos(documentos);
		}

		return converter.toResponse(repository.saveAndFlush(beneficiarioBase));
	}

}
