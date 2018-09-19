package projet_garage.motorisation;

public class MoteurElectrique extends Motorisation {

	public MoteurElectrique(String puissance, Double prix) {
		super(puissance, prix);
		this.setType(TypeMoteur.ELECTRIQUE);
	}

}
