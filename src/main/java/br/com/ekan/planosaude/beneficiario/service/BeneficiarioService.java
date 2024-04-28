package br.com.ekan.planosaude.beneficiario.service;

import java.util.List;

import br.com.ekan.planosaude.beneficiario.model.BeneficiarioResponse;
import br.com.ekan.planosaude.beneficiario.model.BeneficiarioRequest;

public interface BeneficiarioService {
	
	public List<BeneficiarioResponse> findAll();
	
	public BeneficiarioResponse findByUuid(String uuid);
	
	public BeneficiarioResponse create(BeneficiarioRequest beneficiario); 
	
	public void remove(String uuid); 

}
