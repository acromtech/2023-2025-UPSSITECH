package testgraphique;

import protocontrol.ProtoControlCommander;
import protocontrol.ProtoControlEnregistrerCoordonneesBancaires;
import vuegraphique.FrameClient;

public class ProtoTestEcranClient {

	public static void main(String[] args) {
	
		ProtoControlEnregistrerCoordonneesBancaires controlEnregistrerCoordonneesBancaires = new ProtoControlEnregistrerCoordonneesBancaires();
		ProtoControlCommander controlCommande = new ProtoControlCommander();
		new FrameClient(1, controlCommande,
				controlEnregistrerCoordonneesBancaires);
		new FrameClient(2, controlCommande,
				controlEnregistrerCoordonneesBancaires);
	}
}
