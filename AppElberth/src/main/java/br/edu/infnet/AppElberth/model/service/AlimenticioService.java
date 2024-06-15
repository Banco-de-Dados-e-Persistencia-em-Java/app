package br.edu.infnet.AppElberth.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.AppElberth.model.domain.Alimenticio;
import br.edu.infnet.AppElberth.model.repository.AlimenticioRepository;

@Service
public class AlimenticioService {

	@Autowired
	private AlimenticioRepository alimenticioRepository;
	
	public void incluir(Alimenticio alimenticio){
		try {
			alimenticioRepository.save(alimenticio);
		} catch (Exception e) {
			System.err.println("[ERROR] " + e.getMessage());
		}
	}

	public Collection<Alimenticio> obterLista(){
		return (Collection<Alimenticio>) alimenticioRepository.findAll();
	}

	public Collection<Alimenticio> obterLista(String orderBy){
		return (Collection<Alimenticio>) alimenticioRepository.findAll(Sort.by(Sort.Direction.DESC, orderBy));
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
	public Collection<Alimenticio> obterListaOrganico(boolean organico){
		return (Collection<Alimenticio>) alimenticioRepository.findByOrganico(organico);
	}
}