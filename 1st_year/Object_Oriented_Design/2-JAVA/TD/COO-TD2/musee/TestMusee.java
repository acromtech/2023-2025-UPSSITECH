package musee;

import equipementromain.Bouclier;
import equipementromain.Casque;
import equipementromain.Glaive;
import villagegaulois.Gaulois;

//TODO 1.a modifier la classe Test pour prendre en compte la solution de Keskonrix
public class TestMusee {

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Ast�rix");
		Gaulois obelix = new Gaulois("Ob�lix");

		Bouclier bouclierMordicus = new Bouclier("en bon �tat");
		Casque casqueAerobus = new Casque("caboss�", "fer");
		Glaive glaiveCornedurus = new Glaive("cass�");
		Glaive glaiveAerobus = new Glaive("tordu");
		
		GestionTrophee gestionnaireTrophees = new GoudurixGestion();
		Musee musee = new Musee("Museum", gestionnaireTrophees);
		musee.ajouterTrophee(asterix, bouclierMordicus);
		musee.ajouterTrophee(asterix, casqueAerobus);
		musee.ajouterTrophee(asterix, glaiveCornedurus);
		musee.ajouterTrophee(obelix, glaiveAerobus);

		System.out.println("Le mus� " + musee.getNom() + " est ouvert !\n");
		System.out.println(musee.tousLesTrophees());
		System.out.println(musee.lesTrophees(asterix));
	}
}
