/*
 * Test des classes MyCustomSet.java et MyCustomSortedSet.java (TP3)
 * à placer dans le même package que votre classe
 *
 */
package src;

public class TestMyCustomSortedSet {

	// les attributs pour memoriser l'etat des tests
	static boolean resTest = true ;
	static int nbTests = 0 ;
	static int nbTestsOK = 0 ;
	static final int nbTestsMAX = 129 ;
		
	
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
	
    // test de la classe MyCustomSet modifiee par le TP3
    // 51 tests sur 129 au total
    static void test1() {

		System.out.println("\n============================================");
		System.out.println("=====  TEST 1 : classe MyCustomSet   =======");
		System.out.println("============================================");
		
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

		System.out.println("\ntest du get ");
		System.out.println("get(0) = " + mySet.get(0));
		nbTests ++ ;
		resTest = resTest && (mySet.get(0)==11) ;
		affResTest(23) ;
		System.out.println("");
		System.out.println("get(1) = " + mySet.get(1));
		nbTests ++ ;
		resTest = resTest && (mySet.get(1)==12) ;
		affResTest(24) ;
		System.out.println("");
		System.out.println("get(2) = " + mySet.get(2));
		nbTests ++ ;
		resTest = resTest && (mySet.get(2)==13) ;
		affResTest(25) ;
		System.out.println("");
		System.out.println("get(-1) = " + mySet.get(-1));
		nbTests ++ ;
		resTest = resTest && (mySet.get(-1)==null) ;
		affResTest(26) ;
		System.out.println("");
		System.out.println("get(3) = " + mySet.get(3));
		nbTests ++ ;
		resTest = resTest && (mySet.get(3)==null) ;
		affResTest(27) ;
		System.out.println("");

		
		System.out.println("\n test du constructeur par clonage");
		MyCustomSet mySet1 = new MyCustomSet(mySet);
		System.out.println(mySet1.toString());
		String s = mySet.toString() ;
		String s1 = mySet1.toString() ;
		resTest = resTest && s.equals("l'ensemble contient 3 entier(s) :[11, 12, 13]") ;
		nbTests ++ ;		
		affResTest(28) ;
		resTest = resTest && s1.equals("l'ensemble contient 3 entier(s) :[11, 12, 13]") ;
		nbTests ++ ;		
		affResTest(29) ;
		resTest = resTest && s.equals(s1) ;
		nbTests ++ ;		
		affResTest(30) ;

		mySet.remove(13);
		System.out.println("Apres suppression de 13, on trouve 11-12: ");
		System.out.println(mySet.toString());
		System.out.println("l'ensemble n'est pas vide : " + mySet.isEmpty());
		resTest = resTest && (!mySet.isEmpty()) ;
		nbTests ++ ;		
		affResTest(31) ;
		System.out.println("sa taille est de 2 : " + mySet.size());
		resTest = resTest && (mySet.size() == 2) ;
		nbTests ++ ;		
		affResTest(32) ;
		System.out.println("mais la taille du clone est toujours de 3 : " + mySet1.size());
		resTest = resTest && (mySet1.size() == 3) ;
		nbTests ++ ;		
		affResTest(33) ;
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
		affResTest(34) ;
		System.out.println("Suppression de 0 (n'est pas ds l'ensemble " + mySet);
		mySet.remove(0) ;
		nbTests ++ ;		
		affResTest(35) ;
		System.out.println("");

		mySet.remove(11);
		System.out.println("Apres suppression de 11, on trouve 12: ");
		System.out.println(mySet.toString());
		System.out.println("l'ensemble n'est pas vide : " + mySet.isEmpty());
		resTest = resTest && (!mySet.isEmpty()) ;
		nbTests ++ ;		
		affResTest(36) ;
		System.out.println("sa taille est de 1 : " + mySet.size());
		resTest = resTest && (mySet.size() == 1) ;
		nbTests ++ ;		
		affResTest(37) ;
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
		affResTest(38) ;
		System.out.println("Suppression de 0 (n'est pas ds l'ensemble " + mySet);
		mySet.remove(0) ;
		nbTests ++ ;		
		affResTest(39) ;
		System.out.println("");

		mySet.remove(12);
		System.out.println("Apres suppression de 12, on trouve rien : ");
		System.out.println(mySet.toString());
		System.out.println("l'ensemble est vide : " + mySet.isEmpty());
		resTest = resTest && mySet.isEmpty() ;
		nbTests ++ ;		
		affResTest(40) ;
		System.out.println("sa taille est de 0 : " + mySet.size());
		resTest = resTest && (mySet.size() == 0) ;
		nbTests ++ ;		
		affResTest(41) ;
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
		affResTest(42) ;
		System.out.println("Suppression de 0 (n'est pas ds l'ensemble " + mySet);
		mySet.remove(0) ;
		nbTests ++ ;		
		affResTest(43) ;
		System.out.println("");

		System.out.println("Test du clear");
		mySet.add(1);
		mySet.add(10);
		System.out.println("Taille avant clear : " + mySet.size());
		System.out.println(mySet.toString());
		resTest = resTest && (mySet.size() == 2) ;
		nbTests ++ ;		
		affResTest(44) ;
		mySet.clear();
		System.out.println("Taille après clear : " + mySet.size());
		resTest = resTest && (mySet.size() == 0) ;
		nbTests ++ ;		
		affResTest(45) ;
		System.out.println(mySet.toString());
				
		System.out.println("\nTest du equals");
		MyCustomSet mySet2 = new MyCustomSet();
		System.out.println("ensemble1 et ensemble2 sont vides, equals (true)= " + mySet.equals(mySet2));
		System.out.println("ensemble1 et ensemble2 sont vides, equals (true) = " + mySet2.equals(mySet));
		System.out.println(mySet.toString());
		System.out.println(mySet2.toString());
		resTest = resTest && mySet.equals(mySet2) && mySet2.equals(mySet) ;
		nbTests ++ ;		
		affResTest(46) ;
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
		affResTest(47) ;
		System.out.println("On enleve 9 à ensemble 2");
		mySet2.remove(9);
		System.out.println(mySet.toString());
		System.out.println(mySet2.toString());
		System.out.println("Equals (false) = "+ mySet.equals(mySet2));
		System.out.println("Equals (false) = "+ mySet2.equals(mySet));
		resTest = resTest && (!mySet.equals(mySet2)) && (!mySet2.equals(mySet)) ;
		nbTests ++ ;		
		affResTest(48) ;
		System.out.println("On enleve 15 à ensemble 1");
		mySet.remove(15);
		System.out.println(mySet.toString());
		System.out.println(mySet2.toString());
		System.out.println("Equals (false) = "+ mySet.equals(mySet2));
		System.out.println("Equals (false) = "+ mySet2.equals(mySet));
		resTest = resTest && (!mySet.equals(mySet2)) && (!mySet2.equals(mySet)) ;
		nbTests ++ ;		
		affResTest(49) ;
		System.out.println("On enleve 1 à ensemble 1");
		mySet.remove(1);
		System.out.println(mySet.toString());
		System.out.println(mySet2.toString());
		System.out.println("Equals (false) = "+ mySet.equals(mySet2));
		System.out.println("Equals (false) = "+ mySet2.equals(mySet));
		resTest = resTest && (!mySet.equals(mySet2)) && (!mySet2.equals(mySet)) ;
		nbTests ++ ;		
		affResTest(50) ;
		System.out.println("On enleve 9 à ensemble 1");
		mySet.remove(9);
		System.out.println(mySet.toString());
		System.out.println(mySet2.toString());
		System.out.println("Equals (false) = "+ mySet.equals(mySet2));
		System.out.println("Equals (false) = "+ mySet2.equals(mySet));
		resTest = resTest && (!mySet.equals(mySet2)) && (!mySet2.equals(mySet)) ;
		nbTests ++ ;		
		affResTest(51) ;
    }

    // test de la classe MyCustomSortedSet
    // 78 tests sur 129 au total
    static void test2() {

		System.out.println("\n==================================================");
		System.out.println("=====  TEST 2 : classe MyCustomSortedSet   =======");
		System.out.println("==================================================");

		MyCustomSortedSet mySet = new MyCustomSortedSet();
		
		// Etape 1 : verifier qu'on a rien casse par rapport a la version non triee
		System.out.println(mySet.toString());
		System.out.println("l'ensemble est vide : " + mySet.isEmpty());
		resTest = resTest && mySet.isEmpty() ; 
		nbTests ++ ;
		affResTest(52) ;
		System.out.println("sa taille est de 0 : " + mySet.size());
		resTest = resTest && (mySet.size() == 0) ; 
		nbTests ++ ;
		affResTest(53) ;
		System.out.println("");
		System.out.println("pas de choix possible (-1) : ");
		for (int i = 0 ; i < 20 ; i++) {
			int x = mySet.random() ;
			System.out.println("resultat tirage n'appartient pas a l'ensemble : " + mySet.contains(x)) ;
			resTest = resTest && (x == -1) ;
		}
		nbTests ++ ;		
		affResTest(54) ;
		System.out.println("Suppression de 0 (n'est pas ds l'ensemble " + mySet);
		mySet.remove(0) ;
		nbTests ++ ;		
		affResTest(55) ;
		System.out.println("");

		mySet.add(11);
		System.out.println(mySet.toString());
		System.out.println("l'ensemble n'est pas vide : " + mySet.isEmpty());
		resTest = resTest && (!mySet.isEmpty()) ; 
		nbTests ++ ;
		affResTest(56) ;
		System.out.println("sa taille est de 1 : " + mySet.size());
		resTest = resTest && (mySet.size() == 1) ; 
		nbTests ++ ;
		affResTest(57) ;
		System.out.println("11 appartient a l'ensemble : " + mySet.contains(11)
				+ " et 12 non : " + mySet.contains(12));
		resTest = resTest && mySet.contains(11) && (!mySet.contains(12));
		nbTests ++ ;		
		affResTest(58) ;
		System.out.println("");
		System.out.println("avec le random un seul choix possible (11) : ");
		for (int i = 0 ; i < 20 ; i++) {
			int x = mySet.random() ;
			System.out.println("resultat tirage appartient a l'ensemble : " + mySet.contains(x)) ;
			resTest = resTest && (x == 11) ;
		}
		nbTests ++ ;		
		affResTest(59) ;
		System.out.println("Suppression de 0 (n'est pas ds l'ensemble " + mySet);
		mySet.remove(0) ;
		nbTests ++ ;		
		affResTest(60) ;
		System.out.println("");

		mySet.add(12);
		System.out.println(mySet.toString());
		System.out.println("l'ensemble n'est pas vide : " + mySet.isEmpty());
		resTest = resTest && (!mySet.isEmpty()) ;
		nbTests ++ ;		
		affResTest(61) ;
		System.out.println("sa taille est de 2 : " + mySet.size());
		resTest = resTest && (mySet.size() == 2) ;
		nbTests ++ ;		
		affResTest(62) ;
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
		affResTest(63) ;
		System.out.println("Suppression de 0 (n'est pas ds l'ensemble " + mySet);
		mySet.remove(0) ;
		nbTests ++ ;		
		affResTest(64) ;
		System.out.println("");

		mySet.add(11);
		System.out.println(mySet.toString());
		System.out.println("l'ensemble n'est pas vide : " + mySet.isEmpty());
		resTest = resTest && (!mySet.isEmpty()) ; 
		nbTests ++ ;
		affResTest(65) ;
		System.out.println("sa taille est tjrs de 2 : " + mySet.size());
		resTest = resTest && (mySet.size() == 2) ; 
		nbTests ++ ;
		affResTest(66) ;
		System.out.println("11 appartient a l'ensemble : " + mySet.contains(11)
				+ " et 12 aussi : " + mySet.contains(12));
		resTest = resTest && mySet.contains(11) && (mySet.contains(12));
		nbTests ++ ;		
		affResTest(67) ;
		System.out.println("");
		System.out.println("avec le random deux choix possibles (11 ou 12) : ");
		for (int i = 0 ; i < 20 ; i++) {
			int x = mySet.random() ;
			System.out.println("resultat tirage appartient a l'ensemble : " + mySet.contains(x)) ;
			resTest = resTest && ((x == 11) || (x == 12)) ;
		}
		nbTests ++ ;		
		affResTest(68) ;
		System.out.println("Suppression de 0 (n'est pas ds l'ensemble " + mySet);
		mySet.remove(0) ;
		nbTests ++ ;		
		affResTest(69) ;
		System.out.println("");

		mySet.add(13);
		System.out.println(mySet.toString());
		System.out.println("l'ensemble n'est pas vide : " + mySet.isEmpty());
		resTest = resTest && (!mySet.isEmpty()) ;
		nbTests ++ ;		
		affResTest(70) ;
		System.out.println("sa taille est de 3 : " + mySet.size());
		resTest = resTest && (mySet.size() == 3) ;
		nbTests ++ ;		
		affResTest(71) ;
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
		affResTest(72) ;
		System.out.println("Suppression de 0 (n'est pas ds l'ensemble " + mySet);
		mySet.remove(0) ;
		nbTests ++ ;		
		affResTest(73) ;
		System.out.println("");

		System.out.println("\ntest du get ");
		System.out.println("get(0) = " + mySet.get(0));
		nbTests ++ ;
		resTest = resTest && (mySet.get(0)==11) ;
		affResTest(74) ;
		System.out.println("");
		System.out.println("get(1) = " + mySet.get(1));
		nbTests ++ ;
		resTest = resTest && (mySet.get(1)==12) ;
		affResTest(75) ;
		System.out.println("");
		System.out.println("get(2) = " + mySet.get(2));
		nbTests ++ ;
		resTest = resTest && (mySet.get(2)==13) ;
		affResTest(76) ;
		System.out.println("");
		System.out.println("get(-1) = " + mySet.get(-1));
		nbTests ++ ;
		resTest = resTest && (mySet.get(-1)==null) ;
		affResTest(77) ;
		System.out.println("");
		System.out.println("get(3) = " + mySet.get(3));
		nbTests ++ ;
		resTest = resTest && (mySet.get(3)==null) ;
		affResTest(78) ;
		System.out.println("");

		mySet.remove(13);
		System.out.println("Apres suppression de 13, on trouve 11-12: ");
		System.out.println(mySet.toString());
		System.out.println("l'ensemble n'est pas vide : " + mySet.isEmpty());
		resTest = resTest && (!mySet.isEmpty()) ;
		nbTests ++ ;		
		affResTest(79) ;
		System.out.println("sa taille est de 2 : " + mySet.size());
		resTest = resTest && (mySet.size() == 2) ;
		nbTests ++ ;		
		affResTest(80) ;
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
		affResTest(81) ;
		System.out.println("Suppression de 0 (n'est pas ds l'ensemble " + mySet);
		mySet.remove(0) ;
		nbTests ++ ;		
		affResTest(82) ;
		System.out.println("");

		mySet.remove(11);
		System.out.println("Apres suppression de 11, on trouve 12: ");
		System.out.println(mySet.toString());
		System.out.println("l'ensemble n'est pas vide : " + mySet.isEmpty());
		resTest = resTest && (!mySet.isEmpty()) ;
		nbTests ++ ;		
		affResTest(83) ;
		System.out.println("sa taille est de 1 : " + mySet.size());
		resTest = resTest && (mySet.size() == 1) ;
		nbTests ++ ;		
		affResTest(84) ;
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
		affResTest(85) ;
		System.out.println("Suppression de 0 (n'est pas ds l'ensemble " + mySet);
		mySet.remove(0) ;
		nbTests ++ ;		
		affResTest(86) ;
		System.out.println("");

		mySet.remove(12);
		System.out.println("Apres suppression de 12, on trouve rien : ");
		System.out.println(mySet.toString());
		System.out.println("l'ensemble est vide : " + mySet.isEmpty());
		resTest = resTest && mySet.isEmpty() ;
		nbTests ++ ;		
		affResTest(87) ;
		System.out.println("sa taille est de 0 : " + mySet.size());
		resTest = resTest && (mySet.size() == 0) ;
		nbTests ++ ;		
		affResTest(88) ;
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
		affResTest(89) ;
		System.out.println("Suppression de 0 (n'est pas ds l'ensemble " + mySet);
		mySet.remove(0) ;
		nbTests ++ ;		
		affResTest(90) ;
		System.out.println("");

		System.out.println("Test du clear");
		mySet.add(1);
		mySet.add(10);
		System.out.println("Taille avant clear : " + mySet.size());
		System.out.println(mySet.toString());
		resTest = resTest && (mySet.size() == 2) ;
		nbTests ++ ;		
		affResTest(91) ;
		mySet.clear();
		System.out.println("Taille après clear : " + mySet.size());
		resTest = resTest && (mySet.size() == 0) ;
		nbTests ++ ;		
		affResTest(92) ;
		System.out.println(mySet.toString());
				
		System.out.println("\nTest du equals");
		MyCustomSortedSet mySet2 = new MyCustomSortedSet();
		System.out.println("ensemble1 et ensemble2 sont vides, equals (true)= " + mySet.equals(mySet2));
		System.out.println("ensemble1 et ensemble2 sont vides, equals (true) = " + mySet2.equals(mySet));
		System.out.println(mySet.toString());
		System.out.println(mySet2.toString());
		resTest = resTest && mySet.equals(mySet2) && mySet2.equals(mySet) ;
		nbTests ++ ;		
		affResTest(93) ;
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
		affResTest(94) ;
		System.out.println("On enleve 9 à ensemble 2");
		mySet2.remove(9);
		System.out.println(mySet.toString());
		System.out.println(mySet2.toString());
		System.out.println("Equals (false) = "+ mySet.equals(mySet2));
		System.out.println("Equals (false) = "+ mySet2.equals(mySet));
		resTest = resTest && (!mySet.equals(mySet2)) && (!mySet2.equals(mySet)) ;
		nbTests ++ ;		
		affResTest(95) ;
		System.out.println("On enleve 15 à ensemble 1");
		mySet.remove(15);
		System.out.println(mySet.toString());
		System.out.println(mySet2.toString());
		System.out.println("Equals (false) = "+ mySet.equals(mySet2));
		System.out.println("Equals (false) = "+ mySet2.equals(mySet));
		resTest = resTest && (!mySet.equals(mySet2)) && (!mySet2.equals(mySet)) ;
		nbTests ++ ;		
		affResTest(96) ;
		System.out.println("On enleve 1 à ensemble 1");
		mySet.remove(1);
		System.out.println(mySet.toString());
		System.out.println(mySet2.toString());
		System.out.println("Equals (false) = "+ mySet.equals(mySet2));
		System.out.println("Equals (false) = "+ mySet2.equals(mySet));
		resTest = resTest && (!mySet.equals(mySet2)) && (!mySet2.equals(mySet)) ;
		nbTests ++ ;		
		affResTest(97) ;
		System.out.println("On enleve 9 à ensemble 1");
		mySet.remove(9);
		System.out.println(mySet.toString());
		System.out.println(mySet2.toString());
		System.out.println("Equals (false) = "+ mySet.equals(mySet2));
		System.out.println("Equals (false) = "+ mySet2.equals(mySet));
		resTest = resTest && (!mySet.equals(mySet2)) && (!mySet2.equals(mySet)) ;
		nbTests ++ ;		
		affResTest(98) ;

		// Etape 2 : verifier les fonctionnalites propres a la version triee
		// Test du add
		System.out.println("\nTest du add trie");
		mySet.clear();
		mySet.add(1);
		mySet.add(15);
		mySet.add(15);
		mySet.add(12);
		mySet.add(8);
		mySet.add(8);
		mySet.add(3);
		mySet.add(10);
		// Result =  1, 3, 8, 10, 12, 15
		System.out.println("Ensemble1: " + mySet.toString());
		String s = mySet.toString() ;
		resTest = resTest && s.equals("l'ensemble contient 6 entier(s) :[1, 3, 8, 10, 12, 15]") ;
		nbTests ++ ;		
		affResTest(99) ;
		
		mySet2.clear();
		mySet2.add(3);
		mySet2.add(7);
		mySet2.add(16);
		mySet2.add(10);
		System.out.println("Ensemble2: " + mySet2.toString());
		// Result =  3, 7, 10, 16
		s = mySet2.toString() ;
		resTest = resTest && s.equals("l'ensemble contient 4 entier(s) :[3, 7, 10, 16]") ;
		nbTests ++ ;		
		affResTest(100) ;

		
		// Union des deux : 1, 3, 7, 8, 10, 12, 15, 16
		System.out.println("\nTest du union (les deux ensembles sont non vides)");
		System.out.println("Ensemble1 UNION Ensemble2: " + mySet.union(mySet2));
		s =  mySet.union(mySet2).toString();
		resTest = resTest && s.equals("l'ensemble contient 8 entier(s) :[1, 3, 7, 8, 10, 12, 15, 16]") ;
		nbTests ++ ;		
		affResTest(101) ;
		System.out.println("Ensemble2 UNION Ensemble1: " + mySet2.union(mySet));
		s =  mySet2.union(mySet).toString();
		resTest = resTest && s.equals("l'ensemble contient 8 entier(s) :[1, 3, 7, 8, 10, 12, 15, 16]") ;
		nbTests ++ ;		
		affResTest(102) ;
		
		// Intersection des deux : 3, 10
		System.out.println("\nTest du intersection (les deux ensembles sont non vides)");
		System.out.println("Ensemble1 INTERSECTION Ensemble2: " + mySet.intersection(mySet2));
		s =  mySet.intersection(mySet2).toString();
		resTest = resTest && s.equals("l'ensemble contient 2 entier(s) :[3, 10]") ;
		nbTests ++ ;		
		affResTest(103) ;
		System.out.println("Ensemble2 INTERSECTION Ensemble1: " + mySet2.intersection(mySet));
		s =  mySet2.intersection(mySet).toString();
		resTest = resTest && s.equals("l'ensemble contient 2 entier(s) :[3, 10]") ;
		nbTests ++ ;		
		affResTest(104) ;
		
		// Différence 1 : 1, 8, 12, 15 
		System.out.println("\nTest du difference (les deux ensembles sont non vides)");
		System.out.println("Ensemble1 MOINS Ensemble2: " + mySet.difference(mySet2));
		s =  mySet.difference(mySet2).toString();
		resTest = resTest && s.equals("l'ensemble contient 4 entier(s) :[1, 8, 12, 15]") ;
		nbTests ++ ;		
		affResTest(105) ;
		
		// Différence 2 : 7, 16
		System.out.println("Ensemble2 MOINS Ensemble1: " + mySet2.difference(mySet));
		s =  mySet2.difference(mySet).toString();
		resTest = resTest && s.equals("l'ensemble contient 2 entier(s) :[7, 16]") ;
		nbTests ++ ;		
		affResTest(106) ;
		
		// Sous ensemble
		System.out.println("\nTest du subset (les deux ensembles sont non vides)");
		System.out.println("Ensemble2 SOUS ENSEMBLE DE Ensemble1: " + mySet.subset(mySet2));
		resTest = resTest && !mySet.subset(mySet2) ;
		nbTests ++ ;		
		affResTest(107) ;
		// Sous ensemble
		System.out.println("Ensemble1 SOUS ENSEMBLE DE Ensemble1: " + mySet.subset(mySet));
		resTest = resTest && mySet.subset(mySet) ;
		nbTests ++ ;		
		affResTest(108) ;
		
		// Nearest 1 = 1
		System.out.println("\nTest du nearest");
		System.out.println("Nearest 1: " + mySet.nearest(1));
		resTest = resTest && (mySet.nearest(1)==1) ;
		nbTests ++ ;		
		affResTest(109) ;
		// Nearest 12 = 12
		System.out.println("Nearest 12: " + mySet.nearest(12));
		resTest = resTest && (mySet.nearest(12)==12) ;
		nbTests ++ ;		
		affResTest(110) ;
		// Nearest 14 = 15
		System.out.println("Nearest 14: " + mySet.nearest(14));
		resTest = resTest && (mySet.nearest(14)==15) ;
		nbTests ++ ;		
		affResTest(111) ;
		// Nearest 22 = 15
		System.out.println("Nearest 22: " + mySet.nearest(22));
		resTest = resTest && (mySet.nearest(22)==15) ;
		nbTests ++ ;		
		affResTest(112) ;
		// Nearest 7 = 8
		System.out.println("Nearest 7: " + mySet.nearest(7));
		resTest = resTest && (mySet.nearest(7)==8) ;
		nbTests ++ ;		
		affResTest(113) ;


		// Cas ou l'un des deux ensembles est vide
		mySet.clear() ;
		// Union des deux : 3, 7, 10, 16
		System.out.println("\nTest du union (un des deux ensembles est vide)");
		System.out.println("Ensemble1 UNION Ensemble2: " + mySet.union(mySet2));
		s =  mySet.union(mySet2).toString();
		resTest = resTest && s.equals("l'ensemble contient 4 entier(s) :[3, 7, 10, 16]") ;
		nbTests ++ ;		
		affResTest(114) ;
		System.out.println("Ensemble2 UNION Ensemble1: " + mySet2.union(mySet));
		s =  mySet2.union(mySet).toString();
		resTest = resTest && s.equals("l'ensemble contient 4 entier(s) :[3, 7, 10, 16]") ;
		nbTests ++ ;		
		affResTest(115) ;
		
		// Intersection des deux : rien
		System.out.println("\nTest du intersection (un des deux ensembles est vide)");
		System.out.println("Ensemble1 INTERSECTION Ensemble2: " + mySet.intersection(mySet2));
		s =  mySet.intersection(mySet2).toString();
		resTest = resTest && s.equals("l'ensemble contient 0 entier(s) :[]") ;
		nbTests ++ ;		
		affResTest(116) ;
		System.out.println("Ensemble2 INTERSECTION Ensemble1: " + mySet2.intersection(mySet));
		s =  mySet2.intersection(mySet).toString();
		resTest = resTest && s.equals("l'ensemble contient 0 entier(s) :[]") ;
		nbTests ++ ;		
		affResTest(117) ;
		
		// Différence 1 : rien 
		System.out.println("\nTest du difference (un des deux ensembles est vide)");
		System.out.println("Ensemble1 MOINS Ensemble2: " + mySet.difference(mySet2));
		s =  mySet.difference(mySet2).toString();
		resTest = resTest && s.equals("l'ensemble contient 0 entier(s) :[]") ;
		nbTests ++ ;		
		affResTest(118) ;
		
		// Différence 2 : 3, 7, 10, 16
		System.out.println("Ensemble2 MOINS Ensemble1: " + mySet2.difference(mySet));
		s =  mySet2.difference(mySet).toString();
		resTest = resTest && s.equals("l'ensemble contient 4 entier(s) :[3, 7, 10, 16]") ;
		nbTests ++ ;		
		affResTest(119) ;
		
		// Sous ensemble
		System.out.println("\nTest du subset (un des deux ensembles est vide)");
		System.out.println("Ensemble2 SOUS ENSEMBLE DE Ensemble1: " + mySet.subset(mySet2));
		resTest = resTest && !mySet.subset(mySet2) ;
		nbTests ++ ;		
		affResTest(120) ;
		// Sous ensemble
		System.out.println("Ensemble1 SOUS ENSEMBLE DE Ensemble2: " + mySet2.subset(mySet));
		resTest = resTest && mySet2.subset(mySet) ;
		nbTests ++ ;		
		affResTest(121) ;
		


		// Cas ou les deux ensembles sont vides
		mySet2.clear() ;
		// Union des deux : rien
		System.out.println("\nTest du union (les deux ensembles sont vides)");
		System.out.println("Ensemble1 UNION Ensemble2: " + mySet.union(mySet2));
		s =  mySet.union(mySet2).toString();
		resTest = resTest && s.equals("l'ensemble contient 0 entier(s) :[]") ;
		nbTests ++ ;		
		affResTest(122) ;
		System.out.println("Ensemble2 UNION Ensemble1: " + mySet2.union(mySet));
		s =  mySet2.union(mySet).toString();
		resTest = resTest && s.equals("l'ensemble contient 0 entier(s) :[]") ;
		nbTests ++ ;		
		affResTest(123) ;
		
		// Intersection des deux : rien
		System.out.println("\nTest du intersection (les deux ensembles sont vides)");
		System.out.println("Ensemble1 INTERSECTION Ensemble2: " + mySet.intersection(mySet2));
		s =  mySet.intersection(mySet2).toString();
		resTest = resTest && s.equals("l'ensemble contient 0 entier(s) :[]") ;
		nbTests ++ ;		
		affResTest(124) ;
		System.out.println("Ensemble2 INTERSECTION Ensemble1: " + mySet2.intersection(mySet));
		s =  mySet2.intersection(mySet).toString();
		resTest = resTest && s.equals("l'ensemble contient 0 entier(s) :[]") ;
		nbTests ++ ;		
		affResTest(125) ;
		
		// Différence 1 : rien 
		System.out.println("\nTest du difference (les deux ensembles sont vides)");
		System.out.println("Ensemble1 MOINS Ensemble2: " + mySet.difference(mySet2));
		s =  mySet.difference(mySet2).toString();
		resTest = resTest && s.equals("l'ensemble contient 0 entier(s) :[]") ;
		nbTests ++ ;		
		affResTest(126) ;
		
		// Différence 2 : rien
		System.out.println("Ensemble2 MOINS Ensemble1: " + mySet2.difference(mySet));
		s =  mySet2.difference(mySet).toString();
		resTest = resTest && s.equals("l'ensemble contient 0 entier(s) :[]") ;
		nbTests ++ ;		
		affResTest(127) ;
		
		// Sous ensemble
		System.out.println("\nTest du subset (les deux ensembles sont vides)");
		System.out.println("Ensemble2 SOUS ENSEMBLE DE Ensemble1: " + mySet.subset(mySet2));
		resTest = resTest && mySet.subset(mySet2) ;
		nbTests ++ ;		
		affResTest(128) ;
		// Sous ensemble
		System.out.println("Ensemble1 SOUS ENSEMBLE DE Ensemble2: " + mySet2.subset(mySet));
		resTest = resTest && mySet2.subset(mySet) ;
		nbTests ++ ;		
		affResTest(129) ;
    }
	
	// Programme principal, sert ici de programme de test
	public static void main(String[] args) {
		
		test1();
		test2() ;
		
		System.out.println("\n\n\t FIN DES TESTS !!!! ");
		System.out.println("\n\t RESULTAT DES TESTS (Si tout est OK on doit avoir true) = "+resTest);
		System.out.println("\t NB TESTS OK (Si tout est OK on doit avoir 100%) = "+nbTestsOK * 100 / nbTests+"%");
		System.out.println("\n\t Et on doit avoir "+nbTestsMAX+" = "+nbTests);
	}
}

