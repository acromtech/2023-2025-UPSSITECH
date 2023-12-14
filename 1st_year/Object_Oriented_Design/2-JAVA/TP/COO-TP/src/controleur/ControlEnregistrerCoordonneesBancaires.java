package controleur;

import modele.BDClient;
import modele.Client;

public class ControlEnregistrerCoordonneesBancaires {
	private ControlVerifierCoordonneesBancaires controlVerifierCoordonneesBancaires;
	
	public ControlEnregistrerCoordonneesBancaires(ControlVerifierCoordonneesBancaires controlVerifierCoordonneesBancaires) {
		this.controlVerifierCoordonneesBancaires = controlVerifierCoordonneesBancaires;
	}
	
	public boolean enregistrerCoordonnesBancaires(int numClient, int numeroCarte, int dateExpCarte) {
		boolean carteValide = controlVerifierCoordonneesBancaires.verifierCoordonnesBancaires(numeroCarte, dateExpCarte);
		if(carteValide) {
			BDClient bdClient = BDClient.getInstance();
			Client client = bdClient.trouverClient(numClient);
			client.enregistrerCoordonnesBancaire(numeroCarte, dateExpCarte);
		}
		return carteValide;
	
	}
}
