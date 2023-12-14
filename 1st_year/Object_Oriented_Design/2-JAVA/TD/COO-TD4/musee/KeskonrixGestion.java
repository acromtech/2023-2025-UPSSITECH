package musee;

import java.util.ArrayList;
import java.util.List;

import equipement_romain.Equipement;
import villagegaulois.Gaulois;

public class KeskonrixGestion implements GestionTrophee {
//	TODO exo II.3.1
//	private RenseignementTrophee[] trophees = new RenseignementTrophee[30];
//	private int nombreDeTrophee = 0;
	
	
//	TODO exo II.3.2
//	public void ajouterTrophee(Gaulois proprietaire,Equipement trophee) {
//		trophees[nombreDeTrophee] = new RenseignementTrophee(proprietaire, trophee);
//		nombreDeTrophee++;
//	}
	public void ajouterTrophee(Gaulois proprietaire,Equipement trophee) {
		
	}
	
//	TODO exo II.3.3
//	public String tousLesTrophees() {
//		String tousLesTrophees = "Tous les trophées du musée sont :\n";
//		for (int i = 0; i < nombreDeTrophee; i++) {
//			Equipement typeEquipement = trophees[i].getTypeTrophee();
//			tousLesTrophees += "-" + typeEquipement + "\n";
//		}
//		return tousLesTrophees;
//	}

	public String tousLesTrophees() {
		String tousLesTrophees = "Tous les trophées du musée sont :\n";
		
		return tousLesTrophees;
	}
	
//	TODO exo II.3.4 non fait en cours/TD
//	public String lesTrophees(Gaulois proprietaire) {
//	    String tousLesTrophees = "Les trophées de " + proprietaire.getNom() + " sont :\n";
//	    for (int i = 0; i < nombreDeTrophee; i++) {
//	      Gaulois proprietaireTrophee = trophees[i].getProprietaire();
//	      if (proprietaire.equals(proprietaireTrophee)) {
//	        Equipement typeEquipement = trophees[i].getTypeTrophee();
//	        tousLesTrophees += "- " + typeEquipement + "\n";
//	     } }
//	    return tousLesTrophees;
//	  }
	public String lesTrophees(Gaulois proprietaire) {
	    String tousLesTrophees = "Les trophées de " + proprietaire.getNom() + " sont :\n";
	    
	    return tousLesTrophees;
	  }

}
