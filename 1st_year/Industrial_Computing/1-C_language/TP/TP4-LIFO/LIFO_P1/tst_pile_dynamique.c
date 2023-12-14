#include <stdio.h>
#include "pile_dynamique.h"

int main()
{
/*-------------------------------------------------------------------
Teste l'initialisation de la LIFO : init_PILE
-------------------------------------------------------------------*/
	/*
	PILE p=init_PILE();
	
	if(p==NULL) printf("OK\n\r");
	else printf("NOK - STOP\n\r");
	return 0;
	*/
	
/*-------------------------------------------------------------------
Teste la fonction affiche_PILE
-------------------------------------------------------------------*/
	/*
	PILE p=init_PILE();
	
	p=malloc(sizeof p);
	p->suiv=NULL;
	p->elm=5;
	
	affiche_PILE(p);
	printf("\n\rOK\n\r");
	return 0;
	*/

/*-------------------------------------------------------------------
Teste la fonction PILE_estVide
-------------------------------------------------------------------*/
	/*
	PILE p=init_PILE();
	
	if(PILE_estVide(p)) printf("OK\n\r");
	else{
		printf("NOK - STOP\n\r");
		return 0;
	}
	
	p=malloc(sizeof p);
	p->suiv=NULL;
	p->elm=5;
	
	if(!PILE_estVide(p)) printf("OK\n\r");
	else printf("NOK - STOP\n\r");
	return 0;
	*/

/*-------------------------------------------------------------------
Teste la fonction emPILE
-------------------------------------------------------------------*/
	/*
	PILE p=init_PILE();
	
	for(int i=0;i<MAX+1;i++)p=emPILE(p,i);
	affiche_PILE(p);
	
	return 0;
	*/
	
/*-------------------------------------------------------------------
Teste la fonction dePILE
-------------------------------------------------------------------*/
	/*
	PILE p=init_PILE();
	ELEMENT x=9;
	
	for(int i=0;i<MAX;i++)p=emPILE(p,i);
	p=dePILE(p,&x);
	affiche_PILE(p);
	
	return 0;
	*/
	
/*-------------------------------------------------------------------
Teste la fonction saisir_PILE
-------------------------------------------------------------------*/
	
	PILE p;
	ELEMENT x;

	p=saisir_PILE();
	affiche_PILE(p);
	
	return 0;
	
}


