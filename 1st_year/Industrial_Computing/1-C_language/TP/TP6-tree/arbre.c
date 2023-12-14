#include <stdio.h>
#include <stddef.h>
#include <stdlib.h>
#include "arbre.h"

ARBRE INIT_ARBRE(){
    ARBRE a;
    a.g=NULL;
    a.d=NULL;
    a.val=0;
    return a;
}
void AFFICHE_ARBRE(ARBRE* a){
    if(a->g!=NULL)AFFICHE_ARBRE(a->g);
    printf("%d ", a->val);
    if(a->d!=NULL)AFFICHE_ARBRE(a->d);
}
int ARBRE_VIDE(ARBRE* a){
    return(a->g==NULL && a->d==NULL);
}
void AJOUT_DS_ARBRE(ARBRE* a, int val){
    if(a->val==0)a->val=val;
    else if(val<a->val){
        if(a->g==NULL){
            a->g=(ARBRE*)malloc(sizeof(ARBRE));
            a->g->val=val;
            a->g->g=NULL;
            a->g->d=NULL;
        }
        else AJOUT_DS_ARBRE(a->g,val);
    }
    else if(val>a->val)
        if(a->d==NULL){
            a->d=(ARBRE*)malloc(sizeof(ARBRE));
            a->d->val=val;
            a->d->g=NULL;
            a->d->d=NULL;
        }
        else AJOUT_DS_ARBRE(a->d,val);
}
int ENLEVER_MIN_DE_ARBRE(ARBRE* a){
    int r;
    if(a->g!=NULL){
        r=ENLEVER_MIN_DE_ARBRE(a->g);
        puts("");
        AFFICHE_ARBRE(a);       //JE NE COMPRENDS PAS POURQUOI L'ARBRE NE SE DECALE PAS...
    }
    else{
        r=a->val;
        if(a->d!=NULL){
            a=a->d;
            AFFICHE_ARBRE(a);   //ALORS QU'ON VOIT BIEN QUE LE 1 N'EST PLUS PRESENT
            //free(a);          //IL FAUDRAIT POTENTIELLEMENT FAIRE UNE SECONDE FONCTION RECURSIVE
        }
    }
    return r;
}