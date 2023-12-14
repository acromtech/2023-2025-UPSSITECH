#define MAX 100

typedef struct PILE{
  int tete;
  int data[MAX];
}PILE;

PILE init_PILE();
void affiche_PILE(PILE pile);
int PILE_estVide(PILE pile);
int PILE_estPleine(PILE pile);
PILE emPILE(PILE pile,int x);
PILE dePILE(PILE pile,int *val_tete);
PILE saisir_PILE();

