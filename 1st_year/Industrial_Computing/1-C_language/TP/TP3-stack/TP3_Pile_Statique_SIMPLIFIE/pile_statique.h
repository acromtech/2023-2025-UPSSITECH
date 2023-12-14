#ifndef PILE_STATIQUE_H_INCLUS
#define PILE_STATIQUE_H_INCLUS
#include "element.h"
#define MAX 100

//extern volatile int taille_wagon;

typedef struct stPile{
	ELEMENT train[MAX];
	int tete;
}PILE;

PILE init_PILE(void);
void affiche_PILE(PILE p);
int PILE_estVide(PILE p);
int PILE_estPleine(PILE p);
PILE emPILE(PILE p, ELEMENT x);
PILE dePILE(PILE p, ELEMENT *x);
PILE saisir_PILE(void);

#endif
