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
		try {
			produtoRepository.save(produto);
		} catch (Exception e) {
			System.err.println("[ERROR] " + e.getMessage());
		}
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
	
	public Produto obterPorCodigo(int codigo){
		return produtoRepository.findByCodigo(codigo);
	}

	public Collection<Produto> obterListaPorVendedor(Integer id){
		return (Collection<Produto>) produtoRepository.findByVendedorId(id);
	}
}