#include "Compte.h"
#include <iostream>

using namespace std;

Compte::Compte(){
    this->sold=0;
};
void Compte::depot(float val){
    this->sold+=val;
};
void Compte::retrait(float val){
    this->sold-=val;
};
void Compte::printSold(){
    cout<<"Sold="<<this->sold<<endl;
};
float Compte::getSold(){
    return this->sold;
};
void Compte::virement(Compte& c, float val){
    c.retrait(val);
    this->depot(val);
};
