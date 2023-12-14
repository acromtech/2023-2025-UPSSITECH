package villagegaulois;

public class Gaulois implements Comparable<Gaulois> {

	private String nom;
	private int age;

	public Gaulois(String nom, int age) {
		this.nom = nom;
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Gaulois) {
			Gaulois gaulois = (Gaulois) obj;
			return nom.equals(gaulois.nom);
		}
		return false;
	}

	@Override
	public String toString() {
		return nom + " à " + age + " ans";
	}

	public int compareTo(Gaulois gauloisToCompare) {
		return nom.compareTo(gauloisToCompare.nom);
	}

}
