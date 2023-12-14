//typedef int ELEMENT;

/*
Chaque client correspond à :
    - un nombre de tickets
    - un prix total correspondant à l'achat de tous les tickets
*/
typedef struct ELEMENT{
    int nb_tickets;
    int prix;
}ELEMENT;

void affiche_ELEMENT(ELEMENT elm);
void affect_ELEMENT(ELEMENT *elm1,ELEMENT elm2);
int compare_ELEMENT(ELEMENT elm1,ELEMENT elm2);
ELEMENT saisir_ELEMENT();
