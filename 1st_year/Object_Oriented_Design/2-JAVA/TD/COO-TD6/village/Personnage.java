package village;

public class Personnage implements Comparable<Personnage>{
	protected String nom;

	public Personnage(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return nom;
	}

	
	@Override
	public String toString() {
		return nom;
	}

	@Override
	public int compareTo(Personnage personnage) {
		return nom.compareTo(personnage.nom);
	}
	
	@Override
	public boolean equals(Object object) {
		if(object != null && object.getClass() == getClass()){
			Personnage personnage = (Personnage) object;
			return nom.equals(personnage.nom);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return 31 * nom.hashCode();
	}
}
