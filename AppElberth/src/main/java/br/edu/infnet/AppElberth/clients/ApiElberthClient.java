package br.edu.infnet.AppElberth.clients;

import java.util.Collection;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.AppElberth.model.domain.Endereco;

@FeignClient(url = "http://localhost:8081", name = "apiElberth")
public interface ApiElberthClient {

	@GetMapping(value = "/listagem")
	Collection<String> obterLista();
	
	@GetMapping(value = "/{cep}")
	public Endereco obterEnderecoPorCep(@PathVariable String cep);	
	
	//estados
	
	//municipios por estado
}