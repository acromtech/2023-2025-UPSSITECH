package vuegraphique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controleur.ControlCommander;

public class PanCommander extends JPanel {
	// controleurs du cas + panel des cas inclus ou etendus en lien avec un acteur
	ControlCommander controlCommande;
	PanEnregistrerCoordonneesBancaires panEnregistrerCoordonneesBancaires;
	
	// les attributs metiers (ex : numClient)
	int numeroClient;
	int numeroHamburger;
	int numeroAccompagnement;
	int numeroBoisson;
	
	// Les elements graphiques :
	
	// Declaration et creation des polices d'ecritures
	Font policeTitre = new Font("Calibri", Font.BOLD, 24);
	Font policeParagraphe = new Font( "Calibri", Font.HANGING_BASELINE, 16);
	
	// Declaration et creation des ComboBox
	private JComboBox<String> comboBoxHamburger = new JComboBox<>();
	private JComboBox<String> comboBoxAccompagnement = new JComboBox<>();
	private JComboBox<String> comboBoxBoisson = new JComboBox<>();
	
	// Declaration et creation des Button
	private	JButton validerCommande = new JButton();
	Box boxValiderChoix = Box.createHorizontalBox();
	// Declaration et creation des TextArea
	
	// Declaration et creation des Labels

	// Mise en page : les Box
	Box boxMiseEnPageCommande = Box.createVerticalBox();
	Box boxChoixHamburger = Box.createHorizontalBox();
	Box boxChoixAccompagnement = Box.createHorizontalBox();
	Box boxChoixBoisson = Box.createHorizontalBox();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5100344924935036107L;

	public PanCommander (
		// parametres pour l'initialisation des attributs metiers
		// parametres correspondants au controleur du cas + panels
		// des cas inclus ou etendus en lien avec un acteur
		ControlCommander controlCommande, PanEnregistrerCoordonneesBancaires panEnregistrerCoordonneesBancaires) {
	 	// initialisation des attributs metiers
		 this.numeroHamburger = 0;
		 this.numeroAccompagnement = 0;
		 this.numeroBoisson = 0;
	 	// initilaisation du controleur du cas + panels
		
	 	// des cas inclus ou etendus en lien avec un acteur
	 	this.controlCommande = controlCommande;
	 	this.panEnregistrerCoordonneesBancaires = panEnregistrerCoordonneesBancaires; 
	}

	//Methode d'initialisation du panel
	public void initialisation() {
		// mise en forme du panel (couleur, ...)
		setBackground(Color.yellow);
		// creation des differents elements graphiques (JLabel, Combobox, Button, TextAera ...)
		JLabel texteCommander = new JLabel("Votre menu");
		texteCommander.setFont(policeTitre);
		JLabel texteHamburger = new JLabel("Choisissez votre hambuger");
		texteHamburger.setFont(policeParagraphe);
		JLabel texteAccompagnement = new JLabel("Choisissez votre accompagnement");
		texteAccompagnement.setFont(policeParagraphe);
		JLabel texteBoisson = new JLabel("Choisissez votre boisson");
		texteBoisson.setFont(policeParagraphe);
		comboBoxHamburger.addActionListener(new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 numeroHamburger = comboBoxHamburger.getSelectedIndex();
			 }
		}); 
		
		validerCommande.setText("Valider");
		validerCommande.setText("Valider");
		validerCommande.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 if ( numeroHamburger != 0 && numeroAccompagnement != 0 && numeroBoisson != 0) {
					 System.out.println("OK");;
				 }
			 }
		 });
		
		// mise en page : placements des differents elements graphiques dans des Box
		boxMiseEnPageCommande.add(texteCommander);
		
		boxMiseEnPageCommande.add(Box.createRigidArea(new Dimension(0, 30))); 
		
		boxChoixHamburger.add(texteHamburger);
		boxChoixHamburger.add(Box.createRigidArea(new Dimension(10, 0))); 
		boxChoixHamburger.add(comboBoxHamburger);
		
		boxMiseEnPageCommande.add(Box.createRigidArea(new Dimension(0, 30))); 
		
		boxChoixAccompagnement.add(texteAccompagnement);
		boxChoixAccompagnement.add(Box.createRigidArea(new Dimension(10, 0))); 
		boxChoixAccompagnement.add(comboBoxAccompagnement);
		
		boxMiseEnPageCommande.add(Box.createRigidArea(new Dimension(0, 30))); 
		
		boxChoixBoisson.add(texteBoisson);
		boxChoixBoisson.add(Box.createRigidArea(new Dimension(10, 0))); 
		boxChoixBoisson.add(comboBoxBoisson);
		
		boxValiderChoix.add(validerCommande);
		
		// mise en page : placements des differentes box dans une box principale
		boxMiseEnPageCommande.add(boxChoixHamburger);
		boxMiseEnPageCommande.add(boxChoixAccompagnement);
		boxMiseEnPageCommande.add(boxChoixBoisson);
		boxMiseEnPageCommande.add(boxValiderChoix);
		
		// mise en page : ajout de la box principale dans le panel
		this.add(boxMiseEnPageCommande);
	}

	// Methode correspondante au nom du cas
	public void commander(int numClient) {
		// Initialise l’attribut numeroClient avec le paramètre numClient,
		this.numeroClient=numClient;
		// Implémenter la vérification de l’identification grâce à son contrôleur controlCommande, 
		// Si le client est bien identifié alors appelle la méthode privée affichageMenu.
		if(this.controlCommande.verifierIdentification(numClient)) affichageMenu();
	}

	// Methodes privees pour le bon deroulement du cas
	private void affichageMenu() {
		List<String> listeHamburger = controlCommande.getListHamburger();
		List<String> listeAccompagnement = controlCommande.getListAccompagnement();
		List<String> listeBoisson = controlCommande.getListBoisson();
		comboBoxHamburger.removeAllItems();
		comboBoxHamburger.addItem("");
		for(int i=0;i<listeHamburger.size();i++) comboBoxHamburger.addItem(listeHamburger.get(i));
		comboBoxAccompagnement.removeAllItems();
		comboBoxAccompagnement.addItem("");
		for(int i=0;i<listeAccompagnement.size();i++) comboBoxAccompagnement.addItem(listeAccompagnement.get(i));
		comboBoxBoisson.removeAllItems();
		comboBoxBoisson.addItem("");
		for(int i=0;i<listeBoisson.size();i++) comboBoxBoisson.addItem(listeBoisson.get(i));
		 
	}
}
