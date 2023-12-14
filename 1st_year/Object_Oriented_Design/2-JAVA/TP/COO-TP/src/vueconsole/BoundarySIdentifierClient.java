package vueconsole;

import java.util.logging.Logger;

import controleur.ControlSIdentifier;
import modele.ProfilUtilisateur;

public class BoundarySIdentifierClient {
	
	private ControlSIdentifier controlSIdentifier;
	
	public BoundarySIdentifierClient(ControlSIdentifier controlSIdentifier2) {
		this.controlSIdentifier = controlSIdentifier2;
	}

	public int sIdentifierClient() {
		Logger logger = Logger.getAnonymousLogger();
		logger.info("Veuillez entrer votre login");
		String login = Clavier.entrerClavierString();
		logger.info("Veuillez entrer votre mot de passe");
		String mdp = Clavier.entrerClavierString();
		
		return controlSIdentifier.sIdentifier(ProfilUtilisateur.CLIENT,login,mdp);
	}
}
