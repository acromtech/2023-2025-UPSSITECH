#ifndef ELEMENT_H_INCLUS
#define ELEMENT_H_INCLUS
#include <stdio.h>
#include <string.h>
#include <stdbool.h>

typedef struct stTrain{
	char composant;
	int ID;
} ELEMENT;

void affiche_ELEMENT(ELEMENT e);
ELEMENT saisir_ELEMENT(void);
void affect_ELEMENT(ELEMENT x, ELEMENT *y);
bool compare_ELEMENT(ELEMENT a, ELEMENT b);

#endif
