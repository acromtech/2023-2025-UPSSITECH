package villagegaulois;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class TestComparaisonGaulois {
	
	//TODO exo I.3
	public static void afficherGaulois(NavigableSet<Gaulois> ensemble){
		
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix",35);
		Gaulois obelix = new Gaulois("Obélix",30);
		Gaulois abraracourcix = new Gaulois("Abraracourcix",40);
		Gaulois bonemine = new Gaulois("Bonemine",36);
		Gaulois panoramix = new Gaulois("Panoramix",90);
		
		NavigableSet<Gaulois> ensemble = new TreeSet<>();
		ensemble.add(asterix);
		ensemble.add(obelix);
		ensemble.add(abraracourcix);
		ensemble.add(bonemine);
		ensemble.add(panoramix);
		
		//TODO exo I.3
		System.out.println("Tri par ");
		afficherGaulois(ensemble);

		//TODO exo I.4
		
		//TODO exo I.4

		//TODO exo II.1.a
		System.out.println("\nPremier gaulois de plus de 35 ans");
		
		//TODO exo II.1.b
		System.out.println("\nPremier gaulois qui a au moins 35 ans");
		
		//TODO exo II.2.a
		
		System.out.println("Affichage de la vue");
//		afficherGaulois(selection);

		//TODO exo II.2.b

		System.out.println("Affichage de l'ensemble");
//		afficherGaulois(ensembleSelection);
		
//		ensembleGaulois.add(new Gaulois("Obélodalix",62));

		//TODO exo II.2.c
		System.out.println("Affichage Selection :");
//		System.out.println(selection);

		//TODO exo II.2.d
		System.out.println("Affichage Ensemble :");
//		System.out.println(ensembleSelection);

	}
}
