package campromain;

public enum Equipement {
	CASQUE("un casque"), BOUCLIER("un bouclier"), EPEE("une �p�e");
	
	private String nom = "";
	
	private Equipement(String nom) {
		this.nom = nom;
	}
	
	public String toString() {
		return nom;
	};
}
