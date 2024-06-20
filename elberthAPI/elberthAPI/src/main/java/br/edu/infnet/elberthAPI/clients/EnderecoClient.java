package br.edu.infnet.elberthAPI.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.elberthAPI.model.domain.Endereco;

@FeignClient(url = "https://viacep.com.br/ws", name = "viaCep")
public interface EnderecoClient {

	@GetMapping(value = "/{cep}/json/")
	Endereco obterPorCep(@PathVariable String cep);
}