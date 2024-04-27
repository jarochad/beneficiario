package br.com.ekan.planosaude.beneficiario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ekan.planosaude.beneficiario.entities.Documento;
import br.com.ekan.planosaude.beneficiario.repositories.DocumentoRepository;

@Service
public class DocumentoService {

		
		@Autowired
		private DocumentoRepository repository;
		
		public List<Documento> buscarTodos(){
			return repository.findAll();
		}
		
		public Optional<Documento> buscarPorId(Long id){
			return repository.findById(id);
		}
		
		public Documento inserir(Documento documento) {
			return repository.save(documento);
		}
		
		public void deletar(Long id) {
				repository.deleteById(id);
		}

}
