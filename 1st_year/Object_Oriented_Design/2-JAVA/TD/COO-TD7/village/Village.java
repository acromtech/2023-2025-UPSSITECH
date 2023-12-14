package village;

public abstract class Village {
	protected String nom;
	protected int nombreHabitant = 0;
	
	public Village(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getNombreHabitant() {
		return nombreHabitant;
	}
}
