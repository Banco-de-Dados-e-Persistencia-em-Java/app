package br.edu.infnet.AppElberth.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.AppElberth.model.domain.Alimenticio;
import br.edu.infnet.AppElberth.model.repository.AlimenticioRepository;

@Service
public class AlimenticioService {

	@Autowired
	private AlimenticioRepository alimenticioRepository;
	
	public void incluir(Alimenticio alimenticio){
		alimenticioRepository.save(alimenticio);
	}

	public Collection<Alimenticio> obterLista(){
		return (Collection<Alimenticio>) alimenticioRepository.findAll();
	}

	public Alimenticio obterPorId(Integer id) {
		return alimenticioRepository.findById(id).orElse(null);
	}

	public void excluir(Integer id) {
		alimenticioRepository.deleteById(id);
	}
	
	public long obterQtde() {
		return alimenticioRepository.count();
	}
}