package modele;

public class FabriqueProfil {
	
	private FabriqueProfil() {
	    throw new IllegalStateException("Utility class");
	  }
	
	public static Profil creerProfil(ProfilUtilisateur profilUtilisateur,String nom, String prenom, String mdp) {
		switch(profilUtilisateur) {
		case GERANT:
			Personnel gerant = new Personnel(nom,prenom,mdp);
			gerant.definirGerant();
			return gerant;
		case PERSONNEL:
			Personnel personnel = new Personnel(nom,prenom,mdp);
			return personnel;
		default:
			Client client = new Client(nom,prenom,mdp);
			return client;
		}
			
	}
}
