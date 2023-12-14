#include "element.h"
#define MAX 10

typedef struct VOIE_DE_WAGONS{
	int tete;
	ELEMENT train[MAX];
}VOIE_DE_WAGONS;

VOIE_DE_WAGONS init_PILE();
void affiche_PILE(VOIE_DE_WAGONS pile);
int PILE_estVide(VOIE_DE_WAGONS pile);
int PILE_estPleine(VOIE_DE_WAGONS pile);
VOIE_DE_WAGONS emPILE(VOIE_DE_WAGONS pile,ELEMENT x);
VOIE_DE_WAGONS dePILE(VOIE_DE_WAGONS pile,ELEMENT *val_tete);
VOIE_DE_WAGONS saisir_PILE();

