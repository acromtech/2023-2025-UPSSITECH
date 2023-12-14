package campromain;

public class Centurie {
	private Soldat centurion;
	private Soldat[] soldats = new Soldat[100];
	private int nombreSoldats = 0;

	public Centurie(Soldat centurion) {
		this.centurion = centurion;
	}

	public String toString() {
		String chaine = "  * La centurie dirigée par " + this.centurion;
		if (nombreSoldats != 0) {
			chaine += "\n    Les soldats sous ses ordres sont : ";
			for (int i = 0; i < nombreSoldats; i++) {
				chaine += "\n    . " + soldats[i];
			}
		}
		chaine += "\n";
		return chaine;
	}

	//TODO exercice II.5
	
}
