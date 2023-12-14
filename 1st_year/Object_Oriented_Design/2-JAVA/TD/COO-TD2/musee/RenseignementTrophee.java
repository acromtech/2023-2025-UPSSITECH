package musee;

import equipementromain.Equipement;
import villagegaulois.Gaulois;

public class RenseignementTrophee {
	private Gaulois proprietaire;
	private Equipement typeTrophee;

	public RenseignementTrophee(Gaulois proprietaire, Equipement typeTrophee) {
		this.proprietaire = proprietaire;
		this.typeTrophee = typeTrophee;
	}

	public Gaulois getProprietaire() {
		return proprietaire;
	}

	public Equipement getTypeTrophee() {
		return typeTrophee;
	}
}
