package gaule;

import campromain.CampRomain;
import campromain.Centurie;
import campromain.GradeRomain;
import campromain.Legion;
import campromain.Soldat;
import villagegaulois.Gaulois;
import villagegaulois.VillageGaulois;

public class Armoricae {
	VillageGaulois villageGaulois = new VillageGaulois("village des irréductibles Gaulois", new Gaulois("Abraracourcix"));
	CampRomain[] campsRomains = new CampRomain[4];
	int nombreCampsRomains = 0;
	public Armoricae() {
		Soldat alavacomgetepus = new Soldat("Alavacomgetepus", GradeRomain.PREFET);
		Soldat aerobus = new Soldat("Aérobus", GradeRomain.LEGAT);
		Soldat oursenplus = new Soldat("Oursenplus", GradeRomain.CENTURION);
		Soldat mordicus = new Soldat("Mordicus", GradeRomain.CENTURION);
		Soldat cornedurus = new Soldat("Cornedurus", GradeRomain.LEGIONNAIRE);
		Soldat deprus = new Soldat("Deprus", GradeRomain.LEGIONNAIRE);
		Soldat montladsus = new Soldat("Montladsus", GradeRomain.LEGIONNAIRE);
		Soldat savancosinus = new Soldat("Savancosinus",GradeRomain.LEGIONNAIRE);
		Soldat humerus = new Soldat("Humérus", GradeRomain.LEGIONNAIRE);
		
		//TODO exercice II.3
		
		//
		
		aquarium.ajouterLegion(legion);
		
		//TODO exercice II.6
		
	}
	
	public String afficherCampsRomains(){
		String chaine = "Camps romains en Armoricae\n";
		for (int i = 0; i < nombreCampsRomains; i++) {
			chaine += campsRomains[i] + "\n\n";
		}
		return chaine;
	}
}
