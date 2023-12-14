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
	pile=init_PILE();
	for(i=0;i<MAX;i++){
		pile.tete++;
		pile.data[i]=i;
	}
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
		if(tmp+1==pile.tete) printf("Valeur empilée : %f\n\r",pile.data[pile.tete]);
		else printf("Erreur : Impossible d'enpiler une nouvelle valeur -> Pile pleine\n\r");
	}
	return 0;
	*/
	
/*-------------------------------------------------------------------
Teste la fonction dePILE
-------------------------------------------------------------------*/
	/*
	PILE pile;
	int i,tmp;
	ELEMENT val;
	pile=init_PILE();
	for(i=0;i<MAX;i++)pile=emPILE(pile,i);
	for(i=0;i<MAX+1;i++){
		tmp=pile.tete;
		pile=dePILE(pile,&val);
		if(tmp-1==pile.tete) printf("Valeur dépilée : %f\n\r",val);
		else printf("Erreur : Impossible de dépiler -> Pile vide\n\r");
	}
	return 0;
	*/
	
/*-------------------------------------------------------------------
Teste la fonction saisir_PILE
-------------------------------------------------------------------*/
	/*
	PILE pile;
	int i;
	pile=saisir_PILE();
	affiche_PILE(pile);
	return 0;
	*/
	
/*-------------------------------------------------------------------
Application au train
-------------------------------------------------------------------*/
	VOIE_DE_WAGONS est;
	VOIE_DE_WAGONS garage;
	VOIE_DE_WAGONS ouest;
	ELEMENT elm;
	int i,j;

	est=saisir_PILE();
	garage=init_PILE();
	ouest=init_PILE();
	
	printf("\n\r");
	printf("Est :");
	affiche_PILE(est);
	printf("Garage :");
	affiche_PILE(garage);
	printf("Ouest :");
	affiche_PILE(ouest);
	printf("\n\r");
	

	for(i=0;!PILE_estVide(est);i++){
		garage=emPILE(garage,est.train[0]);
		if(!compare_ELEMENT(est.train[est.tete],garage.train[0]))	for(int i=0;i<est.tete;i++)	est.train[i]=est.train[i+1];
  	est=dePILE(est,&elm);
		printf("Etape %d : Déplacement du %c%d de l'est vers le garage \n\r",i+1,garage.train[i].composant,garage.train[i].id);
		printf("Est :");
		affiche_PILE(est);
		printf("Garage :");
		affiche_PILE(garage);
		printf("Ouest :");
		affiche_PILE(ouest);
		printf("\n\r");
	}
	
	for(j=0;!PILE_estVide(garage);j++){
		garage=dePILE(garage,&elm);
		ouest=emPILE(ouest,elm);
		printf("Etape %d : Déplacement du %c%d du garage vers l'ouest \n\r",i+j+1,elm.composant,elm.id);
		printf("Est :");
		affiche_PILE(est);
		printf("Garage :");
		affiche_PILE(garage);
		printf("Ouest :");
		affiche_PILE(ouest);
		printf("\n\r");
	}
	
	printf("----Demi-tour effectue----\n\r");
	
return 0;
}


