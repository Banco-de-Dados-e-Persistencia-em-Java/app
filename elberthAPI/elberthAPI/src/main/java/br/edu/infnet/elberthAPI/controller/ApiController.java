package br.edu.infnet.elberthAPI.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.elberthAPI.model.domain.Endereco;
import br.edu.infnet.elberthAPI.model.service.EnderecoService;

@RestController
public class ApiController {
	
	@Autowired
	private EnderecoService enderecoService;

	@GetMapping(value = "/listagem")
	public Collection<String> obterLista(){
		return new ArrayList<String>(
					Arrays.asList("Elberth", "Lins", "Costa", "de", "Moraes")
				);
	}
	
	@GetMapping(value = "/{cep}")
	public Endereco obterEnderecoPorCep(@PathVariable String cep) {
		return enderecoService.obterPorCep(cep);
	}
	
	//estados
	
	//municipios por estado
}