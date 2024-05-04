package br.edu.infnet.AppElberth.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.AppElberth.model.domain.Vendedor;

@Service
public class VendedorService {

	private static Map<Integer, Vendedor> mapa = new HashMap<Integer, Vendedor>();
	private static Integer id = 0;

	public void incluir(Vendedor vendedor){
		vendedor.setId(++id);
		mapa.put(vendedor.getId(), vendedor);
	}

	public Collection<Vendedor> obterLista(){
		return mapa.values();
	}
}