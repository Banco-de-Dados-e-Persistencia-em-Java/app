package br.edu.infnet.AppElberth.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TEletronico")
public class Eletronico extends Produto {

	@Size(min = 3, max = 20, message = "A marca do produto deve ter entre {min} e {max} caracteres.")
	@Column(name = "dsmarca")
	private String marca;
	
	@Max(value = 36)
	@Column(name = "qtMesesGarantia")
	private int garantiaMeses;

	@Override
	public String toString() {
		return String.format("%s - %s - %d", 
				super.toString(), 
				marca, 
				garantiaMeses
			);
	}

	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getGarantiaMeses() {
		return garantiaMeses;
	}
	public void setGarantiaMeses(int garantiaMeses) {
		this.garantiaMeses = garantiaMeses;
	}
}