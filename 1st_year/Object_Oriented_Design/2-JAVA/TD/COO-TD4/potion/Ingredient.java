package potion;

public class Ingredient {
	String nom;
	Necessite necessaire;

	public Ingredient(String nom, Necessite necessaire) {
		this.nom = nom;
		this.necessaire = necessaire;
	}

	public Necessite getNecessaire() {
		return necessaire;
	}

	public String toString() {
		return nom;
	}
	
	//TODO exo IV.1 methode equals
	
}
