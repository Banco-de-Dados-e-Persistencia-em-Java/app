package br.edu.infnet.AppElberth.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.AppElberth.model.domain.Vendedor;
import br.edu.infnet.AppElberth.model.repository.VendedorRepository;

@Service
public class VendedorService {
	
	@Autowired
	private VendedorRepository vendedorRepository;

	public void incluir(Vendedor vendedor){				
		try {
			vendedorRepository.save(vendedor);
		} catch (Exception e) {
			System.err.println("[ERROR] " + e.getMessage());
		}		
	}

	public Collection<Vendedor> obterLista(){
		return (Collection<Vendedor>) vendedorRepository.findAll();
	}

	public Vendedor obterPorId(Integer id) {
		return vendedorRepository.findById(id).orElse(null);
	}

	public void excluir(Integer id) {
		vendedorRepository.deleteById(id);
	}
	
	public long obterQtde() {
		return vendedorRepository.count();
	}
	
	public Vendedor obterPorCPF(String cpf) {
		return vendedorRepository.findByCpf(cpf);
	}
	
}