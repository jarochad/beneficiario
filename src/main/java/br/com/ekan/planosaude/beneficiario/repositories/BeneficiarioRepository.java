package br.com.ekan.planosaude.beneficiario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ekan.planosaude.beneficiario.entities.Beneficiario;

public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long>{
	

}
