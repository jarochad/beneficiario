package br.com.ekan.planosaude.beneficiario.controllers;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
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

import br.com.ekan.planosaude.beneficiario.entities.Beneficiario;
import br.com.ekan.planosaude.beneficiario.service.BeneficiarioService;

@RestController
@RequestMapping(value = "/beneficiarios")
public class BeneficiarioController {
	
	@Autowired
	BeneficiarioService service;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Beneficiario inserir(@RequestBody Beneficiario beneficiario) {
		beneficiario.setDataAtualizacao(new Date());
		beneficiario.setDataInclusao(new Date());
		Beneficiario save = service.inserir(beneficiario);
		return save;
	}

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<Beneficiario> buscarTodos(){
		return service.buscarTodos();
	}
	
	@GetMapping(value = "/{id}")
	public Beneficiario buscarPorId(@PathVariable("id") Long id){
		return service.buscarPorId(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Beneficiario não encontrado"));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deletar (@PathVariable("id") Long id){
		service.buscarPorId(id)
		.map(beneficiario -> {
			service.deletar(beneficiario.getId());
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Não foi possivel deletar benefeiciario"));
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void atualizar(@PathVariable("id")Long id, @RequestBody Beneficiario beneficiario) {
		service.buscarPorId(id)
		.map(beneficiarioBase -> {
			modelMapper.map(beneficiario, beneficiarioBase);
			beneficiario.setDataAtualizacao(new Date());
			service.inserir(beneficiario);
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Beneficiario não encontrado"));
	}
		

}
