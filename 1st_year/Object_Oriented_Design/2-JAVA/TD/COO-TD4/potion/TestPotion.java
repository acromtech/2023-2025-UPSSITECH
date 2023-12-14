package potion;

public class TestPotion {
	public static void main(String[] args) {
		Ingredient gui = new Ingredient("gui", Necessite.INDISPENSABLE);
		Ingredient carottes = new Ingredient("carottes", Necessite.INDISPENSABLE);
		Ingredient sel = new Ingredient("sel", Necessite.INDISPENSABLE);
		Ingredient trefle = new Ingredient("trèfle à quatre feuilles ", Necessite.INDISPENSABLE);
		Ingredient poisson = new Ingredient("poisson", Necessite.INDISPENSABLE);
		Ingredient miel = new Ingredient("miel", Necessite.INDISPENSABLE);
		Ingredient hydromel = new Ingredient("hydromel", Necessite.INDISPENSABLE);
		
		Ingredient huile = new Ingredient("huile de roche", Necessite.AU_CHOIX);
		Ingredient betterave = new Ingredient("betterave", Necessite.AU_CHOIX);
		
		Ingredient homard = new Ingredient("homard", Necessite.OPTIONNEL);
		Ingredient fraises = new Ingredient("fraises", Necessite.OPTIONNEL);
		
		Potion potion = new Potion();
		
		potion.ajouterIngredient(fraises);
		potion.ajouterIngredient(huile);
		potion.ajouterIngredient(hydromel);
		potion.ajouterIngredient(new Ingredient("hydromel", Necessite.INDISPENSABLE));
		potion.ajouterIngredient(miel);
		potion.ajouterIngredient(trefle);
		potion.ajouterIngredient(homard);
		potion.ajouterIngredient(carottes);
		potion.ajouterIngredient(betterave);
		potion.ajouterIngredient(gui);
		potion.ajouterIngredient(sel);
		potion.ajouterIngredient(poisson);
		
		System.out.println(potion);
	}
}
