package br.edu.infnet.AppElberth.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Vendedor {
	
	private Integer id;
	private String nome;
	private String cpf;
	private String email;
	
	private List<Produto> produtos;
	
	public Vendedor() {
		this.produtos = new ArrayList<Produto>();
	}
	
	@Override
	public String toString() {
		return String.format("%d - %s - %s - %s - %d",
				id,
				nome, 
				cpf, 
				email,
				produtos.size()
			);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
}