package potion;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

//TODO exo III.
public class Potion {
	List<Ingredient> listeIngredients = new ArrayList<>();

	public void ajouterIngredient(Ingredient ingredient) {
		// Si la liste est vide
		//AIDE utiliser les methodes de l'ArrayList
		if () {
			
		} else {
			//TODO exo IV.2
			
			//fin ajout exo IV.2
				Necessite necessaire = ;
				switch (necessaire) {
				//Si l'ingredient a ajouter n'est pas indispensable
				case OPTIONNEL:
					
					break;
				//Si l'ingredient a ajouter est indispensable
				case INDISPENSABLE:
					
					break;
				//Si l'ingredient a ajouter est un ingredient au choix
				default: // AU_CHOIX
					boolean ingredientAjoute = false;
					//parcourir la liste avec un ListIterator
					for () {
						Ingredient ingredientAcomparer = ;
						Necessite necessiteAComparer = ;
						if (necessiteAComparer.equals(Necessite.OPTIONNEL)) {
							//reculer dans la liste d'un ingredient
							
							//ajouter l'ingredient
							
							ingredientAjoute = true;
						}
					}
					if (!ingredientAjoute) {
						//ajouter l'ingredient
						
					}
					break;
				}
			}
		}
	}

	public String toString() {
		String chaine = "Les ingrédients de la potion sont :\n";
		chaine += listeIngredients;
		return chaine;
	}

}
