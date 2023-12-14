#include <stdio.h>
#include "file_dynamique.h"

int main()
{
/*-------------------------------------------------------------------
Teste l'initialisation de la FIFO : INIT_FILE
-------------------------------------------------------------------*/
	/*
	MA_FILE p=INIT_FILE();
	
	if(p.tete==NULL && p.queue==NULL) printf("OK\n\r");
	else printf("NOK - STOP\n\r");
	return 0;
	*/
	
/*-------------------------------------------------------------------
Teste la fonction AFFICHE_FILE
-------------------------------------------------------------------*/
	/*
	MA_FILE p=INIT_FILE();
	
	p.tete=malloc(sizeof p);
	p.tete->suiv=NULL;
	p.tete->elm=5;

	AFFICHE_FILE(p);
	printf("\n\rOK\n\r");
	return 0;
	*/

/*-------------------------------------------------------------------
Teste la fonction FILE_EST_VIDE
-------------------------------------------------------------------*/
	/*
	MA_FILE p=INIT_FILE();
	
	if(FILE_EST_VIDE(p)) printf("OK\n\r");
	else{
		printf("NOK - STOP\n\r");
		return 0;
	}
	
	p.tete=malloc(sizeof p);
	p.tete->suiv=NULL;
	p.tete->elm=5;

	if(!FILE_EST_VIDE(p)) printf("OK\n\r");
	else printf("NOK - STOP\n\r");
	return 0;
	*/

/*-------------------------------------------------------------------
Teste la fonction ENFILER
-------------------------------------------------------------------*/
	/*
	MA_FILE p=INIT_FILE();
	
	for(int i=0;i<10+1;i++)p=ENFILER(p,i);
	AFFICHE_FILE(p);
	
	return 0;
	*/
	
/*-------------------------------------------------------------------
Teste la fonction DEFILER
-------------------------------------------------------------------*/
	/*
	MA_FILE p=INIT_FILE();
	ELEMENT x;
	
	for(int i=0;i<10;i++)p=ENFILER(p,i);
	p=DEFILER(p,&x);
	AFFICHE_FILE(p);

	p=DEFILER(p,&x);
	AFFICHE_FILE(p);

	return 0;
	*/
	
/*-------------------------------------------------------------------
Teste la fonction SAISIR_FILE
-------------------------------------------------------------------*/
	
	MA_FILE p;
	ELEMENT x;

	p=SAISIR_FILE();
	AFFICHE_FILE(p);
	
	p=DEFILER(p,&x);
	AFFICHE_FILE(p);

	p=DEFILER(p,&x);
	AFFICHE_FILE(p);

	p=ENFILER(p,300);
	AFFICHE_FILE(p);

	p=ENFILER(p,2);
	AFFICHE_FILE(p);

	p=ENFILER(p,36);
	AFFICHE_FILE(p);

	return 0;
	
}


