package br.edu.infnet.AppElberth.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.AppElberth.model.domain.Endereco;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Integer> {

}