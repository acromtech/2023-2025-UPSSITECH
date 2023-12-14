#include <stdio.h>
#include "pile_statique.h"

/*-------------------------------------------------------------------
Initialise une pile en respectant le prototype : PILE init PILE()
-------------------------------------------------------------------*/
VOIE_DE_WAGONS init_PILE(){
  VOIE_DE_WAGONS pile;
  pile.tete=-1;
  return pile;
}

/*-------------------------------------------------------------------
Affiche tous les entiers d’une pile donnee en parametre en respectant le prototype : void affiche PILE(PILE)
-------------------------------------------------------------------*/
void affiche_PILE(VOIE_DE_WAGONS pile){
  for(int i=0;i<pile.tete+1;i++) affiche_ELEMENT(pile.train[i]);
  printf("\n\r");
}

/*-------------------------------------------------------------------
Permet de tester si une pile donnee en parametre est vide en respectant le prototype : int PILE estVide(PILE)
-------------------------------------------------------------------*/
int PILE_estVide(VOIE_DE_WAGONS pile){
  return (pile.tete==-1);
}

/*-------------------------------------------------------------------
Permet de tester si une pile donnee en parametre est pleine en respectant le prototype : int PILE estPleine(PILE).
-------------------------------------------------------------------*/
int PILE_estPleine(VOIE_DE_WAGONS pile){
  return (pile.tete==MAX-1);
}

/*-------------------------------------------------------------------
Empile un ELEMENT (donne en parametre) dans une pile (donnee en parametre) en respectant le prototype : PILE emPILE(PILE, ELEMENT)
-------------------------------------------------------------------*/
VOIE_DE_WAGONS emPILE(VOIE_DE_WAGONS pile,ELEMENT x){
  if(!PILE_estPleine(pile)){
    pile.tete++;
    affect_ELEMENT(&pile.train[pile.tete],&x);
  }
  return pile;
}

/*-------------------------------------------------------------------
Depile une pile (donnee en parametre), cette fonction doit aussi renvoyer l’ELEMENT qui etait en tete de pile en respectant le prototype : PILE dePILE(PILE,ELEMENT *).
-------------------------------------------------------------------*/
VOIE_DE_WAGONS dePILE(VOIE_DE_WAGONS pile,ELEMENT *val_tete){
  if(!PILE_estVide(pile)){
  	affect_ELEMENT(val_tete,&pile.train[pile.tete]);
  	pile.tete--;
  }
  return pile;
}

/*-------------------------------------------------------------------
Permet de saisir une pile en demandant a l’utilisateur d’entrer les ELEMENT un par un et en les inserant dans la pile en respectant le prototype : PILE saisir PILE().
-------------------------------------------------------------------*/
VOIE_DE_WAGONS saisir_PILE(){
  int nb;
  ELEMENT x;
  VOIE_DE_WAGONS pile=init_PILE();
  
  /*Empile la locomotive*/
  x.composant='L';
  x.id=1;
  pile=emPILE(pile,x);
  
  printf("Combien de wagon souhaiez vous ?");
  do{
		printf("\n\rSaisir une valeur entre 0 et %d : ",MAX-1);
		scanf("%d",&nb);
  }while(nb>MAX-1 || nb<0);
	for(int i=0;i<nb;i++){
		printf("Quel type de wagon ? [W/R] (%d/%d) :",i+1,nb);
		x=saisir_ELEMENT(); //permet a l'utilisateur de saisir le composant souhaité
		x.id=i+2; //affecte un id par rapport a sa position dans la pile
		pile=emPILE(pile,x);
  }
  return pile;
}
