package projet_garage.motorisation;

public enum TypeMoteur {
	DIESEL("DIESEL"),
	ESSENCE("ESSENCE"),
	ELECTRIQUE("ELECTRIQUE"),
	HYBRIDE("HYBRIDE ESSENCE/ELECTRIQUE");
	
	private String description;
	
	private TypeMoteur(String description)
	{
		this.description = description;
	}
}
