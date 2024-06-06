package br.edu.infnet.AppElberth.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.AppElberth.model.domain.Alimenticio;

@Repository
public interface AlimenticioRepository extends CrudRepository<Alimenticio, Integer> {

}
