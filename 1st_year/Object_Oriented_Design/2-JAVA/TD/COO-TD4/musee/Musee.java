package musee;

import equipement_romain.Equipement;
import villagegaulois.Gaulois;

public class Musee {

	private String nom;
	private GestionTrophee gestionnaireTrophee;

	public Musee(String nom, GestionTrophee gestionnaireTrophee) {
		this.nom = nom;
		this.gestionnaireTrophee = gestionnaireTrophee;
	}

	public String getNom() {
		return nom;
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
