package br.edu.infnet.AppElberth.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TAlimenticio")
public class Alimenticio extends Produto {

	@Column(name = "florganico")
	private boolean organico;

	@Size(min = 3, max = 20, message = "A característica do produto deve ter entre {min} e {max} caracteres.")
	@Column(name = "dscaracteristica")
	private String carateristica;
	
	@Override
	public String toString() {
		return String.format("%s - %s - %s", 
				super.toString(), 
				organico, 
				carateristica
			);
	}

	public boolean isOrganico() {
		return organico;
	}
	public void setOrganico(boolean organico) {
		this.organico = organico;
	}
	public String getCarateristica() {
		return carateristica;
	}
	public void setCarateristica(String carateristica) {
		this.carateristica = carateristica;
	}

}
