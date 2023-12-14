package src;
import java.util.Vector;

public abstract interface Joueur {
	public Commande getCommandeC();
	public Statut getStatut();
	public void addNavire(Navire nav);
	public Vector<Navire>getListeNavire();
	public int getId();
}
