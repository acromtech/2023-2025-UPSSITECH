package controleur;

import modele.BDClient;
import modele.BDPersonnel;
import modele.Client;
import modele.Personnel;
import modele.ProfilUtilisateur;

public class ControlVerifierIdentification {
	
	
	public boolean verifierIdentification(ProfilUtilisateur profilUtilisateur, int numeroProfil) {
		boolean retour = false;
		BDPersonnel bdPersonnel = BDPersonnel.getInstance();
		switch(profilUtilisateur) {
		case CLIENT:
			BDClient bdClient = BDClient.getInstance();
			Client client = bdClient.trouverClient(numeroProfil);
			if(client != null) {
				retour = client.isConnecte();
			}
			break;
		case PERSONNEL:
			Personnel personnel = bdPersonnel.trouverPersonnel(numeroProfil);
			if(personnel != null) {
				retour = personnel.isConnecte();
			}
			break;
		default:
			personnel = bdPersonnel.trouverPersonnel(numeroProfil);
			if(personnel != null && personnel.isGerant()) {
				retour = personnel.isConnecte();
			}
		}
		return retour;
	}

}
