package src;
/*
* TestAgenda : les tests pour le TP2
*/
public class TestAgenda {
	
	// attributs pour tests auto
	static	boolean resTest = true ;
	static	int nbTests = 0 ;
	static	int nbTestsOK = 0 ;
	static final int nbTestsMAX = 65 ;
		
		
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
		
	// methode d'affichage des resultats de test 
	// a utiliser a chaque etape OK
	static void affResTestOK(int numTest) {
		System.out.println("Test "+numTest+" OK");
	}
		
	// methode d'affichage des resultats de test 
	// a utiliser a chaque etape OK
	static void affResTestNOK(int numTest) {
    		// resTest = false ;
		System.out.println("Test "+numTest+" NOK");
	}

	// tests pour horaire
	// 10 tests sur 65 au total
	static void testHoraire () {
		System.out.println("=============================================") ;
		System.out.println("============== TEST HORAIRE   ===============") ;
		System.out.println("=============================================") ;
		
		try {
			Horaire ho = new Horaire(10,5) ;
			System.out.println("ho = "+ho.toString());
			resTest = resTest && ho.toString().equals("10:5") ; 
			nbTests ++ ;
			affResTest(1) ;

			Horaire hobis = new Horaire(ho) ;
			System.out.println("hobis (clone de ho) = "+hobis.toString());
			resTest = resTest && hobis.toString().equals(ho.toString()) ; 
			nbTests ++ ;
			affResTest(2) ;

			Horaire ho2 = new Horaire(10,10) ;
			System.out.println("ho2 = "+ho2.toString());
			resTest = resTest && ho2.toString().equals("10:10") ; 
			nbTests ++ ;
			affResTest(3) ;
			Horaire ho3 = new Horaire(9,10) ;
			System.out.println("ho3 = "+ho3.toString());
			resTest = resTest && ho3.toString().equals("9:10") ; 
			nbTests ++ ;
			affResTest(4) ;
			
			System.out.println("");
			System.out.println("ho est apres ho3 et n'est pas apres ho2 : "
			                   +ho.apres(ho3)+", "+ho.apres(ho2));
			System.out.println("ho n'est pas apres ho : "+ho.apres(ho));
			resTest = resTest && ho.apres(ho3) && !ho.apres(ho2) && !ho.apres(ho) ; 
			nbTests ++ ;
			affResTest(5) ;

			System.out.println("");
			System.out.println("ho n'est pas egal a ho3 et n'est pas egals a ho2 : "
			                   +ho.equals(ho3)+", "+ho.equals(ho2));
			System.out.println("ho est egal a ho : "+ho.equals(ho));
			resTest = resTest && !ho.equals(ho3) && !ho.equals(ho2) && ho.equals(ho); 
			nbTests ++ ;
			affResTest(6) ;
		}
		catch (ExceptionTP2 e) {
			System.out.println("Tests 1 a 6 : NOK");		
		}
	
		Horaire h1 =null ;
		nbTests ++ ;
		try {
			h1 = new Horaire(-1,10) ;
			affResTestNOK(7);
		}
		catch (ExceptionTP2 e) {
			System.out.println("(-1,10) : "+e.getMessage());		
			affResTest(7) ;
		}
	
		nbTests ++ ;
		try {
			h1 = new Horaire(1,-10) ;
			affResTestNOK(8);
		}
		catch (ExceptionTP2 e) {
			System.out.println("(1,-10) : "+e.getMessage());		
			affResTest(8) ;
		}
	
		nbTests ++ ;
		try {
			h1 = new Horaire(100,10) ;
			affResTestNOK(9);
		}
		catch (ExceptionTP2 e) {
			System.out.println("(100,10) : "+e.getMessage());		
			affResTest(9) ;
		}
	
		nbTests ++ ;
		try {
			h1 = new Horaire(1,100) ;
			affResTestNOK(10);
		}
		catch (ExceptionTP2 e) {
			System.out.println("(1,100) : "+e.getMessage());		
			affResTest(10) ;
		}

	}
	

	// tests pour date
	// 24 tests sur 65 au total
	static void testDate () {
		System.out.println("==========================================") ;
		System.out.println("============== TEST DATE   ===============") ;
		System.out.println("==========================================") ;

		try {
			Date d = new Date(10,5,2007) ;
			System.out.println("");
			System.out.println(d.toString());
			resTest = resTest && d.toString().equals("10/5/2007") ; 
			nbTests ++ ;
			affResTest(11) ;

			Date dbis = new Date(d) ;
			System.out.println("");
			System.out.println(dbis.toString());
			resTest = resTest && d.toString().equals("10/5/2007") ; 
			nbTests ++ ;
			affResTest(12) ;

			Date d1 = new Date(10,5,2008) ;
			Date d1bis = new Date(10,6,2007) ;
			Date d1ter = new Date(11,5,2007) ;
			Date d2 = new Date(10,5,2006) ;
			Date d2bis = new Date(10,4,2007) ;
			Date d2ter = new Date(9,5,2007) ;
			System.out.println("");
			System.out.println("d n'est pas apres d1, d1bis et d1ter : "
			   +d.apres(d1)+", "+d.apres(d1bis)+", "+d.apres(d1ter));
			resTest = resTest && !d.apres(d1) && !d.apres(d1bis) && !d.apres(d1ter) ; 
			nbTests ++ ;
			affResTest(13) ;
			System.out.println("d est apres d2, d2bis et d2ter : "+d.apres(d2)+", "+
			   d.apres(d2bis)+", "+d.apres(d2ter));
			resTest = resTest && d.apres(d2) && d.apres(d2bis) && d.apres(d2ter) ; 
			nbTests ++ ;
			affResTest(14) ;
			System.out.println("d n'est pas apres d : "+d.apres(d));
			resTest = resTest && !d.apres(d) ; 
			nbTests ++ ;
			affResTest(15) ;
			System.out.println("");
			System.out.println("d n'est pas egal a d1 et n'est pas egal a d2 : "+
			   d.equals(d1)+", "+d.equals(d2));
			resTest = resTest && !d.equals(d1) && !d.equals(d2) ; 
			nbTests ++ ;
			affResTest(16) ;
			System.out.println("d est egal a d et a d.bis : "+d.equals(d)+", "+d.equals(dbis));
			resTest = resTest && d.equals(d) && d.equals(dbis) ; 
			nbTests ++ ;
			affResTest(17) ;


			Date d3 = new Date(31,1,2007) ;
			Date d31 = new Date(30,4,2007) ;
			Date d32 = new Date(31,12,2007) ;
			Date d34 = new Date(28,2,2007) ;
			Date d35 = new Date(28,2,2008) ;
			Date d36 = new Date(28,2,2000) ;
			System.out.println("");
			System.out.println("L'annee suivant le 10/5/2007 est : "+d.anneeSuivante());
			resTest = resTest && d.anneeSuivante().toString().equals("10/5/2008") ; 
			nbTests ++ ;
			affResTest(18) ;
			System.out.println("Le mois suivant le 10/5/2007 est : "+d.moisSuivant());
			resTest = resTest && d.moisSuivant().toString().equals("10/6/2007") ; 
			nbTests ++ ;
			affResTest(19) ;
			System.out.println("Le jour suivant le 10/5/2007 est : "+d.jourSuivant());
			resTest = resTest && d.jourSuivant().toString().equals("11/5/2007") ; 
			nbTests ++ ;
			affResTest(20) ;
			System.out.println("");
			System.out.println("Le mois suivant le 31/12/2007 est : "+d32.moisSuivant());
			resTest = resTest && d32.moisSuivant().toString().equals("31/1/2008") ; 
			nbTests ++ ;
			affResTest(21) ;
			System.out.println("Le jour suivant le 31/12/2007 est : "+d32.jourSuivant());
			resTest = resTest && d32.jourSuivant().toString().equals("1/1/2008") ; 
			nbTests ++ ;
			affResTest(22) ;
			System.out.println("");
			System.out.println("Le jour suivant le 31/1/2007 est : "+d3.jourSuivant());
			resTest = resTest && d3.jourSuivant().toString().equals("1/2/2007") ; 
			nbTests ++ ;
			affResTest(23) ;
			System.out.println("Le jour suivant le 30/4/2007 est : "+d31.jourSuivant());
			resTest = resTest && d31.jourSuivant().toString().equals("1/5/2007") ; 
			nbTests ++ ;
			affResTest(24) ;
			System.out.println("Le jour suivant le 28/2/2007 est : "+d34.jourSuivant());
			resTest = resTest && d34.jourSuivant().toString().equals("1/3/2007") ; 
			nbTests ++ ;
			affResTest(25) ;
			System.out.println("Le jour suivant le 28/2/2008 est : "+d35.jourSuivant());
			resTest = resTest && d35.jourSuivant().toString().equals("29/2/2008") ; 
			nbTests ++ ;
			affResTest(26) ;
			System.out.println("Le jour suivant le 28/2/2000 est : "+d36.jourSuivant());
			resTest = resTest && d36.jourSuivant().toString().equals("29/2/2000") ; 
			nbTests ++ ;
			affResTest(27) ;

		}
		catch (ExceptionTP2 e) {
			System.out.println("Tests 11 a 27 : NOK");		
		}
	
		Date di =null ;
		nbTests ++ ;
		try {
			di = new Date(0,10,2000) ;
			System.out.println(di.toString());
			affResTestNOK(28);
		}
		catch (ExceptionTP2 e) {
			System.out.println("(0,10,2000) : "+e.getMessage());		
			affResTest(28) ;
		}
	
		nbTests ++ ;
		try {
			di = new Date(1,-10,2000) ;
			System.out.println(di.toString());
			affResTestNOK(29);
		}
		catch (ExceptionTP2 e) {
			System.out.println("(1,-10,2000) : "+e.getMessage());		
			affResTest(29) ;
		}
	
		nbTests ++ ;
		try {
			di = new Date(100,10,2000) ;
			System.out.println(di.toString());
			affResTestNOK(30);
		}
		catch (ExceptionTP2 e) {
			System.out.println("(100,10,2000) : "+e.getMessage());		
			affResTest(30) ;
		}
	
		nbTests ++ ;
		try {
			di = new Date(1,100,2000) ;
			System.out.println(di.toString());
			affResTestNOK(31);
		}
		catch (ExceptionTP2 e) {
			System.out.println("(1,100,2000) : "+e.getMessage());		
			affResTest(31) ;
		}
	
		nbTests ++ ;
		try {
			di = new Date(32,10,2000) ;
			System.out.println(di.toString());
			affResTestNOK(32);
		}
		catch (ExceptionTP2 e) {
			System.out.println("(32,10,2000) : "+e.getMessage());		
			affResTest(32) ;
		}
	
		nbTests ++ ;
		try {
			di = new Date(29,02,2000) ;
			System.out.println(di.toString());
			di = new Date(28,02,2001) ;
			System.out.println(di.toString());
			di = new Date(30,02,2000) ;
			System.out.println(di.toString());
			affResTestNOK(33);
		}
		catch (ExceptionTP2 e) {
			System.out.println("(30,02,2000) : "+e.getMessage());		
			affResTest(33) ;
		}
	
		nbTests ++ ;
		try {
			di = new Date(29,02,2001) ;
			System.out.println(di.toString());
			affResTestNOK(34);
		}
		catch (ExceptionTP2 e) {
			System.out.println("(29,02,2001) : "+e.getMessage());		
			affResTest(34) ;
		}

	}
	

	// tests pour RDV
	// 16 tests sur 65 au total
	static void testRDV () {
		System.out.println("=========================================") ;
		System.out.println("============== TEST RDV   ===============") ;
		System.out.println("=========================================") ;

		try {
			RDV r = new RDV(new Date(10,5,2007), new Horaire(10,5), "Dupont") ;
			System.out.println("");
			System.out.println(r.toString());
			resTest = resTest && r.toString().equals("Le RDV est pour Dupont a 10/5/2007 et a 10:5") ; 
			nbTests ++ ;
			affResTest(35) ;

			RDV rbis = new RDV(r) ;
			System.out.println("");
			System.out.println(rbis.toString());
			resTest = resTest && rbis.toString().equals("Le RDV est pour Dupont a 10/5/2007 et a 10:5") ; 
			nbTests ++ ;
			affResTest(36) ;

			RDV r1 = new RDV(new Date(10,6,2007), new Horaire(10,5), "Dupont") ;
			RDV r2 = new RDV(new Date(10,5,2007), new Horaire(10,10), "Dupont") ;
			RDV r3 = new RDV(new Date(10,4,2007), new Horaire(10,5), "Dupont") ;
			System.out.println("");
			System.out.println("r n'est pas apres r1, r2 : "
			   +r.apres(r1)+", "+r.apres(r2));
			resTest = resTest && !r.apres(r1) && !r.apres(r2) ; 
			nbTests ++ ;
			affResTest(37) ;
			System.out.println("r est apres r3 : "+r.apres(r3));
			resTest = resTest && r.apres(r3) ; 
			nbTests ++ ;
			affResTest(38) ;
			System.out.println("r n'est pas apres r : "+r.apres(r));
			resTest = resTest && !r.apres(r) ; 
			nbTests ++ ;
			affResTest(39) ;
			System.out.println("");
			System.out.println("r n'est pas egal a r1, ni a r2, ni a r3 : "+
			   r.equals(r1)+", "+r.equals(r2)+", "+r.equals(r2));
			resTest = resTest && !r.equals(r1) && !r.equals(r2) && !r.equals(r2) ; 
			nbTests ++ ;
			affResTest(40) ;
			System.out.println("r est egal a r et a r.bis : "+r.equals(r)+", "+r.equals(rbis));
			resTest = resTest && r.equals(r) && r.equals(rbis) ; 
			nbTests ++ ;
			affResTest(41) ;


			System.out.println("");
			System.out.println("le champ date de r est : "+r.getDate().toString());
			resTest = resTest && r.getDate().toString().equals("10/5/2007") ; 
			nbTests ++ ;
			affResTest(42) ;
			System.out.println("le champ horaire de r est : "+r.getHoraire().toString());
			resTest = resTest && r.getHoraire().toString().equals("10:5") ; 
			nbTests ++ ;
			affResTest(43) ;
			System.out.println("le champ nom de r est : "+r.getNom().toString());
			resTest = resTest && r.getNom().toString().equals("Dupont") ; 
			nbTests ++ ;
			affResTest(44) ;

			System.out.println("");
			System.out.println("Apres maj des champs avec Durand, le 31/01/2008 a 13h40, on a ");
			r.setDate(new Date(31,01,2008)) ;
			r.setHoraire(new Horaire(13,40)) ;
			r.setNom(new String("Durand")) ;
			System.out.println("le champ date de r est : "+r.getDate().toString());
			resTest = resTest && r.getDate().toString().equals("31/1/2008") ; 
			nbTests ++ ;
			affResTest(45) ;
			System.out.println("le champ horaire de r est : "+r.getHoraire().toString());
			resTest = resTest && r.getHoraire().toString().equals("13:40") ; 
			nbTests ++ ;
			affResTest(46) ;
			System.out.println("le champ nom de r est : "+r.getNom().toString());
			resTest = resTest && r.getNom().toString().equals("Durand") ; 
			nbTests ++ ;
			affResTest(47) ;
			System.out.println("Mais rbis n'a pas change !! ");
 			System.out.println("le champ date de rbis est : "+rbis.getDate().toString());
			resTest = resTest && rbis.getDate().toString().equals("10/5/2007") ; 
			nbTests ++ ;
			affResTest(48) ;
			System.out.println("le champ horaire de rbis est : "+rbis.getHoraire().toString());
			resTest = resTest && rbis.getHoraire().toString().equals("10:5") ; 
			nbTests ++ ;
			affResTest(49) ;
			System.out.println("le champ nom de rbis est : "+rbis.getNom().toString());
			resTest = resTest && rbis.getNom().toString().equals("Dupont") ; 
			nbTests ++ ;
			affResTest(50) ;
		}
		catch (ExceptionTP2 e) {
			System.out.println("Tests 35 à 50 : NOK");		
		}
	}
	

	// tests pour agenda
	// 15 tests sur 65 au total
	static void testAgenda () {
		System.out.println("=============================================") ;
		System.out.println("============== TEST AGENDA    ===============") ;
		System.out.println("=============================================") ;

		try {
			Agenda a = new Agenda() ;
			System.out.println("");
			System.out.println(a.toString());
			resTest = resTest && a.toString().equals("L'agenda contient : \n") ; 
			nbTests ++ ;
			affResTest(51) ;

			a.ajoutRDV(new RDV(new Date(10,6,2007), new Horaire(10,5), "Dupont")) ;
			System.out.println("");
			System.out.println(a.toString());
			resTest = resTest && a.toString().equals("L'agenda contient : \n"+
					"Le RDV est pour Dupont a 10/6/2007 et a 10:5\n") ; 
			nbTests ++ ;
			affResTest(52) ;

			a.ajoutRDV(new RDV(new Date(31,12,2002), new Horaire(13,40), "Toto")) ;
			System.out.println("");
			System.out.println(a.toString());
			resTest = resTest && a.toString().equals("L'agenda contient : \n"+
					"Le RDV est pour Dupont a 10/6/2007 et a 10:5\n"+
					"Le RDV est pour Toto a 31/12/2002 et a 13:40\n") ; 
			nbTests ++ ;
			affResTest(53) ;

			RDV r =  a.getRDVParDateEtHeure(new Date(10,6,2007), new Horaire(10,5)) ;
			System.out.println("");
			System.out.println("Le 10/06/2007 a 10h5, il y a le RDV : "+r.toString());
			resTest = resTest && r.toString().equals("Le RDV est pour Dupont a 10/6/2007 et a 10:5") ; 
			nbTests ++ ;
			affResTest(54) ;

			r =  a.getRDVParDateEtHeure(new Date(10,6,2005), new Horaire(10,5)) ;
			System.out.println("");
			System.out.println("Le 10/06/2005 a 10h5, il n'y a pas de RDV : "+r);
			resTest = resTest && (r==null) ; 
			nbTests ++ ;
			affResTest(55) ;

			r =  a.getRDVParDateEtHeure(new Date(31,12,2002), new Horaire(10,5)) ;
			System.out.println("");
			System.out.println("Le 31/12/2002 a 10h5, il n'y a pas de RDV : "+r);
			resTest = resTest && (r==null) ; 
			nbTests ++ ;
			affResTest(56) ;

			r =  a.getRDVParDateEtHeure(new Date(31,12,2002), new Horaire(13,40)) ;
			System.out.println("");
			System.out.println("Le 31/12/2002 a 13h40, il y a le RDV : "+r.toString());
			resTest = resTest && r.toString().equals("Le RDV est pour Toto a 31/12/2002 et a 13:40") ; 
			nbTests ++ ;
			affResTest(57) ;

			r =  a.getRDVParNom(new String("Dupont")) ;
			System.out.println("");
			System.out.println("Pour Dupont, il y a le RDV : "+r.toString());
			resTest = resTest && r.toString().equals("Le RDV est pour Dupont a 10/6/2007 et a 10:5") ; 
			nbTests ++ ;
			affResTest(58) ;

			r =  a.getRDVParNom(new String("Toto")) ;
			System.out.println("");
			System.out.println("Pour Toto, il y a le RDV : "+r.toString());
			resTest = resTest && r.toString().equals("Le RDV est pour Toto a 31/12/2002 et a 13:40") ; 
			nbTests ++ ;
			affResTest(59) ;

			r =  a.getRDVParNom(new String("Titi")) ;
			System.out.println("");
			System.out.println("Pour Titi, il n'y a pas de RDV : "+r);
			resTest = resTest && (r==null) ; 
			nbTests ++ ;
			affResTest(60) ;

			System.out.println("");
			System.out.println("Avant les suppressions \n "+a.toString());
			a.supprimeRDVParDateEtHeure(new Date(10,6,2007), new Horaire(10,5));
			System.out.println("");
			System.out.println("On supprime le RDV du 10/06/2007 a 10h5 "+a.toString());
			resTest = resTest && a.toString().equals("L'agenda contient : \n"+
			      "Le RDV est pour Toto a 31/12/2002 et a 13:40\n") ; 
			nbTests ++ ;
			affResTest(61) ;

			a.supprimeRDVParDateEtHeure(new Date(10,6,2005), new Horaire(10,5)) ;
			System.out.println("");
			System.out.println("On supprime un RDV pour une date qui n'existe pas "+a.toString());
			resTest = resTest && a.toString().equals("L'agenda contient : \n"+
			      "Le RDV est pour Toto a 31/12/2002 et a 13:40\n") ; 
			nbTests ++ ;
			affResTest(62) ;

			a.supprimeRDVParDateEtHeure(new Date(31,12,2002), new Horaire(10,5)) ;
			System.out.println("");
			System.out.println("On supprime un RDV pour un horaire qui n'existe pas "+a.toString());
			resTest = resTest && a.toString().equals("L'agenda contient : \n"+
			      "Le RDV est pour Toto a 31/12/2002 et a 13:40\n") ; 
			nbTests ++ ;
			affResTest(63) ;

			a.supprimeRDVParNom(new String("Titi")) ;
			System.out.println("");
			System.out.println("On supprime un RDV pour un nom qui n'existe pas "+a.toString());
			resTest = resTest && a.toString().equals("L'agenda contient : \n"+
			      "Le RDV est pour Toto a 31/12/2002 et a 13:40\n") ; 
			nbTests ++ ;
			affResTest(64) ;

			a.supprimeRDVParNom(new String("Toto")) ;
			System.out.println("");
			System.out.println("On supprime un RDV de Toto "+a.toString());
			resTest = resTest && a.toString().equals("L'agenda contient : \n") ; 
			nbTests ++ ;
			affResTest(65) ;
		}
		catch (ExceptionTP2 e) {
			System.out.println("Tests 51 à 65 : NOK");		
		}
	}
	
	public static void main (String args[]) {
		testHoraire () ;
		testDate () ;
		testRDV () ;
		testAgenda () ;
		
		System.out.println("\n\n\t FIN DES TESTS !!!! ");
		System.out.println("\n\t RESULTAT DES TESTS (Si tout est OK on doit avoir true) = "+resTest);
		System.out.println("\t NB TESTS OK (Si tout est OK on doit avoir 100%) = "+nbTestsOK * 100 / nbTests+"%");
		System.out.println("\n\t Et on doit avoir "+nbTestsMAX+" = "+nbTests);
	}
}

