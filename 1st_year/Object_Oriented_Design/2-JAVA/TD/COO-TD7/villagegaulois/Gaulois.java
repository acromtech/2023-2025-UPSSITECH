package villagegaulois;

import village.Personne;

public class Gaulois extends Personne{

	public Gaulois(String nom) {
		super(nom);
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Gaulois){
			Gaulois gaulois = (Gaulois) obj;
			return nom.equals(gaulois.getNom());
		}
		return false;
	}
}
