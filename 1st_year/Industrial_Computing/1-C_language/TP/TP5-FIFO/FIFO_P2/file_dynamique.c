#include <stdio.h>
#include "file_dynamique.h"

/*-------------------------------------------------------------------
Initialise une MA_FILE en respectant le prototype : MA_FILE INIT_FILE()
-------------------------------------------------------------------*/

MA_FILE INIT_FILE(){
	MA_FILE p;
	p.tete=NULL;
	p.queue=NULL;
	return p;
}

/*-------------------------------------------------------------------
Affiche tous les ELEMENTs d’une MA_FILE donnee en parametre en respectant le prototype : void AFFICHE_FILE(MA_FILE)
-------------------------------------------------------------------*/

void AFFICHE_FILE(MA_FILE p){
	while(!FILE_EST_VIDE(p)){
		affiche_ELEMENT(p.tete->elm);
		p.tete=p.tete->suiv;
	}
	printf("\n\r");
}

/*-------------------------------------------------------------------
Permet de tester si une MA_FILE donnee en parametre est vide en respectant le prototype : int FILE_EST_VIDE(MA_FILE)
-------------------------------------------------------------------*/

int FILE_EST_VIDE(MA_FILE p){
	return (p.tete==NULL);
}

/*-------------------------------------------------------------------
Enfile un ELEMENT (donne en parametre) dans une MA_FILE (donnee en parametre) en respectant le prototype : MA_FILE emPILE(MA_FILE, ELEMENT)
-------------------------------------------------------------------*/

MA_FILE ENFILER(MA_FILE p,ELEMENT x){
	MA_FILE paux;
	paux.tete = malloc(sizeof(cel));
	if(!FILE_EST_VIDE(paux))
	{
		affect_ELEMENT((&paux.tete->elm),x);
		paux.tete->suiv=NULL;
		if(p.tete==NULL)p.tete=paux.tete;
		else p.queue->suiv=paux.tete;
		p.queue=paux.tete;
	}
	return p;
}

/*-------------------------------------------------------------------
Defile une MA_FILE (donnee en parametre), cette fonction doit aussi renvoyer l’ELEMENT qui etait en tete de MA_FILE en respectant le prototype : MA_FILE DEFILER(MA_FILE,ELEMENT *).
-------------------------------------------------------------------*/

MA_FILE DEFILER(MA_FILE p,ELEMENT *x){
	if (!FILE_EST_VIDE(p)){
		MA_FILE paux=p;
		affect_ELEMENT(x,paux.tete->elm);
		paux.tete=p.tete;
		p.tete=p.tete->suiv;
		if(p.tete==NULL)p.queue=NULL;
		free(paux.tete);
	}
	return p;
}

/*-------------------------------------------------------------------
Permet de saisir une MA_FILE en demandant a l’utilisateur d’entrer les ELEMENT un par un et en les inserant dans la MA_FILE en respectant le prototype : MA_FILE SAISIR_FILE().
-------------------------------------------------------------------*/

MA_FILE SAISIR_FILE(){
	MA_FILE p=INIT_FILE();
	ELEMENT x;
	char test;
	int i=1;
	do{
		x=saisir_ELEMENT();
		p=ENFILER(p,x);
		printf("Il y a t'il un autre client ? [Y/N] : ");
		scanf(" %c",&test);
	}while(test=='Y');
	return p;
}