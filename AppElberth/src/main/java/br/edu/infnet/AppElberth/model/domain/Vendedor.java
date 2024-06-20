package br.edu.infnet.AppElberth.model.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "TVendedor")
public class Vendedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	
	@NotBlank(message = "É necessário preencher o campo NOME!")
	@Size(min = 3, max = 100, message = "O nome do vendedor deve ter entre {min} e {max} caracteres.")
	private String nome;
	
	@NotBlank(message = "É necessário preencher o campo CPF!")
	@Column(unique = true)
	private String cpf;
	
	@NotBlank(message = "É necessário preencher o campo E-MAIL!")
	@Email(message = "O email {email} está incorreto!")
	private String email;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "idVendedor")
	@JsonManagedReference
	private List<Produto> produtos;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idEndereco")
	private Endereco endereco;
	
	public Vendedor() {
		this.produtos = new ArrayList<Produto>();
	}
	
	public Vendedor(Integer id) {
		this();
		this.setId(id);
	}

	@Override
	public String toString() {
		return String.format("%d - %s - %s - %s - %d - Endereço: %s",
				id,
				nome, 
				cpf, 
				email,
				produtos.size(),
				endereco
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}