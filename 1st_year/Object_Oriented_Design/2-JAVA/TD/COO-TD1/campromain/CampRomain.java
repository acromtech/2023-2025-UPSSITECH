package campromain;

import village.Village;

public class CampRomain extends Village {
	
	//Partie 1
	private Soldat prefet;
	private Legion[] legions = new Legion[10];
	private int nombreLegions = 0;

	public CampRomain(String nom, Soldat prefet) {
		super(nom);
		this.prefet = prefet;
	}

	//Partie 2

	public String toString() {
		String chaine = nom + " est le camp Romain dirigé par " + this.prefet;
		if (nombreLegions != 0) {
			chaine += "\nLes légions sous ses ordres sont : ";
			for (int i = 0; i < nombreLegions; i++) {
				chaine += "\n" + legions[i];
			}
		}
		chaine += "\n";
		return chaine;
	}
	
	public void ajouterLegion(Legion legion) {
		legions[nombreLegions] = legion;
		nombreLegions++;
	}
}
