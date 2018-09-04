package projet_tp_conversion;

import java.util.Scanner;

public class Tp {

	public static void main(String[] args) {
		System.out.println("CONVERTISSEUR DEGRéS CELSIUS ET DEGRéS FAHRENHEIT");
		System.out.println("-------------------------------------------------");

		char reponseEncore = 'O';
		while (reponseEncore == 'O') {
			System.out.println("Choisissez le mode de conversion :");
			System.out.println("1 - Convertisseur Celsius - Fahrenheit");
			System.out.println("2 - Convertiseur Fahrenhiet - Celsius");

			Scanner sc = new Scanner(System.in);
			String reponseConvertisseur = "";
			while (!reponseConvertisseur.equalsIgnoreCase("1") && !reponseConvertisseur.equalsIgnoreCase("2")) {
				reponseConvertisseur = sc.nextLine();
			}

			String reponseTemperature = "";
			Double reponseTemperatureDouble = null;
			while (reponseTemperatureDouble == null) {
				System.out.println("Température à convertir : ");
				reponseTemperature = sc.nextLine();
				try {
					reponseTemperatureDouble = Double.valueOf(reponseTemperature);
				} catch (NumberFormatException nfe) {
					System.out.println("Ce n'est pas un nombre valide !");
				}
			}

			switch (reponseConvertisseur) {
			case "1":
				System.out.println(reponseTemperatureDouble + " °C correspond à "
						+ arrondi(conversionCelsiusFarhen(reponseTemperatureDouble), 1) + " °F");
				break;
			case "2":
				System.out.println(reponseTemperatureDouble + " °F correspond à "
						+ arrondi(conversionFarhenCelsius(reponseTemperatureDouble), 1) + " °C");
				break;
			}

			do
			{
				System.out.println("Souhaitez-vous convertir une autre température ? (O/N)");
				reponseEncore = sc.nextLine().charAt(0);
			} while(reponseEncore != 'O' && reponseEncore != 'N');
		}
		
		System.out.println("Au revoir !");
	}

	public static double arrondi(double A, int B) {

		return (double) ((int) (A * Math.pow(10, B) + .5)) / Math.pow(10, B);

	}

	public static double conversionCelsiusFarhen(double celsius) {
		return (9.0d / 5.0d) * celsius + 32.0d;
	}

	public static double conversionFarhenCelsius(double fahren) {
		return ((fahren - 32.0d) * 5.0d) / 9.0d;
	}

}
