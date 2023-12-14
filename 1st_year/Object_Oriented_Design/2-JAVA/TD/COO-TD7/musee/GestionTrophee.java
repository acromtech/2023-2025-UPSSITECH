package musee;

import campromain.Equipement;
import villagegaulois.Gaulois;

public interface GestionTrophee {
	String tousLesTrophees();

	String lesTrophees(Gaulois proprietaire);

	void ajouterTrophee(Gaulois proprietaire, Equipement trophee);

	String donnerGauloisDonateur();

	String donnerTrophees();

	String donnerInventaire();

}
