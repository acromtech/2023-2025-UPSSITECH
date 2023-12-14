package musee;

import equipementromain.Equipement;
import villagegaulois.Gaulois;

public class KeskonrixGestion implements GestionTrophee {

	private RenseignementTrophee[] trophees = new RenseignementTrophee[30];
	private int nombreDeTrophee = 0;

	public void ajouterTrophee(Gaulois proprietaire, Equipement trophee) {
		trophees[nombreDeTrophee] = new RenseignementTrophee(proprietaire, trophee);
		nombreDeTrophee++;
	}
	
	public String tousLesTrophees() {
		String tousLesTrophees = "Tous les trophées du musée sont :\n";
		for (int i = 0; i < nombreDeTrophee; i++) {
			Equipement typeEquipement = trophees[i].getTypeTrophee();
			tousLesTrophees += "-" + typeEquipement + "\n";
		}
		return tousLesTrophees;
	}

	public String lesTrophees(Gaulois proprietaire) {
	    String tousLesTrophees = "Les trophées de " + proprietaire.getNom() + " sont :\n";
	    for (int i = 0; i < nombreDeTrophee; i++) {
	      Gaulois proprietaireTrophee = trophees[i].getProprietaire();
	      if (proprietaire.equals(proprietaireTrophee)) {
	        Equipement typeEquipement = trophees[i].getTypeTrophee();
	        tousLesTrophees += "- " + typeEquipement + "\n";
	     } }
	    return tousLesTrophees;
	  }
}
