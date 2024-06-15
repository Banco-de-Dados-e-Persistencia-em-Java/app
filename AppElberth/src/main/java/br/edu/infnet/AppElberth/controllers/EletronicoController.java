package br.edu.infnet.AppElberth.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.AppElberth.model.domain.Eletronico;
import br.edu.infnet.AppElberth.model.service.EletronicoService;

@RestController
public class EletronicoController {
	
	@Autowired
	private EletronicoService eletronicoService;
	
	@GetMapping(value = "/eletronico/lista")
	public Collection<Eletronico> obterLista(){
		return eletronicoService.obterLista();
	}
	
	@GetMapping(value =  "/eletronico/{id}")
	public Eletronico obterPorId(@PathVariable Integer id) {
		return eletronicoService.obterPorId(id);
	}

	@PostMapping(value = "/eletronico/incluir")
	public void incluir(@RequestBody Eletronico eletronico) {
		eletronicoService.incluir(eletronico);
	}

	@DeleteMapping(value = "/eletronico/{id}/excluir")
	public void excluir(@PathVariable Integer id) {
		eletronicoService.excluir(id);
	}

	@GetMapping(value = "/eletronico/lista/{marca}")
	public Collection<Eletronico> obterListaMarca(@PathVariable String marca){
		return eletronicoService.obterListaPorMarca(marca);
	}
}