#include <stdio.h>
#include "element.h"

/*-------------------------------------------------------------------
Affiche l'élément
-------------------------------------------------------------------*/
void affiche_ELEMENT(ELEMENT elm){
	printf("%f ",elm);
}

/*-------------------------------------------------------------------
Affecte un élément a un autre élément
-------------------------------------------------------------------*/
void affect_ELEMENT(ELEMENT* elm1,ELEMENT* elm2){
	*elm1=*elm2;
}

/*-------------------------------------------------------------------
Compare un élément à un autre élément
-------------------------------------------------------------------*/
int compare_ELEMENT(ELEMENT elm1,ELEMENT elm2){
	return (elm1==elm2);
}

/*-------------------------------------------------------------------
Permet de saisir un élement
-------------------------------------------------------------------*/
ELEMENT saisir_ELEMENT(){
	ELEMENT elm;
	scanf("%f",&elm);
	return elm;
}

