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

	// Les m�thodes
	public void ajouterTrophee(Gaulois proprietaire, Equipement equipement) {
	
		// partie concerant la map inventaire
		
	}

	public String tousLesTrophees() {
		String chaine = "Tous les troph�es du mus�e sont :\n";
		
		return chaine;
	}

	public String lesTrophees(Gaulois proprietaire) {
		String chaine = "Les troph�es de " + proprietaire.getNom() + " sont :\n";
		
		return chaine;
	}

	// les m�thodes pour la compr�hension des vues

	public String donnerGauloisDonateur() {
		String chaine = "";
//		if () {
//			chaine = "Les gaulois ayant donn� au moins un troph�e au mus�e sont :\n";
//			for () {
//				
//			}
//		} else {
//			chaine = "Aucun gaulois n'a fait don d'un troph�e au mus�e.";
//		}
		return chaine;
	}

	public String donnerTrophees() {
		String chaine = "";
//		if () {
//			chaine = "Les troph�es du mus�e sont :\n";
//			for () {
//				
//			}
//		} else {
//			chaine = "Il n'y a aucun troph�e au mus�e.";
//		}
		return chaine;
	}
	
	public String donnerInventaire() {

		String chaine = "\nINVENTAIRE DU MUSEE\n";

//		for () {
//			chaine += "\n" + .getNom() + " a donn� :\n";
//			
//			for () {
//				chaine += "- " +  + " x " +  + "\n";
//			}
//		}
		return chaine;
	}
}
