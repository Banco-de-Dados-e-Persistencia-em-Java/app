package br.edu.infnet.AppElberth.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.AppElberth.clients.ApiElberthClient;
import br.edu.infnet.AppElberth.model.domain.Endereco;
import br.edu.infnet.AppElberth.model.domain.Estado;
import br.edu.infnet.AppElberth.model.domain.Municipio;

@Service
public class ApiService {

	@Autowired
	private ApiElberthClient apiElberthClient;
		
	public Endereco obterPorCep(String cep) {
		return apiElberthClient.obterEnderecoPorCep(cep);
	}
	
	public Collection<Estado> obterEstados(){
		return apiElberthClient.obterEstados();
	}
	
	public Collection<Municipio> obterMunicipios(@PathVariable Integer uf){
		return apiElberthClient.obterMunicipios(uf);
	}
}