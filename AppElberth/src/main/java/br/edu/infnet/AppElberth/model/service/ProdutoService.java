package br.edu.infnet.AppElberth.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.AppElberth.model.domain.Produto;

@Service
public class ProdutoService {

	private static Map<Integer, Produto> mapa = new HashMap<Integer, Produto>();
	private static Integer id = 0;

	public void incluir(Produto produto){
		produto.setId(++id);
		mapa.put(produto.getId(), produto);
	}

	public Collection<Produto> obterLista(){
		return mapa.values();
	}

	public Produto obterPorId(Integer id) {
		return mapa.get(id);
	}

	public void excluir(Integer id) {
		mapa.remove(id);
	}
}