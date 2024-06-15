package br.edu.infnet.AppElberth.model.repository;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.AppElberth.model.domain.Alimenticio;

@Repository
public interface AlimenticioRepository extends CrudRepository<Alimenticio, Integer> {

	Collection<Alimenticio> findAll(Sort by);
	
	Collection<Alimenticio> findByOrganico(boolean organico);
}