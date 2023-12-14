package controleur;

import modele.BDClient;
import modele.BDPersonnel;
import modele.ProfilUtilisateur;

public class ControlSIdentifier {
	
	private BDClient bdClient = BDClient.getInstance();
	private BDPersonnel bdPersonnel = BDPersonnel.getInstance();
	
	public int sIdentifier(ProfilUtilisateur client, String login, String mdp) {
		int num = 0;
		if(client.equals(ProfilUtilisateur.CLIENT)) {
			num = bdClient.connexionClient(login,mdp);
		} else {
			num = bdPersonnel.connexionPersonnel(login,mdp);
		}
		
		return num;
	}

	public String visualiserBDUtilisateur() {
		StringBuilder retour = new StringBuilder();
		retour.append(bdPersonnel.toString());
		retour.append("\n");
		retour.append(bdClient.toString());
		return retour.toString();
	}
	
}
