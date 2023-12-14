package modele;

public class Client extends Profil{
	
	private CarteBancaire carteBancaire;
	
	public Client(String n, String p, String mdp) {
		super(n, p, mdp);
	}

	@Override
	public String toString() {
		return "Client [" + super.toString() + ", " + this.carteBancaire.toString()+"]";
	}

	public void enregistrerCoordonnesBancaire(int numeroCarte, int dateExpCarte) {
		this.carteBancaire = new CarteBancaire(numeroCarte,dateExpCarte);
		
	}

	public boolean verifierExistanceCarteBancaire() {
		return this.carteBancaire != null;
	}

	
	

}
