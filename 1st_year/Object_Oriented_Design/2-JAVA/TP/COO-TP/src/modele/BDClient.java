package modele;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BDClient {
	
	private Map<Integer, Client> listeClient;
	
	private BDClient(){
		listeClient = new HashMap<>();
	}
	
	private static class BDClientHolder {
		private static final BDClient instance = new BDClient();
		
		
	}
	
	public void ajouterClient(Client client) {
		listeClient.put(listeClient.size()+1, client);
	}
	
	public static BDClient getInstance() {
		return BDClientHolder.instance;
	}

	@Override
	public String toString() {
		return "BDClient [listeClient=" + listeClient + "]";
	}

	public int connexionClient(String login, String mdp) {
		Collection<Client> clients = listeClient.values();
		int num = 1;
		for(Client c : clients) {
			if(c.verifierCorrespondanceProfil(login,mdp)) {
				c.connexionProfil();
				return num;
			}
			num++;
		}
		return 0;
		
	}

	public Client trouverClient(int numeroProfil) {
		if(listeClient.containsKey(numeroProfil)) {
			return listeClient.get(numeroProfil);
		}
		return null;
	}
}
