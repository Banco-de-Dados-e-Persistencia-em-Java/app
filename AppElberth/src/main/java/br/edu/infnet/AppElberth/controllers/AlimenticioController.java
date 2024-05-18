package br.edu.infnet.AppElberth.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.AppElberth.model.domain.Alimenticio;
import br.edu.infnet.AppElberth.model.service.AlimenticioService;

@RestController
public class AlimenticioController {
	
	@Autowired
	private AlimenticioService alimenticioService;
	
	@GetMapping(value = "/alimenticio/lista")
	public Collection<Alimenticio> obterLista(){
		return alimenticioService.obterLista();
	}
	
	@GetMapping(value =  "/alimenticio/{id}")
	public Alimenticio obterPorId(@PathVariable Integer id) {
		return alimenticioService.obterPorId(id);
	}

	@PostMapping(value = "/alimenticio/incluir")
	public void incluir(@RequestBody Alimenticio alimenticio) {
		alimenticioService.incluir(alimenticio);
	}

	@DeleteMapping(value = "/alimenticio/{id}/excluir")
	public void excluir(@PathVariable Integer id) {
		alimenticioService.excluir(id);
	}
}