package br.edu.infnet.AppElberth.model.repository;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.AppElberth.model.domain.Eletronico;

@Repository
public interface EletronicoRepository extends CrudRepository<Eletronico, Integer> {

	Collection<Eletronico> findAll(Sort by);
	
	Collection<Eletronico> findByMarcaContaining(String marca);
}