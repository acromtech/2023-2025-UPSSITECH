package vuegraphique;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controleur.ControlCommander;
import controleur.ControlEnregistrerCoordonneesBancaires;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameClient extends JFrame {
	// Les attributs metiers (ex : numClient)
	int numClient;
	// Declaration et creation des elements graphiques (JLabel)
	
	// Declaration et creation de la barre de menu (MenuBar)
	private PanCommander panCommander;
	MenuBar barreMenu = new MenuBar();
	// Declaration et creation des differents panels
	private JPanel panAccueil = new JPanel();
	JPanel panContents = new JPanel();
	PanModifierProfil panModifierProfil = new PanModifierProfil();
	PanHistorique panHistorique = new PanHistorique();
	// Declaration et creation du gestionnaire des cartes (CardLayout)
	CardLayout cartes = new CardLayout();
	/**
	 * 
	 */
	private static final long serialVersionUID = -4826579514369825665L;

	// Le constructeur
	public FrameClient (
			// parametres pour l'initialisation des attributs metiers
			int numClient,
			// parametres correspondants aux controleurs des cas utiliser par 
			// l'acteur en relation avec cette frame
			ControlCommander controlCommande,
			ControlEnregistrerCoordonneesBancaires controlEnregistrerCoordonneesBancaires
	) {
		// initialisation des attributs metiers
		this.numClient = numClient;
		// mise en forme de la frame (titre, dimension, ...)
		setTitle("BurgerResto");
		setSize(900,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// initialisation des differents panels : appel a leur methode d'initialisation
		PanEnregistrerCoordonneesBancaires panEnregistrerCoordonneesBancaires = new PanEnregistrerCoordonneesBancaires(controlEnregistrerCoordonneesBancaires);
		panCommander = new PanCommander(controlCommande, panEnregistrerCoordonneesBancaires);
		panCommander.initialisation();
		panModifierProfil.initialisation();
		panHistorique.initialisation();
		// ajout des pannels dans le ContentPane de la Frame
		panContents.setLayout(cartes);
		panContents.add(panCommander, "COMMANDER");
		panContents.add(panModifierProfil, "MODIFIER");
		panContents.add(panHistorique, "HISTORIQUE");
		getContentPane().add(panContents);
		// mise en page : mises en place des cartes
		initialisationAcceuil(); 
		// mise en place du menu 
		initialisationMenu();
		setMenuBar(barreMenu);
		// appel a la methode d'initialisation du menu
		// appel a la methode d'initialisation de la page d'accueil (optionnel)

		this.setVisible(true);
	}


	private void initialisationMenu() {
		 MenuItem commander = new MenuItem("Commander");
		 commander.addActionListener(new ActionListener() {	//clic de souris ou enfoncement de la touche Entrée
			 public void actionPerformed(ActionEvent event) {
				 panCommander.commander(numClient);
				 cartes.show(panContents, "COMMANDER"); //demande au layout cartes de montrer la carte contenant le panel ʺCOMMANDERʺ
			 }
		 }); 
		 MenuItem modifier = new MenuItem("Modifier");
		 modifier.addActionListener(new ActionListener() { //clic de souris ou enfoncement de la touche Entrée
			 public void actionPerformed(ActionEvent event) {
				 cartes.show(panContents, "MODIFIER");
			 }
		 }); 
		 MenuItem historique = new MenuItem("Historique");
		 historique.addActionListener(new ActionListener() { //clic de souris ou enfoncement de la touche Entrée
			 public void actionPerformed(ActionEvent event) {
			 cartes.show(panContents, "HISTORIQUE");
			 }
		 }); 
		 Menu menuMonCompte = new Menu("Mon compte ");
		 menuMonCompte.add(commander);
		 menuMonCompte.add(modifier);
		 menuMonCompte.add(historique);
		 Menu menuDeconnexion = new Menu("Deconnexion");
		 barreMenu.add(menuMonCompte);
		 barreMenu.add(menuDeconnexion);
	}

	private void initialisationAcceuil(){
		 panAccueil.setBackground(Color.ORANGE);
		 JLabel texteAccueil = new JLabel("Bienvenu à Burger Resto");
		 texteAccueil.setFont(new Font("Calibri", Font.BOLD, 24));
		 panAccueil.add(texteAccueil);
		 panAccueil.setVisible(true);
		 panContents.add(panAccueil, "ECRAN_ACCUEIL");
		 cartes.show(panContents, "ECRAN_ACCUEIL");
		}

}