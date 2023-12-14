typedef struct ELEMENT{
	char composant; /* Wagon simple (W), Wagon restaurant (R), Locomotive (L) */
	int id;
}ELEMENT;

void affiche_ELEMENT(ELEMENT elm);
void affect_ELEMENT(ELEMENT* elm1,ELEMENT* elm2);
int compare_ELEMENT(ELEMENT elm1,ELEMENT elm2);
ELEMENT saisir_ELEMENT();

