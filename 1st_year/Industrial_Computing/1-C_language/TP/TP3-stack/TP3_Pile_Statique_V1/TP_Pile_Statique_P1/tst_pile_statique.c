#include <stdio.h>
#include "pile_statique.h"

int main()
{
/*-------------------------------------------------------------------
Teste l'initialisation de la pile
-------------------------------------------------------------------*/
	/*
	PILE pile;
	pile=init_PILE();
	if(pile.tete==-1) printf("OK\n\r");
	else printf("NOK - STOP\n\r");
	return 0;
	*/
	
/*-------------------------------------------------------------------
Teste la fonction affiche_PILE
-------------------------------------------------------------------*/
	/*
	int i;
	PILE pile;
	for(i=0;i<MAX;i++) pile.data[i]=i;
	affiche_PILE(pile);
	printf("\n\rOK\n\r");
	return 0;
	*/

/*-------------------------------------------------------------------
Teste la fonction PILE_estVide
-------------------------------------------------------------------*/
	/*
	PILE pile;
	pile=init_PILE();
	if(PILE_estVide(pile)) printf("OK\n\r");
	else{
		printf("NOK - STOP\n\r");
		return 0;
	}
	pile.tete++;
  pile.data[pile.tete]=1;
	if(!PILE_estVide(pile)) printf("OK\n\r");
	else printf("NOK - STOP\n\r");
	return 0;
	*/
	
/*-------------------------------------------------------------------
Teste la fonction PILE_Pleine
-------------------------------------------------------------------*/
	/*
	PILE pile;
	int i;
	pile=init_PILE();
	for(i=0;i<MAX-1;i++){
		pile.tete++;
  	pile.data[pile.tete]=i;
  	if(PILE_estPleine(pile)){
  		printf("NOK - STOP\n\r");
  		return 0;
  	}
	}
  if(!PILE_estPleine(pile)) printf("OK\n\r");
  else{
  	printf("NOK - STOP\n\r");
  	return 0;
  }
  pile.tete++;
  pile.data[pile.tete]=i;
  if(PILE_estPleine(pile)) printf("OK\n\r");
  else printf("NOK - STOP\n\r");
  return 0;
	*/

/*-------------------------------------------------------------------
Teste la fonction emPILE
-------------------------------------------------------------------*/
	/*
	PILE pile;
	int i,tmp;
	pile=init_PILE();
	for(i=0;i<MAX+1;i++){
		tmp=pile.tete;
		pile=emPILE(pile,i);
		if(tmp+1==pile.tete) printf("Valeur empilée : %d\n\r",pile.data[pile.tete]);
		else printf("Erreur : Impossible d'enpiler une nouvelle valeur -> Pile pleine\n\r");
	}
	return 0;
	*/
	
/*-------------------------------------------------------------------
Teste la fonction dePILE
-------------------------------------------------------------------*/
/*
	PILE pile;
	int i,tmp,val;
	pile=init_PILE();
	for(i=0;i<MAX;i++)pile=emPILE(pile,i);
	for(i=0;i<MAX+1;i++){
		tmp=pile.tete;
		pile=dePILE(pile,&val);
		if(tmp-1==pile.tete) printf("Valeur dépilée : %d\n\r",val);
		else printf("Erreur : Impossible de dépiler -> Pile vide\n\r");
	}
	return 0;
	*/
	
/*-------------------------------------------------------------------
Teste la fonction saisir_PILE
-------------------------------------------------------------------*/
	PILE pile;
	int i;
	pile=saisir_PILE();
	affiche_PILE(pile);
	return 0;
}


