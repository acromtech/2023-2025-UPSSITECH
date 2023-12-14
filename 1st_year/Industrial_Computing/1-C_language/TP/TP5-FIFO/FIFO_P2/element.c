#include <stdio.h>
#include "element.h"

/*-------------------------------------------------------------------
Affiche l'élément
-------------------------------------------------------------------*/
void affiche_ELEMENT(ELEMENT elm){
	printf("Nombre de tickets = %d // Prix payé : %d\n\r",elm.nb_tickets,elm.prix);
}

/*-------------------------------------------------------------------
Affecte un élément a un autre élément
-------------------------------------------------------------------*/
void affect_ELEMENT(ELEMENT *elm1,ELEMENT elm2){
	*elm1=elm2;
}

/*-------------------------------------------------------------------
Compare un élément à un autre élément
-------------------------------------------------------------------*/
int compare_ELEMENT(ELEMENT elm1,ELEMENT elm2){
	return (elm1.nb_tickets==elm2.nb_tickets && elm1.prix==elm2.prix);
}

/*-------------------------------------------------------------------
Permet de saisir un élement
-------------------------------------------------------------------*/
ELEMENT saisir_ELEMENT(){
	ELEMENT elm;
	do{
		printf("\n\r Combien de ticket a pris le client ? [>0 ticket] : ");
		scanf("%d",&elm.nb_tickets);
	}while(elm.nb_tickets<=0);
	do{
		printf(" Combien a t'il payé ? [>0€] : ");
		scanf("%d",&elm.prix);
	}while(elm.prix<=0);
	return elm;
}

