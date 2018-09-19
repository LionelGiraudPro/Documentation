package projet_garage.motorisation;

public class MoteurDiesel extends Motorisation {

	public MoteurDiesel(String puissance, Double prix) {
		super(puissance, prix);
		this.setType(TypeMoteur.DIESEL);
	}

}
