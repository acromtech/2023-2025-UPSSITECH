package controleur;

import java.util.ArrayList;
import java.util.List;

import modele.Accompagnement;
import modele.BDClient;
import modele.BDCommande;
import modele.Boisson;
import modele.Client;
import modele.Hamburger;
import modele.Menu;
import modele.ProfilUtilisateur;

public class ControlCommander {
	
	private BDClient bdClient;
	private Menu menu;
	private ControlVerifierIdentification controlVerifierIdentification;
	private BDCommande bdCommande;
	
	public ControlCommander(ControlVerifierIdentification controlVerifierIdentification) {
		this.controlVerifierIdentification = controlVerifierIdentification;
		this.menu = Menu.getInstance();
		this.bdClient = BDClient.getInstance();
		this.bdCommande = BDCommande.getInstance();
	}
	
	public boolean verifierIdentification(int numClient) {
		return this.controlVerifierIdentification.verifierIdentification(ProfilUtilisateur.CLIENT, numClient);
	}

	public List<String> getListHamburger() {
		List<Hamburger> listeHamburger = this.menu.getListHamburger();
		List<String> listeHamburgerNoms = new ArrayList<>();
		for(Hamburger hamburger : listeHamburger) {
			listeHamburgerNoms.add(hamburger.getNom());
		}
		return listeHamburgerNoms;
	}

	public List<String> getListAccompagnement() {
		List<Accompagnement> listeAccompagnement = this.menu.getListAccompagnement();
		List<String> listeAccompagnementNoms = new ArrayList<>();
		for(Accompagnement accompagnement : listeAccompagnement) {
			listeAccompagnementNoms.add(accompagnement.getNom());
		}
		return listeAccompagnementNoms;
	}

	public List<String> getListBoisson() {
		List<Boisson> listeBoisson = this.menu.getListBoisson();
		List<String> listeBoissonNoms = new ArrayList<>();
		for(Boisson boisson : listeBoisson) {
			listeBoissonNoms.add(boisson.getNom());
		}
		return listeBoissonNoms;
	}

	public boolean verifierExistanceBancaire(int numClient) {
		Client client = this.bdClient.trouverClient(numClient);
		return client.verifierExistanceCarteBancaire();
	}

	public int enregistrerCommande(int numClient, int numeroHamburger, int numeroAccompagnement, int numeroBoisson) {
		Hamburger hamburger = menu.choixHamburger(numeroHamburger);
		Accompagnement accompagnement = menu.choixAccompagnement(numeroAccompagnement);
		Boisson boisson = menu.choixBoisson(numeroBoisson);
		return this.bdCommande.enregistrerCommande(numClient, hamburger, accompagnement, boisson);
	}
}
