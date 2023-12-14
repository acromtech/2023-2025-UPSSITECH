#include "element.h"

char test1='W',test2='R';

void affiche_ELEMENT(ELEMENT e){
	printf(" %5c%d ", e.composant, e.ID);
}

ELEMENT saisir_ELEMENT(){
	ELEMENT e;
	do{
		printf("\rSaisir un Wagon simple (W) ou Wagon restaurant (R) : ");
		scanf(" %c", &e.composant);
	}while ((e.composant != test1) && (e.composant != test2));
	return e;
}

void affect_ELEMENT(ELEMENT x, ELEMENT *y){
	*y = x;
}

bool compare_ELEMENT(ELEMENT a, ELEMENT b){
	if ((a.composant == b.composant) && (a.ID == b.ID))
		return 1;
	return 0;
}
