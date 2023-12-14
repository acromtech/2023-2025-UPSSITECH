package bibliotheque;

import village.Personnage;

public class Parchemin {
	private String titre;
	private Personnage auteur;
	private Date date;

	public Parchemin(String titre, Personnage auteur, Date date) {
		super();
		this.titre = titre;
		this.auteur = auteur;
		this.date = date;
	}

	@Override
	public String toString() {
		return titre + ", " + auteur;
	}

	// TODO exo I Methode hashCode

	// TODO exo I Methode equals

	// TODO exo III Nouvelle methode equals sans prendre en compte la date
	// mettre la méthode equals de l'exo I en commentaire
	
	// TODO exo III Nouvelle methode hashCode sans prendre en compte la date
	// mettre la méthode hashCode de l'exo I en commentaire
}
