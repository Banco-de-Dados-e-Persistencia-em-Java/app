package br.edu.infnet.AppElberth.clients;

import java.util.Collection;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.AppElberth.model.domain.Estado;

@FeignClient(url = "https://servicodados.ibge.gov.br/api/v1/localidades", name = "ibge")
public interface LocalidadeClient {

	@GetMapping(value = "/estados?orderBy=nome")
	Collection<Estado> obterEstados();
}