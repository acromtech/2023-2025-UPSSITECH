#include <iostream>
#include "Tableau.h"

using namespace std;

Tableau::Tableau(int taille=0){
    this->tab=new int[tailleMax];
    this->tailleMax=taille;
    this->nbElement=0;
};
Tableau::Tableau(Tableau &copie){
    this->tab=new int [copie.tailleMax];
    this->tailleMax=copie.tailleMax;
    this->nbElement=copie.nbElement;
    for(int i=0;i<this->nbElement;i++){
        this->tab[i]=copie.tab[i];
    }
};
Tableau::Tableau(int *v,int nb,int dim){ // Déconseillé
    this->tab=v;
    this->nbElement=nb;
    this->tailleMax;
}
Tableau::~Tableau(){
    delete[] this->tab;
};
