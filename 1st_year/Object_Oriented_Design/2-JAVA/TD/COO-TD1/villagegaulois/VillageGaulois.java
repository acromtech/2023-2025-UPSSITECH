package villagegaulois;

import village.Village;

public class VillageGaulois extends Village{

	private Gaulois chef;
	
	public VillageGaulois(String nom, Gaulois chef) {
		super(nom);
		this.chef = chef;
	}
	
	public Gaulois getChef() {
		return chef;
	}

}
