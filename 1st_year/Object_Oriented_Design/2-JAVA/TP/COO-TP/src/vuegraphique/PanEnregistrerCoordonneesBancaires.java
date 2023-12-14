package vuegraphique;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.JButton;

import controleur.ControlEnregistrerCoordonneesBancaires;

public class PanEnregistrerCoordonneesBancaires {
	// controleurs du cas + panel des cas inclus ou etendus en lien avec un acteur
	ControlEnregistrerCoordonneesBancaires controlEnregistrerCoordonneesBancaires;
	
	// les attributs metiers (ex : numClient)
	private int numClient; 
	
	// Les elements graphiques :
	
	// Declaration et creation des polices d'ecritures
	Font policeTitre = new Font("Calibri", Font.BOLD, 24);
	Font policeParagraphe = new Font( "Calibri", Font.HANGING_BASELINE, 16);
	
	// Declaration et creation des ComboBox
	// Declaration et creation des Button
	// Declaration et creation des TextArea
	// Declaration et creation des Labels

	// Mise en page : les Box
	private Box boxMiseEnPageCoordonneesBancaires = Box.createVerticalBox();
	private Box boxNumeroCarte = Box.createHorizontalBox();
	private Box boxValiditeCarte = Box.createHorizontalBox();
	private Box boxValiderCarte = Box.createHorizontalBox();


	public PanEnregistrerCoordonneesBancaires (
			// parametres pour l'initialisation des attributs metiers 
			// parametres correspondants au controleur du cas + panels des cas inclus ou etendus en lien avec un acteur
			ControlEnregistrerCoordonneesBancaires controlEnregistrerCoordonneesBancaires
		) {
		// initialisation des attributs metiers 
		// initilaisation du controleur du cas + panels 
		 this.controlEnregistrerCoordonneesBancaires =  controlEnregistrerCoordonneesBancaires;
		// des cas inclus ou etendus en lien avec un acteur
	}

	//Methode d'initialisation du panel
	public void initialisation() {
		// mise en forme du panel (couleur, ...)
		//setBackground(Color.yellow);
		
		// creation des differents elements graphiques (JLabel, Combobox, Button, TextAera ...)
		JLabel texteCoordonnerBancaire = new JLabel("Entrer vos coordonnées bancaires");
		texteCoordonnerBancaire.setFont(policeTitre);
		boxMiseEnPageCoordonneesBancaires.add(texteCoordonnerBancaire);
		JLabel texteNumeroCarteBancaire = new JLabel("Entrer le numéro de votre carte bancaire");
		texteNumeroCarteBancaire.setFont(policeParagraphe);
		boxNumeroCarte.add(texteNumeroCarteBancaire);
		JLabel texteValiditeCarte = new JLabel("Entrer la date d’expiration de votre carte bancaire");
		texteValiditeCarte.setFont(policeParagraphe);
		boxValiditeCarte.add(texteValiditeCarte);
		
		JButton validationCoordonneeBancaire = new JButton();
			 validationCoordonneeBancaire.setText("Valider");
			 validationCoordonneeBancaire.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 System.out.println("OK");
			 }
		 }); 
			 
		// mise en page : placements des differents elements graphiques dans des Box
		??? AJOUTER LES DIFFERENTS ELEMENTS GRAPHIQUE ??? (HAUT DE LA PAGE 16)
		// mise en page : placements des differentes box dans une box principale
		
		// mise en page : ajout de la box principale dans le panel
	}

	// Methode correspondante au nom du cas
	public void enregistrerCoordonneesBancaires( /*parametres metiers*/ ) {
	}

	// Methodes privees pour le bon deroulement du cas
}
