package campromain;

import village.Personnage;

public class Romain extends Personnage{
	
	private static Romain empereur = new Romain("César");
	
	public Romain(String nom) {
		super(nom);
	}

	public static Romain getEmpereur() {
		return empereur;
	}
}
