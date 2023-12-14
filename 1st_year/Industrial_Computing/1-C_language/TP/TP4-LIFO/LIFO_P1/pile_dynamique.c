#include <stdio.h>
#include "pile_dynamique.h"

/*-------------------------------------------------------------------
Initialise une pile en respectant le prototype : PILE init_PILE()
-------------------------------------------------------------------*/
PILE init_PILE(){
	PILE p=NULL;
	return p;
}

/*-------------------------------------------------------------------
Affiche tous les ELEMENTs d’une pile donnee en parametre en respectant le prototype : void affiche_PILE(PILE)
-------------------------------------------------------------------*/

void affiche_PILE(PILE p){
	while(!PILE_estVide(p)){
		affiche_ELEMENT(p->elm);
		p=p->suiv;
	}
	printf("\n\r");
}

/*-------------------------------------------------------------------
Permet de tester si une pile donnee en parametre est vide en respectant le prototype : int PILE_estVide(PILE)
-------------------------------------------------------------------*/
int PILE_estVide(PILE p){
	return (p==NULL);
}

/*-------------------------------------------------------------------
Empile un ELEMENT (donne en parametre) dans une pile (donnee en parametre) en respectant le prototype : PILE emPILE(PILE, ELEMENT)
-------------------------------------------------------------------*/

PILE emPILE(PILE p,ELEMENT x){
	PILE paux = malloc(sizeof(PILE));
	if(paux!=NULL)
	{
		affect_ELEMENT((&paux->elm),x);
		paux->suiv=p;
		p=paux;
	}
	return p;
}

/*-------------------------------------------------------------------
Depile une pile (donnee en parametre), cette fonction doit aussi renvoyer l’ELEMENT qui etait en tete de pile en respectant le prototype : PILE dePILE(PILE,ELEMENT *).
-------------------------------------------------------------------*/

PILE dePILE(PILE p,ELEMENT *x){
	if (!PILE_estVide(p))
	{
		PILE paux=p;
		affect_ELEMENT(x,paux->elm);
		p=p->suiv;
		free(paux);
	}
	return p;
}

/*-------------------------------------------------------------------
Permet de saisir une pile en demandant a l’utilisateur d’entrer les ELEMENT un par un et en les inserant dans la pile en respectant le prototype : PILE saisir_PILE().
-------------------------------------------------------------------*/

PILE saisir_PILE(){
	PILE p=init_PILE();
	ELEMENT x;
	char test;
	int i=1;
	do{
		printf("\n\rSaisir une valeur [%d] : ",i++);
		x=saisir_ELEMENT();
		p=emPILE(p,x);
		printf("Voulez-vous continuer ? [Y/N] : ");
		scanf(" %c",&test);
	}while(test=='Y');
	return p;
}

