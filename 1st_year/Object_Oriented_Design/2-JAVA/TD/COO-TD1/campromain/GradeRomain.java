package campromain;

public enum GradeRomain {
	PREFET("prefet"), LEGAT("légat"), CENTURION("centurion"), LEGIONNAIRE("légionnaire");
	
	private String nom;
	
	private GradeRomain(String nom){
		this.nom = nom;
	}
	
	public String toString() {
		return nom;
	}
}
