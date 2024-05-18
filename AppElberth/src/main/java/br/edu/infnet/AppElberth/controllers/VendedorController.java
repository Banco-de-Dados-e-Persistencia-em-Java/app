package br.edu.infnet.AppElberth.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.AppElberth.model.domain.Vendedor;
import br.edu.infnet.AppElberth.model.service.VendedorService;

@RestController
public class VendedorController {
	
	@Autowired
	private VendedorService vendedorService;
	
	@GetMapping(value = "/vendedor/lista")
	public Collection<Vendedor> obterLista(){
		return vendedorService.obterLista();
	}
	
	@GetMapping(value =  "/vendedor/{id}")
	public Vendedor obterPorId(@PathVariable Integer id) {
		return vendedorService.obterPorId(id);
	}

	@PostMapping(value = "/vendedor/incluir")
	public void incluir(@RequestBody Vendedor vendedor) {
		vendedorService.incluir(vendedor);
	}

	@DeleteMapping(value = "/vendedor/{id}/excluir")
	public void excluir(@PathVariable Integer id) {
		vendedorService.excluir(id);
	}
}