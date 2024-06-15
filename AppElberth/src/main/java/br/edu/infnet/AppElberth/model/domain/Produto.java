package br.edu.infnet.AppElberth.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "TProduto")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank
//	@Size(min = 3, max = 100, message = "O nome do produto deve ter entre {min} e {max} caracteres.")
	@Column(name = "dsproduto")
	private String descricao;
	
//	@Min(value = 100, message = "O código do produto precisa ser maior ou igual a {min}.")
//	@Max(value = 999, message = "O código do produto precisa ser menor ou igual a {max}.")
	@Column(unique = true, name = "csproduto")
	private int codigo;	
	
	@Min(value = 1, message = "O preço do produto precisa ser maior ou igual a {value}")
	@Column(name = "vlproduto")
	private float preco;
	
	@Column(name = "flestoque")
	private boolean estoque;
	
	@ManyToOne
	@JoinColumn(name = "idVendedor")
	@JsonBackReference
	private Vendedor vendedor;
	
	@Override
	public String toString() {
		return String.format("%d - %s - %d - %.2f - %s",
					id,
					descricao,
					codigo,
					preco,
					estoque ? "estoque=S" : "estoque=N"
				);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public boolean isEstoque() {
		return estoque;
	}

	public void setEstoque(boolean estoque) {
		this.estoque = estoque;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
}
