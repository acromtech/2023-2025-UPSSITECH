package src;

/*
 * Test de la classe MyCustomSet.java
 * à placer dans le même package que votre classe
 *
 */


public class TestMyCustomSet {


	// les attributs pour memoriser l'etat des tests
	static boolean resTest = true ;
	static int nbTests = 0 ;
	static int nbTestsOK = 0 ;
	static final int nbTestsMAX = 42 ;
	
	// methode d'affichage des resultats de test 
	// a utiliser a chaque etape
	static void affResTest(int numTest) {
		if (resTest) {
		    nbTestsOK ++ ;
		    System.out.println("Test "+numTest+" OK");
		}
		else
		    System.out.println("Test "+numTest+" NOK");
	}

	// Programme principal, sert ici de programme de test
        // 42 tests 
	public static void main(String[] args) {
	
		MyCustomSet mySet = new MyCustomSet();
		
		System.out.println(mySet.toString());
		System.out.println("l'ensemble est vide : " + mySet.isEmpty());
		resTest = resTest && mySet.isEmpty() ; 
		nbTests ++ ;
		affResTest(1) ;
		System.out.println("sa taille est de 0 : " + mySet.size());
		resTest = resTest && (mySet.size() == 0) ; 
		nbTests ++ ;
		affResTest(2) ;
		System.out.println("");
		System.out.println("pas de choix possible (-1) : ");
		for (int i = 0 ; i < 20 ; i++) {
			int x = mySet.random() ;
			System.out.println("resultat tirage n'appartient pas a l'ensemble : " + mySet.contains(x)) ;
			resTest = resTest && (x == -1) ;
		}
		nbTests ++ ;		
		affResTest(3) ;
		System.out.println("Suppression de 0 (n'est pas ds l'ensemble " + mySet);
		mySet.remove(0) ;
		nbTests ++ ;		
		affResTest(4) ;
		System.out.println("");

		mySet.add(11);
		System.out.println(mySet.toString());
		System.out.println("l'ensemble n'est pas vide : " + mySet.isEmpty());
		resTest = resTest && (!mySet.isEmpty()) ; 
		nbTests ++ ;
		affResTest(5) ;
		System.out.println("sa taille est de 1 : " + mySet.size());
		resTest = resTest && (mySet.size() == 1) ; 
		nbTests ++ ;
		affResTest(6) ;
		System.out.println("11 appartient a l'ensemble : " + mySet.contains(11)
				+ " et 12 non : " + mySet.contains(12));
		resTest = resTest && mySet.contains(11) && (!mySet.contains(12));
		nbTests ++ ;		
		affResTest(7) ;
		System.out.println("");
		System.out.println("avec le random un seul choix possible (11) : ");
		for (int i = 0 ; i < 20 ; i++) {
			int x = mySet.random() ;
			System.out.println("resultat tirage appartient a l'ensemble : " + mySet.contains(x)) ;
			resTest = resTest && (x == 11) ;
		}
		nbTests ++ ;		
		affResTest(8) ;
		System.out.println("Suppression de 0 (n'est pas ds l'ensemble " + mySet);
		mySet.remove(0) ;
		nbTests ++ ;		
		affResTest(9) ;
		System.out.println("");

		mySet.add(12);
		System.out.println(mySet.toString());
		System.out.println("l'ensemble n'est pas vide : " + mySet.isEmpty());
		resTest = resTest && (!mySet.isEmpty()) ;
		nbTests ++ ;		
		affResTest(10) ;
		System.out.println("sa taille est de 2 : " + mySet.size());
		resTest = resTest && (mySet.size() == 2) ;
		nbTests ++ ;		
		affResTest(11) ;
		System.out.println("11 appartient a l'ensemble : " + mySet.contains(11)
				+ " et 12 aussi : " + mySet.contains(12));
		System.out.println("");
		System.out.println("avec le random deux choix possibles (11 ou 12) : ");
		for (int i = 0 ; i < 20 ; i++) {
			int x = mySet.random() ;
			System.out.println("resultat tirage appartient a l'ensemble : " + mySet.contains(x)) ;
			resTest = resTest && ((x == 11) || (x == 12));
		}
		nbTests ++ ;		
		affResTest(12) ;
		System.out.println("Suppression de 0 (n'est pas ds l'ensemble " + mySet);
		mySet.remove(0) ;
		nbTests ++ ;		
		affResTest(13) ;
		System.out.println("");

		mySet.add(11);
		System.out.println(mySet.toString());
		System.out.println("l'ensemble n'est pas vide : " + mySet.isEmpty());
		resTest = resTest && (!mySet.isEmpty()) ; 
		nbTests ++ ;
		affResTest(14) ;
		System.out.println("sa taille est tjrs de 2 : " + mySet.size());
		resTest = resTest && (mySet.size() == 2) ; 
		nbTests ++ ;
		affResTest(15) ;
		System.out.println("11 appartient a l'ensemble : " + mySet.contains(11)
				+ " et 12 aussi : " + mySet.contains(12));
		resTest = resTest && mySet.contains(11) && (mySet.contains(12));
		nbTests ++ ;		
		affResTest(16) ;
		System.out.println("");
		System.out.println("avec le random deux choix possibles (11 ou 12) : ");
		for (int i = 0 ; i < 20 ; i++) {
			int x = mySet.random() ;
			System.out.println("resultat tirage appartient a l'ensemble : " + mySet.contains(x)) ;
			resTest = resTest && ((x == 11) || (x == 12)) ;
		}
		nbTests ++ ;		
		affResTest(17) ;
		System.out.println("Suppression de 0 (n'est pas ds l'ensemble " + mySet);
		mySet.remove(0) ;
		nbTests ++ ;		
		affResTest(18) ;
		System.out.println("");

		mySet.add(13);
		System.out.println(mySet.toString());
		System.out.println("l'ensemble n'est pas vide : " + mySet.isEmpty());
		resTest = resTest && (!mySet.isEmpty()) ;
		nbTests ++ ;		
		affResTest(19) ;
		System.out.println("sa taille est de 3 : " + mySet.size());
		resTest = resTest && (mySet.size() == 3) ;
		nbTests ++ ;		
		affResTest(20) ;
		System.out.println("11, 12 et 13 appartiennent a l'ensemble : "
				+ mySet.contains(11) + " " + mySet.contains(12) + " "
				+ mySet.contains(13));
		System.out.println("");
		System.out.println("avec le random trois choix possibles (11, 12, 13) : ");
		for (int i = 0 ; i < 20 ; i++) {
			int x = mySet.random() ;
			System.out.println("resultat tirage appartient a l'ensemble : " + mySet.contains(x)) ;
			resTest = resTest && ((x == 11) || (x == 12) || (x == 13));
		}
		nbTests ++ ;		
		affResTest(21) ;
		System.out.println("Suppression de 0 (n'est pas ds l'ensemble " + mySet);
		mySet.remove(0) ;
		nbTests ++ ;		
		affResTest(22) ;
		System.out.println("");

		mySet.remove(13);
		System.out.println("Apres suppression de 13, on trouve 11-12: ");
		System.out.println(mySet.toString());
		System.out.println("l'ensemble n'est pas vide : " + mySet.isEmpty());
		resTest = resTest && (!mySet.isEmpty()) ;
		nbTests ++ ;		
		affResTest(23) ;
		System.out.println("sa taille est de 2 : " + mySet.size());
		resTest = resTest && (mySet.size() == 2) ;
		nbTests ++ ;		
		affResTest(24) ;
		System.out.println("11, 12 appartiennent a l'ensemble mais plus 13 : "
				+ mySet.contains(11) + " " + mySet.contains(12) + " "
				+ mySet.contains(13));
		System.out.println("");
		System.out.println("avec le random deux choix possibles (11 ou 12) : ");
		for (int i = 0 ; i < 20 ; i++) {
			int x = mySet.random() ;
			System.out.println("resultat tirage appartient a l'ensemble : " + mySet.contains(x)) ;
			resTest = resTest && ((x == 11) || (x == 12));
		}
		nbTests ++ ;		
		affResTest(25) ;
		System.out.println("Suppression de 0 (n'est pas ds l'ensemble " + mySet);
		mySet.remove(0) ;
		nbTests ++ ;		
		affResTest(26) ;
		System.out.println("");

		mySet.remove(11);
		System.out.println("Apres suppression de 11, on trouve 12: ");
		System.out.println(mySet.toString());
		System.out.println("l'ensemble n'est pas vide : " + mySet.isEmpty());
		resTest = resTest && (!mySet.isEmpty()) ;
		nbTests ++ ;		
		affResTest(27) ;
		System.out.println("sa taille est de 1 : " + mySet.size());
		resTest = resTest && (mySet.size() == 1) ;
		nbTests ++ ;		
		affResTest(28) ;
		System.out.println("12 appartient a l'ensemble mais plus 11, ni 13 : "
				+ mySet.contains(12) + " " + mySet.contains(11) + " "
				+ mySet.contains(13));
		System.out.println("");
		System.out.println("avec le random un seul choix possible (12) : ");
		for (int i = 0 ; i < 20 ; i++) {
			int x = mySet.random() ;
			System.out.println("resultat tirage appartient a l'ensemble : " + mySet.contains(x)) ;
			resTest = resTest && (x == 12);
		}
		nbTests ++ ;		
		affResTest(29) ;
		System.out.println("Suppression de 0 (n'est pas ds l'ensemble " + mySet);
		mySet.remove(0) ;
		nbTests ++ ;		
		affResTest(30) ;
		System.out.println("");

		mySet.remove(12);
		System.out.println("Apres suppression de 12, on trouve rien : ");
		System.out.println(mySet.toString());
		System.out.println("l'ensemble est vide : " + mySet.isEmpty());
		resTest = resTest && mySet.isEmpty() ;
		nbTests ++ ;		
		affResTest(31) ;
		System.out.println("sa taille est de 0 : " + mySet.size());
		resTest = resTest && (mySet.size() == 0) ;
		nbTests ++ ;		
		affResTest(32) ;
		System.out.println("ni 11, ni 12, ni 13 n'appartiennent a l'ensemble: "
				+ mySet.contains(11) + " " + mySet.contains(12) + " "
				+ mySet.contains(13));
		System.out.println("");
		System.out.println("pas de choix possible (-1) : ");
		for (int i = 0 ; i < 20 ; i++) {
			int x = mySet.random() ;
			System.out.println("resultat tirage n'appartient pas a l'ensemble : " + mySet.contains(x)) ;
			resTest = resTest && (x == -1);
		}
		nbTests ++ ;		
		affResTest(33) ;
		System.out.println("Suppression de 0 (n'est pas ds l'ensemble " + mySet);
		mySet.remove(0) ;
		nbTests ++ ;		
		affResTest(34) ;
		System.out.println("");

		System.out.println("Test du clear");
		mySet.add(1);
		mySet.add(10);
		System.out.println("Taille avant clear : " + mySet.size());
		System.out.println(mySet.toString());
		resTest = resTest && (mySet.size() == 2) ;
		nbTests ++ ;		
		affResTest(35) ;
		mySet.clear();
		System.out.println("Taille après clear : " + mySet.size());
		resTest = resTest && (mySet.size() == 0) ;
		nbTests ++ ;		
		affResTest(36) ;
		System.out.println(mySet.toString());
				
		System.out.println("\nTest du equals");
		MyCustomSet mySet2 = new MyCustomSet();
		System.out.println("ensemble1 et ensemble2 sont vides, equals (true)= " + mySet.equals(mySet2));
		System.out.println("ensemble1 et ensemble2 sont vides, equals (true) = " + mySet2.equals(mySet));
		System.out.println(mySet.toString());
		System.out.println(mySet2.toString());
		resTest = resTest && mySet.equals(mySet2) && mySet2.equals(mySet) ;
		nbTests ++ ;		
		affResTest(37) ;
		mySet.add(1);
		mySet.add(15);
		mySet.add(9);
		System.out.println("Premier ensemble 1, 15, 9");
		mySet2.add(9);
		mySet2.add(15);
		mySet2.add(1);
		System.out.println("Deuxieme ensemble 9, 15, 1");
		System.out.println(mySet.toString());
		System.out.println(mySet2.toString());
		System.out.println("Equals (true) = "+ mySet.equals(mySet2));
		System.out.println("Equals (true) = "+ mySet2.equals(mySet));
		resTest = resTest && mySet.equals(mySet2) && mySet2.equals(mySet) ;
		nbTests ++ ;		
		affResTest(38) ;
		System.out.println("On enleve 9 à ensemble 2");
		mySet2.remove(9);
		System.out.println(mySet.toString());
		System.out.println(mySet2.toString());
		System.out.println("Equals (false) = "+ mySet.equals(mySet2));
		System.out.println("Equals (false) = "+ mySet2.equals(mySet));
		resTest = resTest && (!mySet.equals(mySet2)) && (!mySet2.equals(mySet)) ;
		nbTests ++ ;		
		affResTest(39) ;
		System.out.println("On enleve 15 à ensemble 1");
		mySet.remove(15);
		System.out.println(mySet.toString());
		System.out.println(mySet2.toString());
		System.out.println("Equals (false) = "+ mySet.equals(mySet2));
		System.out.println("Equals (false) = "+ mySet2.equals(mySet));
		resTest = resTest && (!mySet.equals(mySet2)) && (!mySet2.equals(mySet)) ;
		nbTests ++ ;		
		affResTest(40) ;
		System.out.println("On enleve 1 à ensemble 1");
		mySet.remove(1);
		System.out.println(mySet.toString());
		System.out.println(mySet2.toString());
		System.out.println("Equals (false) = "+ mySet.equals(mySet2));
		System.out.println("Equals (false) = "+ mySet2.equals(mySet));
		resTest = resTest && (!mySet.equals(mySet2)) && (!mySet2.equals(mySet)) ;
		nbTests ++ ;		
		affResTest(41) ;
		System.out.println("On enleve 9 à ensemble 1");
		mySet.remove(9);
		System.out.println(mySet.toString());
		System.out.println(mySet2.toString());
		System.out.println("Equals (false) = "+ mySet.equals(mySet2));
		System.out.println("Equals (false) = "+ mySet2.equals(mySet));
		resTest = resTest && (!mySet.equals(mySet2)) && (!mySet2.equals(mySet)) ;
		nbTests ++ ;		
		affResTest(42) ;
		
		System.out.println("\n\n\t FIN DES TESTS !!!! ");
		System.out.println("\n\t RESULTAT DES TESTS (Si tout est OK on doit avoir true) = "+resTest);
		System.out.println("\t NB TESTS OK (Si tout est OK on doit avoir 100%) = "+nbTestsOK * 100 / nbTests+"%");
		System.out.println("\n\t Et on doit avoir "+nbTestsMAX+" = "+nbTests);
	}
	
}
