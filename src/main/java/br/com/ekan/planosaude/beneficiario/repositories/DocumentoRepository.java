package br.com.ekan.planosaude.beneficiario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ekan.planosaude.beneficiario.entities.Documento;

public interface DocumentoRepository extends JpaRepository<Documento, Long>{
	
	

}
