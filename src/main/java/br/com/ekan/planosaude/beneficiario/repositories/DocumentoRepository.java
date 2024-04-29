package br.com.ekan.planosaude.beneficiario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import br.com.ekan.planosaude.beneficiario.model.Documento;

public interface DocumentoRepository extends JpaRepository<Documento, Long>{
	
	Documento findByUuid(@Param("uuid") String uuid);
	
	

}
