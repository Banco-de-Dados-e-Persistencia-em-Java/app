package br.edu.infnet.AppElberth.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TAlimenticio")
public class Alimenticio extends Produto {

	private boolean organico;
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
