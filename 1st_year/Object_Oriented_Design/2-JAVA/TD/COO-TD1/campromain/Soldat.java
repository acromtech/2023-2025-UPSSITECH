package campromain;

public class Soldat extends Romain {

	private GradeRomain grade;
	
	public Soldat(String nom, GradeRomain grade) {
		super(nom);
		this.grade = grade;
	}	
	
	public String toString() {
		return nom+" : "+ grade;
	}
	
}
