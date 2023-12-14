#include <stdio.h>
#include <stddef.h>
#include "arbre.h"

int main(){

    ARBRE a=INIT_ARBRE();
    if(a.g==NULL && a.d==NULL) puts("INIT_ARBRE\t\tOK");
    else puts("INIT_ARBRE\t\tNOK");

    if(ARBRE_VIDE(&a)) puts("ARBRE_VIDE\t\tOK");
    else puts("ARBRE_VIDE\t\tNOK");

    int v1=10;
    AJOUT_DS_ARBRE(&a,v1);
    if(a.val==v1)printf("AJOUT_DS_ARBRE\t\tOK\t%d=%d\t",a.val,v1);
    else printf("AJOUT_DS_ARBRE\t\tNOK\t%d=%d\t",a.val,v1);
    AFFICHE_ARBRE(&a);
    puts("");

    if(ARBRE_VIDE(&a)) puts("ARBRE_VIDE\t\tOK"); //CAR IL N'Y A QUE LA PREMIERE VALEUR, IL N'Y A PAS ENCORE DE BRANCHES !
    else puts("ARBRE_VIDE\t\tNOK");

    int v2=1;
    AJOUT_DS_ARBRE(&a,v2);
    if(a.g->val==v2)printf("AJOUT_DS_ARBRE\t\tOK\t%d=%d\t",a.g->val,v2);
    else printf("AJOUT_DS_ARBRE\t\tNOK\t%d=%d\t",a.g->val,v2);
    AFFICHE_ARBRE(&a);
    puts("");

    if(!ARBRE_VIDE(&a)) puts("ARBRE_VIDE\t\tOK");
    else puts("ARBRE_VIDE\t\tNOK");

    int v3=6;
    AJOUT_DS_ARBRE(&a,v3);
    if(a.g->d->val==v3)printf("AJOUT_DS_ARBRE\t\tOK\t%d=%d\t",a.g->d->val,v3);
    else printf("AJOUT_DS_ARBRE\t\tNOK\t%d=%d\t",a.g->d->val,v3);
    AFFICHE_ARBRE(&a);
    puts("");

    if(!ARBRE_VIDE(&a)) puts("ARBRE_VIDE\t\tOK");
    else puts("ARBRE_VIDE\t\tNOK");

    puts("");
    AJOUT_DS_ARBRE(&a,143);
    AJOUT_DS_ARBRE(&a,50);
    AJOUT_DS_ARBRE(&a,70);
    AJOUT_DS_ARBRE(&a,22);
    AJOUT_DS_ARBRE(&a,3);
    AJOUT_DS_ARBRE(&a,5);
    AJOUT_DS_ARBRE(&a,122);
    AFFICHE_ARBRE(&a);
    puts("");
    
    int v4=ENLEVER_MIN_DE_ARBRE(&a);
    if(v4==v2)printf("\n\rENLEVER_MIN_DE_ARBRE\tOK\t%d=%d\t",v4,v2);
    else printf("\n\rENLEVER_MIN_DE_ARBRE\tNOK\t%d=%d\t",v4,v2);
    AFFICHE_ARBRE(&a);
    puts("");

    AJOUT_DS_ARBRE(&a,4);
    puts("");
    AFFICHE_ARBRE(&a);
    puts("");

    return 0;
}