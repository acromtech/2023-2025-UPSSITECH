#include "element.h"
#include <stdlib.h>

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