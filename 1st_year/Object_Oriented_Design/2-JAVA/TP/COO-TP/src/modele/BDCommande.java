package modele;

import java.util.HashMap;
import java.util.Map;

public class BDCommande {
	
	private Map<Integer,Commande> mapCommandes;
	
	private BDCommande() {
		mapCommandes = new HashMap<>();
	}
	
	public static BDCommande getInstance() {
		return BDCommandeHolder.instance;
	}
	
	private static class BDCommandeHolder{
		private static final BDCommande instance = new BDCommande();
	}
	
	public int enregistrerCommande(int numClient, Hamburger hamburger, Accompagnement accompagnement, Boisson boisson) {
		Commande commande = new Commande(numClient,hamburger,accompagnement,boisson);	
		mapCommandes.put(commande.getNumeroCommandeAttribuee(), commande);
		return commande.getNumeroCommandeAttribuee();
		
		
	}
}
