package br.edu.infnet.AppElberth.model.domain;

public class Alimenticio extends Produto {

	private boolean organico;
	private String carateristica;

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
