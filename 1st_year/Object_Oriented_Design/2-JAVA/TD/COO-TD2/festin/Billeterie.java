package festin;

public class Billeterie {
	private int buttin = 0;
	private ActivitePayante[] activites = new ActivitePayante[4];
	private int nbActivite = 0;

	public void ajouterActivite(ActivitePayante activitePayante, int prixBillet) {
		activites[nbActivite] = activitePayante;
		activitePayante.setTarif(prixBillet);
	}
	
//TODO 2.c traiter l'exception java.lang.NullPointeurException
	public void acheterBillet(int numeroActivite) {
		ActivitePayante activite = activites[numeroActivite];
		buttin += activite.getTarif();
	}

	public int getButtin() {
		return buttin;
	}

//	public static void main(String[] args) {
//		Test exception NullPointerException
//		Billeterie billeterie = new Billeterie();
//		billeterie.acheterBillet(1);
//	}
}
