package vueconsole;

import controleur.ControlCreerProfil;
import modele.ProfilUtilisateur;
import java.util.logging.*;

public class BoundaryCreerProfilClient {
	
	private ControlCreerProfil controlcreerprofil;
	
	public BoundaryCreerProfilClient(ControlCreerProfil controlCreerProfil) {
		this.controlcreerprofil = controlCreerProfil;
	}
	
	
	public void creerProfilClient() {
		Logger logger = Logger.getAnonymousLogger();
		logger.info("Veuillez entrer votre nom");
		String nom = Clavier.entrerClavierString();
		logger.info("Veuillez entrer votre prenom");
		String prenom = Clavier.entrerClavierString();
		logger.info("Veuillez entrer votre mot de passe");
		String mdp =  Clavier.entrerClavierString();
		controlcreerprofil.creerProfil(ProfilUtilisateur.PERSONNEL,nom,prenom,mdp);
		
	}

}
