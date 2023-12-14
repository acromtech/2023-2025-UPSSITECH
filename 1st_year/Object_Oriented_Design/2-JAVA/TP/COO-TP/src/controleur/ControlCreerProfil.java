package controleur;

import modele.BDClient;
import modele.BDPersonnel;
import modele.Client;
import modele.FabriqueProfil;
import modele.Personnel;
import modele.Profil;
import modele.ProfilUtilisateur;

public class ControlCreerProfil {
	
	private BDClient bdClient = BDClient.getInstance();
	private BDPersonnel bdPersonnel = BDPersonnel.getInstance();
	
	public void creerProfil(ProfilUtilisateur profilUtilisateur, String nom, String prenom, String mdp) {
		Profil profil = FabriqueProfil.creerProfil(profilUtilisateur, nom, prenom, mdp);
		if(profilUtilisateur.equals(ProfilUtilisateur.CLIENT)) {
			Client client = (Client) profil;
			bdClient.ajouterClient(client);
		} else {
			Personnel personnel = (Personnel) profil;
			bdPersonnel.ajouterPersonnel(personnel);
		}
	}

	public String visualiserBDUtilisateur() {
		StringBuilder retour = new StringBuilder();
		retour.append(bdPersonnel.toString());
		retour.append("\n");
		retour.append(bdClient.toString());
		return retour.toString();
	}
}
