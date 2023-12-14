#include <stdio.h>
#include "element.h"

/*-------------------------------------------------------------------
Affiche l'élément
-------------------------------------------------------------------*/
void affiche_ELEMENT(ELEMENT elm){
	printf("%c%d-",elm.composant,elm.id);
}

/*-------------------------------------------------------------------
Affecte un élément a un autre élément
-------------------------------------------------------------------*/
void affect_ELEMENT(ELEMENT* elm1,ELEMENT elm2){
	*elm1=elm2;
}

/*-------------------------------------------------------------------
Compare un élément à un autre élément
-------------------------------------------------------------------*/
int compare_ELEMENT(ELEMENT elm1,ELEMENT elm2){
	return (elm1.composant==elm2.composant && elm1.id==elm2.id);
}

/*-------------------------------------------------------------------
Permet de saisir un élement
-------------------------------------------------------------------*/
ELEMENT saisir_ELEMENT(){
	ELEMENT elm;
	do{
		printf("\n\rComposant : ");
		scanf("%s",&elm.composant);
	}while(elm.composant!='W'&&elm.composant!='R');
	return elm;
}

