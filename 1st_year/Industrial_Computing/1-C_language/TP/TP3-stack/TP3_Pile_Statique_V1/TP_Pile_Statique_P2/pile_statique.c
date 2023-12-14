#include <stdio.h>
#include "pile_statique.h"

/*-------------------------------------------------------------------
Initialise une pile en respectant le prototype : PILE init PILE()
-------------------------------------------------------------------*/
PILE init_PILE(){
  PILE pile;
  pile.tete=-1;
  return pile;
}

/*-------------------------------------------------------------------
Affiche tous les entiers d’une pile donnee en parametre en respectant le prototype : void affiche PILE(PILE)
-------------------------------------------------------------------*/
void affiche_PILE(PILE pile){
  int i;
  for(i=0;i<pile.tete+1;i++) affiche_ELEMENT(pile.data[i]);
  printf("\n\r");
}

/*-------------------------------------------------------------------
Permet de tester si une pile donnee en parametre est vide en respectant le prototype : int PILE estVide(PILE)
-------------------------------------------------------------------*/
int PILE_estVide(PILE pile){
  return (pile.tete==-1);
}

/*-------------------------------------------------------------------
Permet de tester si une pile donnee en parametre est pleine en respectant le prototype : int PILE estPleine(PILE).
-------------------------------------------------------------------*/
int PILE_estPleine(PILE pile){
  return (pile.tete==MAX-1);
}

/*-------------------------------------------------------------------
Empile un ELEMENT (donne en parametre) dans une pile (donnee en parametre) en respectant le prototype : PILE emPILE(PILE, ELEMENT)
-------------------------------------------------------------------*/
PILE emPILE(PILE pile,ELEMENT x){
  if(!PILE_estPleine(pile)){
    pile.tete++; /*Mise a jour de la tete*/
    affect_ELEMENT(&pile.data[pile.tete],&x); /*Ajoute une valeur à la tete*/
  }
  return pile;
}

/*-------------------------------------------------------------------
Depile une pile (donnee en parametre), cette fonction doit aussi renvoyer l’ELEMENT qui etait en tete de pile en respectant le prototype : PILE dePILE(PILE,ELEMENT *).
-------------------------------------------------------------------*/
PILE dePILE(PILE pile,ELEMENT *val_tete){
  if(!PILE_estVide(pile)){
  	affect_ELEMENT(val_tete,&pile.data[pile.tete]);
    pile.tete--; /*Mise a jour de la tete : En décrémemantant on observe plus la data. Elle ne nous interesse plus puisqu'elle sera remplacé lorsqu'on empilera une nouvelle valeur*/
  }
  return pile;
}

/*-------------------------------------------------------------------
Permet de saisir une pile en demandant a l’utilisateur d’entrer les ELEMENT un par un et en les inserant dans la pile en respectant le prototype : PILE saisir PILE().
-------------------------------------------------------------------*/
PILE saisir_PILE(){
  int i,nb;
  ELEMENT x;
  PILE pile=init_PILE();
  printf("Combien de valeur souhaiez vous rentrer ?");
  do{
		printf("\n\rSaisir une valeur entre 0 et %d : ",MAX);
		scanf("%d",&nb);
  }while(nb>MAX || nb<0);
	for(i=0;i<nb;i++){
		printf("Rentrez une valeur dans la pile (%d/%d) :",i+1,nb);
		x=saisir_ELEMENT();
		pile=emPILE(pile,x);
  }
  return pile;
}
