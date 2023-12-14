#include <stdio.h>

#define MAX 100

typedef struct PILE{
  int tete;
  int data[MAX];
}PILE;

/*-------------------------------------------------------------------
Initialise une pile en respectant le prototype : PILE init PILE()
-------------------------------------------------------------------*/
PILE init_PILE(){
  PILE pile;
  pile.tete=-1;
  return pile;
}

/*-------------------------------------------------------------------
Affiche tous les entiers d’une pile donnee en parametre en respectant le prototype : void affiche PILE(PILE)
-------------------------------------------------------------------*/
void affiche_PILE(PILE pile){
  int i;
  for(i=0;i<pile.tete+1;i++) printf("%d ",pile.data[i]);
  printf("\n\r");
}

/*-------------------------------------------------------------------
Permet de tester si une pile donnee en parametre est vide en respectant le prototype : int PILE estVide(PILE)
-------------------------------------------------------------------*/
int PILE_estVide(PILE pile){
  return (pile.tete==-1);
}

/*-------------------------------------------------------------------
Permet de tester si une pile donnee en parametre est pleine en respectant le prototype : int PILE estPleine(PILE).
-------------------------------------------------------------------*/
int PILE_estPleine(PILE pile){
  return (pile.tete==MAX-1);
}

/*-------------------------------------------------------------------
Empile un entier (donne en parametre) dans une pile (donnee en parametre) en respectant le prototype : PILE emPILE(PILE, int)
-------------------------------------------------------------------*/
PILE emPILE(PILE pile,int x){
  if(!PILE_estPleine(pile)){
    pile.tete++; /*Mise a jour de la tete*/
    pile.data[pile.tete]=x; /*Ajoute une valeur à la tete*/
  }
  return pile;
}

/*-------------------------------------------------------------------
Depile une pile (donnee en parametre), cette fonction doit aussi renvoyer l’entier qui etait en tete de pile en respectant le prototype : PILE dePILE(PILE,int *).
-------------------------------------------------------------------*/
PILE dePILE(PILE pile,int *val_tete){
  if(!PILE_estVide(pile)){
    *val_tete=pile.data[pile.tete];
    pile.tete--; /*Mise a jour de la tete : En décrémemantant on observe plus la data. Elle ne nous interesse plus puisqu'elle sera remplacé lorsqu'on empilera une nouvelle valeur*/
  }
  return pile;
}

/*-------------------------------------------------------------------
Permet de saisir une pile en demandant a l’utilisateur d’entrer les entiers un par un et en les inserant dans la pile en respectant le prototype : PILE saisir PILE().
-------------------------------------------------------------------*/
PILE saisir_PILE(){
  int i,nb,x;
  PILE pile=init_PILE();
  printf("Combien de valeur souhaiez vous rentrer ?");
  do{
		printf("\n\rSaisir une valeur entre 0 et %d : ",MAX);
		scanf("%d",&nb);
  }while(nb>MAX || nb<0);
	for(i=0;i<nb;i++){
		printf("Rentrez une valeur dans la pile (%d/%d) :",i+1,nb);
		scanf("%d",&x);
		pile=emPILE(pile,x);
  }
  return pile;
}

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
