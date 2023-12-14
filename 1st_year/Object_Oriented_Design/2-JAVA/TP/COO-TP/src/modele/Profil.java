package modele;

public abstract class Profil {
	private String nom;
	private String prenom;
	private String login;
	private String mdp;
	private boolean connecte = false;
	
	
	protected Profil(String n, String p, String mdp) {
		this.nom = n;
		this.prenom = p;
		this.login = p + "." + n;
		this.mdp = mdp;
	}
	
	public boolean isConnecte() {
		return this.connecte;
	}

	@Override
	public String toString() {
		return "nom=" + nom + ", prenom=" + prenom + ", login=" + login + ", mdp=" + mdp + ", connecte="
				+ connecte;
	}
	
	public boolean verifierCorrespondanceProfil(String login, String mdp) {
		return this.login.equals(login) && this.mdp.equals(mdp);
	}
	
	public void connexionProfil() {
		this.connecte = true;
	}
	
	
}
