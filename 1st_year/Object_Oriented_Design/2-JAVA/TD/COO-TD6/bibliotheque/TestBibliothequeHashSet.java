package bibliotheque;

import java.util.HashSet;
import java.util.Set;

import bibliotheque.Parchemin;
import campromain.Romain;
import villagegaulois.Gaulois;

public class TestBibliothequeHashSet {

	private static void affichage(Set<Parchemin> ensembleParchemin) {
		for (Parchemin parchemin : ensembleParchemin) {
			System.out.println("- " + parchemin);
		}
	}

	public static void main(String[] args) {
		Romain cesar = new Romain("Cesar");
		Gaulois druide = new Gaulois("Panoramix");
		Gaulois assurancetourix = new Gaulois("Assurancetourix");
		Parchemin effetsPotion = new Parchemin("Les effets secondaires de la potion magique", druide,
				new Date(21, 12, -70));
		Parchemin musiqueBestOf = new Parchemin("Mes plus grands succès", assurancetourix, new Date(30, 04, -45));
		Parchemin guerreDesGaules = new Parchemin("Commentaires sur la guerre des gaules", cesar,
				new Date(12, 07, -50));

		// TODO exo II.2 ensembleParchemin

		// TODO exo II.2 parcheminsAPreter

		// TODO exo II.2 parcheminsPretes

		System.out.println("Parchemins stockés au musée :");
//		affichage(ensembleParchemin);

		// TODO exo II.2 répondre à la question
		System.out.println("\nA-t-on prêté des parchemins ? " );

		// TODO exo II.2 Transfert des parchemeins

		System.out.println("\nParchemins à préter :");
//		affichage(parcheminsAPreter);
		System.out.println("Parchemins prétés :");
//		affichage(parcheminsPretes);

		// TODO exo II.2 hashCode d'une liste
		System.out.println("\nLe hashCode du parchemin effetsPotion est : " + effetsPotion.hashCode());
//		System.out.println("Le hashCode de l'ensemble parcheminsAPreter est : " + parcheminsAPreter.hashCode());

		// TODO exo III. Classe et objet dégénéré
//		System.out.println(parcheminsAPreter);
		Parchemin parcheminDegenere = new Parchemin("\nLes effets secondaires de la potion magique", druide,
				new Date(0, 0, 0));
		System.out.println(
				"A-t-on le parchemin sur la potion magique ? ");
		
		System.out.println(
				"A-t-on le parchemin sur la potion magique ? ");

	}
}
