package br.edu.infnet.elberthAPI.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.elberthAPI.model.domain.Endereco;
import br.edu.infnet.elberthAPI.model.domain.Estado;
import br.edu.infnet.elberthAPI.model.domain.Municipio;
import br.edu.infnet.elberthAPI.model.service.EnderecoService;
import br.edu.infnet.elberthAPI.model.service.LocalidadeService;

@RestController
public class ApiController {
	
	@Autowired
	private EnderecoService enderecoService;
	@Autowired
	private LocalidadeService localidadeService;
	
	@GetMapping(value = "/{cep}")
	public Endereco obterEnderecoPorCep(@PathVariable String cep) {
		return enderecoService.obterPorCep(cep);
	}
	
	@GetMapping(value = "/estados")
	public Collection<Estado> obterEstados(){
		return localidadeService.obterEstados();
	}
	
	@GetMapping(value = "/{uf}/municipios")
	public Collection<Municipio> obterMunicipios(@PathVariable Integer uf){
		return localidadeService.obterMunicipios(uf);
	}
}