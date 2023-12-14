package musee;

import equipementromain.Equipement;
import villagegaulois.Gaulois;

//TODO 2.b Reprendre la classe "Musee" afin qu'elle implémente l'interface ActivitePayante
public class Musee {
	private String nom;
	private int tarif;
	private GestionTrophee gestionnaireTrophee;

	public Musee(String nom, GestionTrophee gestionnaireTrophee) {
		this.nom = nom;
		this.gestionnaireTrophee = gestionnaireTrophee;
	}

	public String getNom() {
		return nom;
	}


	//TODO 2.e lever l'exception personnalisée si le tarif de l'activité est nul
	public int getTarif() {
		return tarif;
	}

	public void setTarif(int tarif) {
		this.tarif = tarif;
	}

	public void ajouterTrophee(Gaulois proprietaire, Equipement trophee) {
		gestionnaireTrophee.ajouterTrophee(proprietaire, trophee);
	}

	public String tousLesTrophees() {
		return gestionnaireTrophee.tousLesTrophees();
	}

	public String lesTrophees(Gaulois proprietaire) {
		return gestionnaireTrophee.lesTrophees(proprietaire);
	}
}
