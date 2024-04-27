package br.com.ekan.planosaude.beneficiario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ekan.planosaude.beneficiario.entities.Beneficiario;
import br.com.ekan.planosaude.beneficiario.repositories.BeneficiarioRepository;

@Service
public class BeneficiarioService {
	
	@Autowired
	private BeneficiarioRepository repository;
	
	public List<Beneficiario> buscarTodos(){
		return repository.findAll();
	}
	
	public Optional<Beneficiario> buscarPorId(Long id){
		return repository.findById(id);
	}
	
	public Beneficiario inserir(Beneficiario beneficiario) {
		return repository.save(beneficiario);
	}
	
	public void deletar(Long id) {
			repository.deleteById(id);
	}
	
	
	
	

}
