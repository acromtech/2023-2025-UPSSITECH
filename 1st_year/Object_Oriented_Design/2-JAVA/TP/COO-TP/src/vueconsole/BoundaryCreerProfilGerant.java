package vueconsole;

import java.util.logging.Logger;

import controleur.ControlCreerProfil;
import modele.ProfilUtilisateur;

public class BoundaryCreerProfilGerant {
	
	private ControlCreerProfil controlcreerprofil;
	
	public BoundaryCreerProfilGerant(ControlCreerProfil controlCreerProfil2) {
		this.controlcreerprofil = controlCreerProfil2;
	}

	public void creerProfilGerant() {
		Logger logger = Logger.getAnonymousLogger();
		logger.info("Veuillez entrer votre nom");
		String nom = Clavier.entrerClavierString();
		logger.info("Veuillez entrer votre prenom");
		String prenom = Clavier.entrerClavierString();
		logger.info("Veuillez entrer votre mot de passe");
		String mdp =  Clavier.entrerClavierString();
		controlcreerprofil.creerProfil(ProfilUtilisateur.GERANT,nom,prenom,mdp);
		
	}
}
