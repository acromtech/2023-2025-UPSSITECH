package modele;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class BDPersonnel {
	
	private Map<Integer,Personnel> listePersonnel;
	
	private BDPersonnel() {
		listePersonnel = new HashMap<>();
	}
	
	private static class BDPersonnelHolder{
		private static final BDPersonnel instance = new BDPersonnel();
		
	}
	
	public Map<Integer,Personnel> getListePersonnel(){
		return this.listePersonnel;
	}
	
	public void ajouterPersonnel(Personnel personnel) {
		listePersonnel.put(listePersonnel.size()+1,personnel);
		
	}
	
	public static BDPersonnel getInstance() {
		return BDPersonnelHolder.instance;
	}

	@Override
	public String toString() {
		return "BDPersonnel [listePersonnel=" + listePersonnel + "]";
	}

	public int connexionPersonnel(String login, String mdp) {
		for(Entry<Integer, Personnel> entrySetPersonnels : listePersonnel.entrySet()) {
			Integer numeroPersonnel = entrySetPersonnels.getKey();
			Personnel personnel = entrySetPersonnels.getValue();
			if(personnel.verifierCorrespondanceProfil(login, mdp)) {
				personnel.connexionProfil();
				return numeroPersonnel;
			}
			
		}
		return 0;
		
	}

	public Personnel trouverPersonnel(int numeroProfil) {
		if(listePersonnel.containsKey(numeroProfil)) {
			return listePersonnel.get(numeroProfil);
		}
		return null;
	}
	
	
}
