package br.edu.infnet.AppElberth.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.AppElberth.model.domain.Eletronico;

@Service
public class EletronicoService {

	private static Map<Integer, Eletronico> mapa = new HashMap<Integer, Eletronico>();
	private static Integer id = 0;

	public void incluir(Eletronico eletronico){
		eletronico.setId(++id);
		mapa.put(eletronico.getId(), eletronico);
	}

	public Collection<Eletronico> obterLista(){
		return mapa.values();
	}
}