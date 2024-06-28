package br.edu.infnet.AppElberth.clients;

import java.util.Collection;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.AppElberth.model.domain.Endereco;
import br.edu.infnet.AppElberth.model.domain.Estado;
import br.edu.infnet.AppElberth.model.domain.Municipio;

@FeignClient(url = "http://localhost:8081", name = "apiElberth")
public interface ApiElberthClient {
	
	@GetMapping(value = "/{cep}")
	public Endereco obterEnderecoPorCep(@PathVariable String cep);	
	
	@GetMapping(value = "/estados")
	public Collection<Estado> obterEstados();
	
	@GetMapping(value = "/{uf}/municipios")
	public Collection<Municipio> obterMunicipios(@PathVariable Integer uf);
}
