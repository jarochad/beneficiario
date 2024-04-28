package br.com.ekan.planosaude.beneficiario.service;

import java.util.List;
import java.util.Objects;

import org.hibernate.grammars.hql.HqlParser.IsEmptyPredicateContext;
import org.springframework.stereotype.Service;

import br.com.ekan.planosaude.beneficiario.converter.BeneficiarioConverter;
import br.com.ekan.planosaude.beneficiario.exception.EkanEntityNotFoundException;
import br.com.ekan.planosaude.beneficiario.model.Beneficiario;
import br.com.ekan.planosaude.beneficiario.model.BeneficiarioRequest;
import br.com.ekan.planosaude.beneficiario.model.BeneficiarioResponse;
import br.com.ekan.planosaude.beneficiario.repositories.BeneficiarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BeneficiarioServiceImpl implements BeneficiarioService{
	
	private final BeneficiarioRepository repository;
	
	private final BeneficiarioConverter converter;	
	

	@Override
	public List<BeneficiarioResponse> findAll() {
		return converter.toResponseList(repository.findAll());
	}

	@Override
	public BeneficiarioResponse findByUuid(String uuid) {
		return converter.toResponse(repository.findByUuid(uuid));
	}

	@Override
	public BeneficiarioResponse create(BeneficiarioRequest beneficiario) {
		return converter.toResponse(repository.save(converter.toEntity(beneficiario)));
	}

	@Override
	public void remove(String uuid) {
			Beneficiario beneficiario = repository.findByUuid(uuid);
			if(Objects.isNull(beneficiario)) {
				throw new EkanEntityNotFoundException("Beneficiario nao Existe");
			}	
			repository.delete(beneficiario);
	
		
	}
	
	
	
	

}
