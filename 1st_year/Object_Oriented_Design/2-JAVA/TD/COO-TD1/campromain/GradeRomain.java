package campromain;

public enum GradeRomain {
	PREFET("prefet"), LEGAT("l�gat"), CENTURION("centurion"), LEGIONNAIRE("l�gionnaire");
	
	private String nom;
	
	private GradeRomain(String nom){
		this.nom = nom;
	}
	
	public String toString() {
		return nom;
	}
}
