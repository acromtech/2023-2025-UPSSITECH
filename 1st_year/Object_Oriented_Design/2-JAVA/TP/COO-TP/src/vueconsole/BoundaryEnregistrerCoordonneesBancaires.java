package vueconsole;

import controleur.ControlEnregistrerCoordonneesBancaires;

public class BoundaryEnregistrerCoordonneesBancaires {
	private ControlEnregistrerCoordonneesBancaires controlEnregistrerCoordonnesBancaires;
	
	public BoundaryEnregistrerCoordonneesBancaires(ControlEnregistrerCoordonneesBancaires controlEnregistrerCoordonnesBancaires ) {
		this.controlEnregistrerCoordonnesBancaires = controlEnregistrerCoordonnesBancaires;
	}
	
	public boolean enregistrerCoordonneesBancaires(int numeroClient) {
		System.out.println("Veuillez saisir votre numero de carte bancaire");
		int numeroCarte = Clavier.entrerClavierInt();
		System.out.println("Veuillez saisir la date d'expiration de votre carte bancaire (MMAA)");
		int dateExpCarte = Clavier.entrerClavierInt();
		
		boolean retour = this.controlEnregistrerCoordonnesBancaires.enregistrerCoordonnesBancaires(numeroClient,numeroCarte,dateExpCarte);
		if(!retour) {
			System.out.println("Votre carte n'est pas valide, votre commande ne peut aboutir");
		}
		return retour;
		
	}
}
