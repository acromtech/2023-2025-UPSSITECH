package src;

public class Jeu {
	//Attributes
	private boolean fini;
	
	//Constructor
	public void Jeu(int taille) {
		//Initialise un tableau à 2 dimentions correspondant aux case du plateau avec une "taille" pour chacun des joueurs
	}
	
	//Methods
	public void jouer() {
		//Potentiellement affecter une valeur à "fini" pour lancer le jeu
	}
	private void finDePartie(int numJ) {
		//Lorsqu'une équipe n'a plus aucun bateau -> si la liste du joueur "numJ" est vide
		//Affichage du joueur ayant perdu à l'écran
	}
	private void majJeuAvCommande(Commande cmd) {
		// Renvoi sur les différentes commandes données : Id / Action / Déplacement
	}
	private void majJeuCasTir(Commande cmd) {
		//mettre a jour l'état du bateau
	}
	private void majJeuCasPeche(Commande cmd) {
		//mettre a jour les sous-marin (endomagés) si un chalutier est dessus -> setEndomage()
	}
	private boolean majListeNavire(Navire n) {
		//Retire si nécessaire de la liste les navires "coulés"
	}
	private void majJeuCasDeplacement(Commande cmd) {
		//mettre a jour la position d'un bateau d'un joueur
	}
	public void choixJoueurs() {
		//Maintenir la position / se déplacer / tirer / viser une case en particulier / pêche
	}
	public String toString() {
		// La partie continue ???
		// Lance tous les toString de ses enfants ?
	}
	public void attributionNavire() {
		//Pour chaque joueur : Peche x1 / Bataillon x2
	}
	public void positionnementNavire() {
		//Au choix du joueur : Si humain choix avec saisie au clavier, si IA random
	}
	public void main(String [] args) {
		do {
			//Si le joueur est l'IA -> tirageAleatoire();
			//
		}while(finDePartie());
	}
	
	
}
