package projet_garage.motorisation;

public class MoteurEssence extends Motorisation {

	public MoteurEssence(String puissance, Double prix) {
		super(puissance, prix);
		this.setType(TypeMoteur.ESSENCE);
	}

}
