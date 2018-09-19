package projet_garage.motorisation;

import java.io.Serializable;

public abstract class Motorisation implements Serializable {
	
	private String puissance;
	private Double prix;
	private TypeMoteur type;
	
	public Motorisation(String puissance, Double prix) {
		super();
		this.puissance = puissance;
		this.prix = prix;
	}
	
	protected void setType(TypeMoteur type) {
		this.type = type;
	}
	
	public Double getPrix() {
		return prix;
	}

	@Override
	public String toString() {
		return "Moteur "+type+ " "+puissance + " (" + prix + "€)";
	}
	
	

	
}
