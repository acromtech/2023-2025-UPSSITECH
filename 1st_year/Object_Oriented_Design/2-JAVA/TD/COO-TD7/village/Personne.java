package village;

public class Personne implements Comparable<Personne> {
	protected String nom;

	public Personne(String nom) {
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
	public int compareTo(Personne personne) {
		return nom.compareTo(personne.nom);
	}

	@Override
	public boolean equals(Object object) {
		if (object != null && object.getClass() == getClass()) {
			Personne personne = (Personne) object;
			return nom.equals(personne.nom);
		}
		return false;
	}

	//TODO IV
	
}
