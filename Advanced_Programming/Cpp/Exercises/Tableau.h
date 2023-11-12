#include <iostream>

using namespace std;

class Tableau{
    private:
        int *tab;
        int tailleMax;
        int nbElement;

    public:
        Tableau(int taille=0);
        Tableau(Tableau &copie);
        Tableau(int *v,int nb,int dim);	//Déconseillé
        ~Tableau();
};
