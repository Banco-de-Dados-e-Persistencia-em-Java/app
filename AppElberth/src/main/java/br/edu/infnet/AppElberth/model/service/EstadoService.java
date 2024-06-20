package br.edu.infnet.AppElberth.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.AppElberth.clients.LocalidadeClient;
import br.edu.infnet.AppElberth.model.domain.Estado;

@Service
public class EstadoService {
	
	@Autowired
	private LocalidadeClient localidadeClient;

	public Collection<Estado> obterLista(){

		return localidadeClient.obterEstados();
	}
}