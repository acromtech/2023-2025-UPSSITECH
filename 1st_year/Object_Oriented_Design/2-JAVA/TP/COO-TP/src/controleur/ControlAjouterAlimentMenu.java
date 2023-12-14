package controleur;

import modele.Accompagnement;
import modele.AlimentMenu;
import modele.Boisson;
import modele.FabriqueAliment;
import modele.Hamburger;
import modele.Menu;
import modele.ProfilUtilisateur;

public class ControlAjouterAlimentMenu {
	private Menu menu;
	private ControlVerifierIdentification controlVerifierIdentification;
	
	public ControlAjouterAlimentMenu(ControlVerifierIdentification controlVerifierIdentification) {
		this.controlVerifierIdentification = controlVerifierIdentification;
		this.menu = Menu.getInstance();
	}

	public boolean verifierIdentification(ProfilUtilisateur profilUtilisateur, int numProfil) {
		return controlVerifierIdentification.verifierIdentification(profilUtilisateur, numProfil);
	}

	public void ajouterAliment(AlimentMenu typeAliment, String nomAliment) {
		switch(typeAliment){
		case HAMBURGER:
			Hamburger hamburger = (Hamburger) FabriqueAliment.creerAliment(typeAliment, nomAliment);
			menu.ajouterAliment(hamburger);
			break;
		case ACCOMPAGNEMENT:
			Accompagnement accompagnement = (Accompagnement) FabriqueAliment.creerAliment(typeAliment, nomAliment);
			menu.ajouterAliment(accompagnement);
			break;
		case BOISSON:
			Boisson boisson = (Boisson) FabriqueAliment.creerAliment(typeAliment, nomAliment);
			menu.ajouterAliment(boisson);
			break;
		}
	}

	public String visualiserMenu() {
		return this.menu.toString();
	}
}
