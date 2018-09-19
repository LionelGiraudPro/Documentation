package projet_garage.vehicules;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import projet_garage.motorisation.Motorisation;
import projet_garage.options.OptionVehicule;

public abstract class Vehicule implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6684567615462226591L;
	
	private MarqueEnum marque;
	private Motorisation moteur;
	private List<OptionVehicule> options = new ArrayList<>(); 

	public Motorisation getMoteur() {
		return moteur;
	}

	public void setMoteur(Motorisation motorisation) {
		this.moteur = motorisation;
	}

	public MarqueEnum getMarque() {
		return marque;
	}

	protected void setMarque(MarqueEnum marque) {
		this.marque = marque;
	}
	
	public void addOption(OptionVehicule option)
	{
		options.add(option);
	}
	
	public Double getPrix()
	{
		return moteur.getPrix() + options.stream().mapToDouble((x) -> x.getPrix()).sum();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(" + Voiture ");
		builder.append(marque);
		builder.append(" : ");
		builder.append(moteur);
		
		builder.append(" [");
		options.stream().forEach((x) -> builder.append(x.getClass().getSimpleName()).append(" (").append(x.getPrix()).append("€ ), "));
		builder.replace(builder.length() -2, builder.length() -1, "");
		builder.append(" ] d'une valeur totale de ");
		builder.append(this.getPrix());
		builder.append(" € \n");
		
		return builder.toString();
	}
	
	
	
}
