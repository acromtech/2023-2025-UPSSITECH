package modele;

public class Commande {
	private int numClient;
	private Hamburger hamburger;
	private Accompagnement accompagnement;
	private Boisson boisson;
	private int numeroCommandeAttribuee;
	private static int numeroCommande = 0;


	public Commande(int numClient, Hamburger hamburger, Accompagnement accompagnement , Boisson boisson) {
		this.numClient = numClient;
		this.hamburger = hamburger;
		this.accompagnement = accompagnement;
		this.boisson = boisson;
		numeroCommande++;
		this.numeroCommandeAttribuee = numeroCommande;
	}

	public int getNumClient() {
		return numClient;
	}

	public Hamburger getHamburger() {
		return hamburger;
	}

	public Accompagnement getAccompagnement() {
		return accompagnement;
	}


	public Boisson getBoisson() {
		return boisson;
	}


	public int getNumeroCommandeAttribuee() {
		return this.numeroCommandeAttribuee;
	}
	
	public static void initialiseNumeroCommande(){
    	numeroCommande = 0;
    }
}
