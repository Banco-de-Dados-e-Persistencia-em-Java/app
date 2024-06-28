package br.edu.infnet.AppElberth.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.AppElberth.model.domain.Endereco;
import br.edu.infnet.AppElberth.model.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
	public Collection<Endereco> obterLista() {
		return (Collection<Endereco>) enderecoRepository.findAll();
	}
	
	public long obterQtde() {
		return enderecoRepository.count();
	}
}