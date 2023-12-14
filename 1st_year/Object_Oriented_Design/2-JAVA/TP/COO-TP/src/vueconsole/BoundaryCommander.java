package vueconsole;

import java.util.List;

import controleur.ControlCommander;

public class BoundaryCommander {
	private BoundaryEnregistrerCoordonneesBancaires boundaryEnregistrerCoordonnesBancaires;
	private ControlCommander controlCommander;
	
	public BoundaryCommander(ControlCommander controlCommander, BoundaryEnregistrerCoordonneesBancaires boundaryEnregistrerCoordonnesBancaires) {
		this.boundaryEnregistrerCoordonnesBancaires = boundaryEnregistrerCoordonnesBancaires;
		this.controlCommander = controlCommander;
	}
	
	public void commander(int numClient) {
		boolean clientConnecte = this.controlCommander.verifierIdentification(numClient);
		if(clientConnecte) {
			int numeroHamburger = selectionneBurger();
			int numeroAccompagnement = selectionneAccompagnement();
			int numeroBoisson = selectionneBoisson();
			boolean carteRenseignee = this.controlCommander.verifierExistanceBancaire(numClient);
			if(!carteRenseignee) {
				carteRenseignee = this.boundaryEnregistrerCoordonnesBancaires.enregistrerCoordonneesBancaires(numClient);
			}
			if(carteRenseignee) {
				int numeroCommande = this.controlCommander.enregistrerCommande(numClient, numeroHamburger, numeroAccompagnement, numeroBoisson);
				System.out.println("Votre num�ro de commande est le " + numeroCommande);
			}
			
		
		}
	
	
	
	}

	private int selectionneBurger() {
		List<String> listeHamburger = this.controlCommander.getListHamburger();
		System.out.println("Veuillez selectionner le numero de votre hamburger");
		int chiffre = 1;
		for(String hamburger : listeHamburger) {
			System.out.println(chiffre + " : " + hamburger);
			chiffre++;
		}
		return Clavier.entrerClavierInt();
	}
	
	private int selectionneAccompagnement() {
		List<String> listeAccompagnement = this.controlCommander.getListAccompagnement();
		System.out.println("Veuillez selectionner le numero de votre accompagnement");
		int chiffre = 1;
		for(String accompagnement : listeAccompagnement) {
			System.out.println(chiffre + " : " + accompagnement);
			chiffre++;
		}
		return Clavier.entrerClavierInt();
	}
	
	private int selectionneBoisson() {
		List<String> listeBoisson = this.controlCommander.getListBoisson();
		System.out.println("Veuillez selectionner le numero de votre hamburger");
		int chiffre = 1;
		for(String boisson : listeBoisson) {
			System.out.println(chiffre + " : " + boisson);
			chiffre++;
		}
		return Clavier.entrerClavierInt();
	}
	
	
}
