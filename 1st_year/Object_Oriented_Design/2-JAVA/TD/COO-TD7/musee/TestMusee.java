package musee;

import campromain.Equipement;
import villagegaulois.Gaulois;

public class TestMusee {

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Ast�rix");
		Gaulois obelix = new Gaulois("Ob�lix");
		Gaulois ordralfabetix = new Gaulois("Ordralfab�tix");

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
