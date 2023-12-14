package modele;

public class CarteBancaire {
	private int numeroCarte;
	private int dateCarte;
	
	public CarteBancaire(int numeroCarte, int dateCarte) {
		this.numeroCarte = numeroCarte;
		this.dateCarte = dateCarte;
	}

	@Override
	public String toString() {
		return "CarteBancaire [numeroCarte=" + numeroCarte + ", dateCarte=" + dateCarte + "]";
	}
	
	
}
