package campromain;

import village.Personnage;

public class Romain extends Personnage{
	
	private static Romain empereur = new Romain("C�sar");
	
	public Romain(String nom) {
		super(nom);
	}

	public static Romain getEmpereur() {
		return empereur;
	}
}
