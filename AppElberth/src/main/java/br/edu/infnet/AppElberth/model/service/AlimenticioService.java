package br.edu.infnet.AppElberth.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.AppElberth.model.domain.Alimenticio;

@Service
public class AlimenticioService {

	private static Map<Integer, Alimenticio> mapa = new HashMap<Integer, Alimenticio>();
	private static Integer id = 0;

	public void incluir(Alimenticio alimenticio){
		alimenticio.setId(++id);
		mapa.put(alimenticio.getId(), alimenticio);
	}

	public Collection<Alimenticio> obterLista(){
		return mapa.values();
	}
}