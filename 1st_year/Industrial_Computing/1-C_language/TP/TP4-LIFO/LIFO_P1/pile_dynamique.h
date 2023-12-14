#include "element.h"
#include <stdlib.h>

typedef struct cel {
	ELEMENT elm;
	struct cel *suiv;
}cel;

typedef struct cel* PILE;

PILE init_PILE();
void affiche_PILE(PILE p);
int PILE_estVide(PILE p);
PILE emPILE(PILE p,ELEMENT x);
PILE dePILE(PILE p,ELEMENT *x);
PILE saisir_PILE();

