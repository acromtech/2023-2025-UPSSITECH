package festin;

import villagegaulois.Gaulois;

public class LanceMenhir implements ActivitePayante {
	private int tarif;
	private int distanceMax = 0;
	private Gaulois champion;

	@Override	
	public void setTarif(int tarif) {
		this.tarif = tarif;
	}
	

	@Override
	public int getTarif() throws TarifNonInitialiserException {
		if(tarif != 0){
		return tarif;
		} else throw new TarifNonInitialiserException();
	}

	public void lancer(Gaulois gaulois, int distance){
		System.out.println(gaulois.getNom() + " a lanc� son menhir a plus de " + distance + " pieds");
		if (distance > distanceMax){
			distanceMax = distance;
			System.out.println("Il d�tr�ne " + champion.getNom() + " est devient notre champion");
			champion = gaulois;
		}
	}
}
