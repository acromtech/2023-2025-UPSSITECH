package protocontrol;

import java.util.ArrayList;
import java.util.List;

public class ProtoControlCommander {
	int numeroCommande = 0;

	public boolean verifierIdentification(int numClient) {
		return true;
	}

	public List<String> getListHamburger() {
		List<String> listeHamburger = new ArrayList<>();
		listeHamburger.add("baconBurger");
		listeHamburger.add("chickenBurger");
		listeHamburger.add("cheeseBurger");
		return listeHamburger;
	}

	public List<String> getListBoisson() {
		List<String> listeBoisson = new ArrayList<>();
		listeBoisson.add("coca");
		listeBoisson.add("orangeBulles");
		return listeBoisson;
	}

	public List<String> getListAccompagnement() {
		List<String> listeAccompagnement = new ArrayList<>();
		listeAccompagnement.add("frites");
		listeAccompagnement.add("pommesChips");
		return listeAccompagnement;
	}

	public boolean isCarteRenseignee(int numClient) {
		return true;
	}

	public int enregistrerCommande(int numClient, int numeroHamburger, int numeroAccompagnement, int numeroBoisson) {
		numeroCommande++;
		return numeroCommande;
	}

}
