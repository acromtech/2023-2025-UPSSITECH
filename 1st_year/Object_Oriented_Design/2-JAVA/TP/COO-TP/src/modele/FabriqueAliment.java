package modele;

public class FabriqueAliment {
	public static Aliment creerAliment(AlimentMenu typeAliment, String nom) {
		switch(typeAliment) {
		case HAMBURGER:
			return new Hamburger(nom);
		case ACCOMPAGNEMENT:
			return new Accompagnement(nom);
		case BOISSON:
			return new Boisson(nom);	
		}
		return null;
	}
}
