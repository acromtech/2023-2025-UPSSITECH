package controleur;


public class ControlVerifierCoordonneesBancaires {
	public boolean verifierCoordonnesBancaires(int numeroCarte, int dateCarte) {
		boolean testeur = numeroCarte > 0;
		if(testeur) {
			testeur = ((dateCarte / 100) > 0 && (dateCarte/100 <= 12));
		}
		return testeur;
	}
}
