
typedef struct ARBRE{
    struct ARBRE* g;
    struct ARBRE* d;
    int val;
}ARBRE;

ARBRE INIT_ARBRE();
void AFFICHE_ARBRE(ARBRE*);
int ARBRE_VIDE(ARBRE*);
void AJOUT_DS_ARBRE(ARBRE*,int);
int ENLEVER_MIN_DE_ARBRE(ARBRE*);