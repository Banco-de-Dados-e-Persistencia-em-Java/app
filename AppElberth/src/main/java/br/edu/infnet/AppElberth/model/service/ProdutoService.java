package br.edu.infnet.AppElberth.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.AppElberth.model.domain.Produto;
import br.edu.infnet.AppElberth.model.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public void incluir(Produto produto){
		produtoRepository.save(produto);
	}

	public Collection<Produto> obterLista(){
		return (Collection<Produto>) produtoRepository.findAll();
	}

	public Produto obterPorId(Integer id) {
		return produtoRepository.findById(id).orElse(null);
	}

	public void excluir(Integer id) {
		produtoRepository.deleteById(id);
	}
	
	public long obterQtde() {
		return produtoRepository.count();
	}
}