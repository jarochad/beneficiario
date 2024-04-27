package br.com.ekan.planosaude.beneficiario.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.ekan.planosaude.beneficiario.entities.Documento;
import br.com.ekan.planosaude.beneficiario.service.DocumentoService;

@RestController
@RequestMapping(value = "/documento")
public class DocumentoController {
	
	@Autowired
	private DocumentoService service;
	

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Documento inserir(@RequestBody Documento documento) {
		documento.setDataAtualizacao(new Date());
		documento.setDataInclusao(new Date());
		return service.inserir(documento);
	}
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<Documento> buscarTodos(){
		return service.buscarTodos();
	}
	
	@GetMapping(value = "/{id}")
	public Documento buscarPorId(@PathVariable("id") Long id){
		return service.buscarPorId(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Documento não encontrado"));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deletar (@PathVariable("id") Long id){
		service.buscarPorId(id)
		.map(Documento -> {
			service.deletar(Documento.getId());
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Não foi possivel deletar Documento"));
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void atualizar(@RequestBody Documento documento) {
		service.buscarPorId(documento.getId())
		.map(beneficiarioBase -> {
			service.inserir(documento);
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Documento não encontrado"));
	}
}
