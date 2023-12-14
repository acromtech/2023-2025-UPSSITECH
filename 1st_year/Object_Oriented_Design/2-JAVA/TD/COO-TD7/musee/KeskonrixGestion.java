package musee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

import campromain.Equipement;
import villagegaulois.Gaulois;

import java.util.List;

//TODO III
public class KeskonrixGestion implements GestionTrophee {
	// Les attributs
	// Les associations
//	private  trophees = ;
//	private  inventaire = ;
	// Les vues sur l'association
//	private gauloisDonateur = ;
//	private  collectionTrophees = ;

	// Les méthodes
	public void ajouterTrophee(Gaulois proprietaire, Equipement equipement) {
	
		// partie concerant la map inventaire
		
	}

	public String tousLesTrophees() {
		String chaine = "Tous les trophées du musée sont :\n";
		
		return chaine;
	}

	public String lesTrophees(Gaulois proprietaire) {
		String chaine = "Les trophées de " + proprietaire.getNom() + " sont :\n";
		
		return chaine;
	}

	// les méthodes pour la compréhension des vues

	public String donnerGauloisDonateur() {
		String chaine = "";
//		if () {
//			chaine = "Les gaulois ayant donné au moins un trophée au musée sont :\n";
//			for () {
//				
//			}
//		} else {
//			chaine = "Aucun gaulois n'a fait don d'un trophée au musée.";
//		}
		return chaine;
	}

	public String donnerTrophees() {
		String chaine = "";
//		if () {
//			chaine = "Les trophées du musée sont :\n";
//			for () {
//				
//			}
//		} else {
//			chaine = "Il n'y a aucun trophée au musée.";
//		}
		return chaine;
	}
	
	public String donnerInventaire() {

		String chaine = "\nINVENTAIRE DU MUSEE\n";

//		for () {
//			chaine += "\n" + .getNom() + " a donné :\n";
//			
//			for () {
//				chaine += "- " +  + " x " +  + "\n";
//			}
//		}
		return chaine;
	}
}
