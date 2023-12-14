package musee;

import campromain.Equipement;
import villagegaulois.Gaulois;

public class TestMusee {

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix");
		Gaulois obelix = new Gaulois("Obélix");
		Gaulois ordralfabetix = new Gaulois("Ordralfabétix");

		Musee musee = new Musee("Museum", new KeskonrixGestion());
		
		System.out.println(musee.donnerGauloisDonateur());
		System.out.println(musee.donnerTrophees());
		
		musee.ajouterTrophee(obelix, Equipement.EPEE);
		musee.ajouterTrophee(ordralfabetix, Equipement.CASQUE);
		musee.ajouterTrophee(asterix, Equipement.BOUCLIER);
		musee.ajouterTrophee(asterix, Equipement.CASQUE);
		musee.ajouterTrophee(asterix, Equipement.CASQUE);
		
		System.out.println(musee.donnerGauloisDonateur());
		System.out.println(musee.donnerTrophees());		
		System.out.println(musee.donnerInventaire());

	}

}
