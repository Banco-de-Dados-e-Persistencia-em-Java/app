package br.edu.infnet.AppElberth.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.AppElberth.model.domain.Produto;
import br.edu.infnet.AppElberth.model.service.ProdutoService;

@RestController
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping(value = "/produto/lista")
	public Collection<Produto> obterLista(){
		return produtoService.obterLista();
	}
	
	@GetMapping(value =  "/produto/{id}")
	public Produto obterPorId(@PathVariable Integer id) {
		return produtoService.obterPorId(id);
	}

	@DeleteMapping(value = "/produto/{id}/excluir")
	public void excluir(@PathVariable Integer id) {
		produtoService.excluir(id);
	}

	@GetMapping(value =  "/produto/{codigo}/codigo")
	public Produto obterPorCodigo(@PathVariable int codigo) {
		return produtoService.obterPorCodigo(codigo);
	}

	@GetMapping(value = "/produto/{vendedorId}/lista")
	public Collection<Produto> obterListaPorVendedor(@PathVariable Integer vendedorId){
		return produtoService.obterListaPorVendedor(vendedorId);
	}
}