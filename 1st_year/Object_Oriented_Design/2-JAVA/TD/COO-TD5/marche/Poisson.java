package marche;

//TODO I.1.a
public class Poisson {
	private Date datePeche;
	private float poids;

	public Poisson(Date datePeche, float poids) {
		this.datePeche = datePeche;
		this.poids = poids;
	}

	//TODO I.1.a
	

	@Override
	public boolean equals(Object objet) {
		if (objet != null && objet instanceof Poisson) {
			Poisson poissonAcomparer = (Poisson) objet;
			return datePeche.equals(poissonAcomparer.datePeche) && poids == poissonAcomparer.poids;
		}
		return false;
	}
}
