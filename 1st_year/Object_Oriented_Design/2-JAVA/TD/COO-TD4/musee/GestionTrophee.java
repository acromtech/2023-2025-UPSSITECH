package musee;

import equipement_romain.Equipement;
import villagegaulois.Gaulois;

public interface GestionTrophee {
	String tousLesTrophees();
	String lesTrophees(Gaulois proprietaire);
	void ajouterTrophee(Gaulois proprietaire, Equipement trophee);
}
