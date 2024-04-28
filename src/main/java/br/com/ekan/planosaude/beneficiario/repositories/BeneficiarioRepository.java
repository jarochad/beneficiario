package br.com.ekan.planosaude.beneficiario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.ekan.planosaude.beneficiario.model.Beneficiario;

@Repository
@Transactional
public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long>{
	
	
	Beneficiario findByUuid(@Param("uuid") String uuid);

}
