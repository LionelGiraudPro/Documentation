package projet_garage;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import projet_garage.vehicules.Vehicule;

public class Garage {

	private List<Vehicule> vehicules = new ArrayList<>();
	private File sauvegarde = new File("sauvegarde_garage.txt");
	private ObjectOutputStream oos = null;
	private ObjectInputStream ois = null;

	public Garage() {
		super();

		if (sauvegarde.exists() && sauvegarde.length() > 0) {

			try {
				ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(sauvegarde)));
				try {
					for(;;)
						vehicules.add((Vehicule) ois.readObject());
				} catch(EOFException ex)
				{
					ois.close();
				}
			} catch (IOException | ClassNotFoundException e) {
				System.err.println("Erreur lors de la lecture dans le fichier : ");
				e.printStackTrace(System.err);
			}

		}
		
		try {
			oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(sauvegarde)));
		} catch (IOException e) {
			System.err.println("Erreur lors de l'ouverture du fichier en ecriture : ");
			e.printStackTrace(System.err);
		}

	}

	public void addVoiture(Vehicule vehicule) {
		vehicules.add(vehicule);

		try {
			oos.writeObject(vehicule);
			oos.flush();
		} catch (IOException e) {
			System.err.println("Erreur lors de l'ecriture dans le fichier : ");
			e.printStackTrace(System.err);
		}
		
	}
	
	public void closeGarage()
	{
		try {
			oos.close();
		} catch (IOException e) {
			System.err.println("Erreur lors de la fermeture de l'ecriture dans le fichier : ");
			e.printStackTrace(System.err);
		}
	}

	@Override
	public String toString() {
		if (vehicules.isEmpty()) {
			return "Aucune voiture sauvegardée";
		}

		StringBuilder builder = new StringBuilder();
		builder.append("************************ \n");
		builder.append("* Garage OpenClassRoom * \n");
		builder.append("************************ \n\n");

		vehicules.stream().forEach((x) -> builder.append(x.toString()));
		return builder.toString();
	}

}
