package campromain;

public class Legion {
	//Partie 1
	private Soldat legat;
	private Centurie[] centuries = new Centurie[6];
	private int nombreCenturies = 0;

	public Legion(Soldat legat) {
		this.legat = legat;
	}

	//Partie 2
	public String toString() {
		String chaine = "\n- La légion dirigée par " + this.legat;
		if (nombreCenturies != 0) {
			chaine += "\n  Les centuries sous ses ordres sont : ";
			for (int i = 0; i < nombreCenturies; i++) {
				chaine += "\n" + centuries[i];
			}
		}
		chaine += "\n";
		return chaine;
	}

	//TODO exercice II.4
	
}