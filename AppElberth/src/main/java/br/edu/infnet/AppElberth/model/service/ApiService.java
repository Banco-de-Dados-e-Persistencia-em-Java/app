package br.edu.infnet.AppElberth.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.AppElberth.clients.ApiElberthClient;

@Service
public class ApiService {

	@Autowired
	private ApiElberthClient apiElberthClient;
	
	public Collection<String> obterLista() {
		
		return apiElberthClient.obterLista();
	}
}
