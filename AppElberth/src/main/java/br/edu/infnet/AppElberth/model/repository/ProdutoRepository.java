package br.edu.infnet.AppElberth.model.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.AppElberth.model.domain.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer> {

	Produto findByCodigo(int codigo);
	
	Collection<Produto> findByVendedorId(Integer id);
}