#include "element.h"
#include <stdlib.h>

#define NB_SEANCE 3 // il y a plusieurs séances par jour mais il s'agit d'un nombre fixe

typedef struct cel {
	ELEMENT elm;
	struct cel *suiv;
}cel;

typedef struct MA_FILE{
	cel *tete;
	cel *queue;
}MA_FILE;

MA_FILE INIT_FILE();
void AFFICHE_FILE(MA_FILE p);
int FILE_EST_VIDE(MA_FILE p);
MA_FILE ENFILER(MA_FILE p,ELEMENT x);
MA_FILE DEFILER(MA_FILE p,ELEMENT *x);
MA_FILE SAISIR_FILE();