package musee;

import campromain.Equipement;
import villagegaulois.Gaulois;

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

	public String donnerGauloisDonateur() {
		return gestionnaireTrophee.donnerGauloisDonateur();
	}

	public String donnerTrophees() {
		return gestionnaireTrophee.donnerTrophees();
	}

	public String donnerInventaire() {
		return gestionnaireTrophee.donnerInventaire();
	}
}
