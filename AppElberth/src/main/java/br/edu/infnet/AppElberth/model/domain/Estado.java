package br.edu.infnet.AppElberth.model.domain;

public class Estado {

	private Integer id;
	private String sigla;
	private String nome;
	
	public Estado() {
		this.setId(1);
	}

	public Estado(String sigla, String nome) {
		this();
		this.setSigla(sigla);
		this.setNome(nome);
	}
	
	@Override
	public String toString() {
		return String.format("%s [%s]", nome, sigla);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
