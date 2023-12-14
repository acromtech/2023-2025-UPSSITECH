package musee;

import equipementromain.Equipement;
import villagegaulois.Gaulois;

public class GoudurixGestion implements GestionTrophee {

	private Gaulois proprietaires[] = new Gaulois[30];
	private Equipement trophees[] = new Equipement[30];
	private int nombreDeTrophee = 0;

	@Override
	public String tousLesTrophees() {
		String tousLesTrophees = "Tous les trophées du musée sont :\n";
		for (int i = 0; i < nombreDeTrophee; i++) {
			tousLesTrophees += "- " + trophees[i] + "\n";
		}
		return tousLesTrophees;
	}

	@Override
	public String lesTrophees(Gaulois proprietaire) {
		String leTrophee = "Le trophée de " + proprietaire.getNom() + " est ";
		int indiceProprietaire = 0;
		for (int i = 0; i < nombreDeTrophee; i++) {
			if (proprietaire.equals(proprietaires[i])) {
				indiceProprietaire = i;
			}
		}
		leTrophee += trophees[indiceProprietaire];
		return leTrophee;
	}

	@Override
	public void ajouterTrophee(Gaulois proprietaire, Equipement trophee) {
		proprietaires[nombreDeTrophee] = proprietaire;
		trophees[nombreDeTrophee] = trophee;
		nombreDeTrophee++;

	}
}
