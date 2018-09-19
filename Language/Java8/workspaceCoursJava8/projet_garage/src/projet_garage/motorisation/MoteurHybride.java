package projet_garage.motorisation;

public class MoteurHybride extends Motorisation {

	public MoteurHybride(String puissance, Double prix) {
		super(puissance, prix);
		this.setType(TypeMoteur.HYBRIDE);
	}

}
