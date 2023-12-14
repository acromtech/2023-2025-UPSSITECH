package modele;

public class Personnel extends Profil{
	
	private boolean gerant = false;
	
	public Personnel(String n, String p, String mdp) {
		super(n, p, mdp);
	}
	
	public void definirGerant() {
		this.gerant = true;
	}

	@Override
	public String toString() {
		return "Personnel [geran=" + gerant + ", " + super.toString();
	}

	public boolean isGerant() {
		return gerant;
	}
	
	
	
}
