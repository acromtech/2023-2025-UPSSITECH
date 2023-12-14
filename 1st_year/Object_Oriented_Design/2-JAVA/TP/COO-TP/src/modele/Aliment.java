package modele;

public abstract class Aliment {
	private String nom;
	public Aliment(String nom) {
		this.nom = nom;
	}
	@Override
	public String toString() {
		return "Aliment [nom=" + nom + "]";
	}
	public String getNom() {
		return this.nom;
	}
	

}
