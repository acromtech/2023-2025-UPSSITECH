#ifndef TABLEAU_H
#define TABLEAU_H

#include "Entree.h"

using namespace std;

class Tableau {
public:
    // Constructeur
    Tableau(int tailleMax);
    
    // Destructeur
    ~Tableau();
    
    // Constructeur par copie
    Tableau(const Tableau& autreTableau);
    
    // Méthode d'affichage
    void afficher() const;

    // Ajouter une entrée (nom et numéro de téléphone)
    void ajouter(const string& nom, const string& numéroDeTéléphone);

    // Supprimer une entrée en spécifiant un nom et un numéro de téléphone
    void supprimer(const string& nom, const string& numéroDeTéléphone);

    // Supprimer toutes les entrées correspondant à un nom
    void supprimer(const string& nom);

    // Méthodes d'accès en lecture
    int getTaille() const;
    int getNbElem() const;
    int getIndice(const string& nom) const;

    // Méthode pour obtenir une entrée à partir de son index (const)
    const Entree& getEntree(int index) const;

    // Opérateur d'égalité (const)
    bool operator==(const Tableau& autreTableau) const;

private:
    int m_tailleMax;
    Entree* m_tableau;
    int m_nbElem;
};

#endif // TABLEAU_H
