package musee;

import equipement_romain.Bouclier;
import equipement_romain.Glaive;
import villagegaulois.Gaulois;

public class TestMusee {
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix");
		Gaulois obelix = new Gaulois("Obélix");
			
		GestionTrophee gestionnaireTrophees = new KeskonrixGestion();
		Musee musee = new Musee("Museum", gestionnaireTrophees);
		musee.ajouterTrophee(asterix, new Bouclier());
		musee.ajouterTrophee(asterix, new Bouclier());
		musee.ajouterTrophee(asterix, new Glaive());
		musee.ajouterTrophee(obelix, new Glaive());
	
		System.out.println("Le musé " + musee.getNom() + " est ouvert !\n");
		System.out.println(musee.tousLesTrophees());
		System.out.println(musee.lesTrophees(asterix));
	}
	
}

