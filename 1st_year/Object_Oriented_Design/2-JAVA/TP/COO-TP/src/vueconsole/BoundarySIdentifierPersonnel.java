package vueconsole;

import java.util.logging.Logger;

import controleur.ControlSIdentifier;
import modele.ProfilUtilisateur;

public class BoundarySIdentifierPersonnel {
private ControlSIdentifier controlSIdentifier;
	
	public BoundarySIdentifierPersonnel(ControlSIdentifier controlSIdentifier2) {
		this.controlSIdentifier = controlSIdentifier2;
	}

	public int identifierPersonnel() {
		Logger logger = Logger.getAnonymousLogger();
		logger.info("Veuillez entrer votre login");
		String login = Clavier.entrerClavierString();
		logger.info("Veuillez entrer votre mot de passe");
		String mdp = Clavier.entrerClavierString();
		
		return controlSIdentifier.sIdentifier(ProfilUtilisateur.PERSONNEL,login,mdp);
	}
}
