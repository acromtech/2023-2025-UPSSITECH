package vueconsole;

import controleur.ControlAjouterAlimentMenu;
import modele.AlimentMenu;
import modele.ProfilUtilisateur;

public class BoundaryAjouterAlimentMenu {
	private ControlAjouterAlimentMenu ctrlAjouterAlimentMenu;
	
	public BoundaryAjouterAlimentMenu(ControlAjouterAlimentMenu controlAjouterAlimentMenu) {
		this.ctrlAjouterAlimentMenu = controlAjouterAlimentMenu;
	}

	public void ajouterAlimentMenu(int numProfil) {
		if(ctrlAjouterAlimentMenu.verifierIdentification(ProfilUtilisateur.GERANT, numProfil)) {
			System.out.println("Entrer le numéro du type d'aliment que vous souhaitez ajouter");
			int choix = 0;
			while(choix != 1 && choix != 2 && choix != 3) {
				System.out.println("1 ajouter un hamburger");
				System.out.println("2 ajouter un accompagnement");
				System.out.println("3 ajouter une boisson");
				choix = Clavier.entrerClavierInt();
				if(choix != 1 && choix !=2 && choix !=3) {
					System.out.println("Veuillez entrer 1, 2 ou 3");
				}
			}
			System.out.println("Veuillez entrer le nom de l'aliment");
			String nomAliment = Clavier.entrerClavierString();
			switch(choix) {
			case 1:
				ctrlAjouterAlimentMenu.ajouterAliment(AlimentMenu.HAMBURGER, nomAliment);
				break;
			case 2:
				ctrlAjouterAlimentMenu.ajouterAliment(AlimentMenu.ACCOMPAGNEMENT, nomAliment);
				break;
			case 3:
				ctrlAjouterAlimentMenu.ajouterAliment(AlimentMenu.BOISSON, nomAliment);
				break;
			default :
				System.out.println("Type d'aliment non reconnu");
				break;
			}
			
		
		}
	}
}
