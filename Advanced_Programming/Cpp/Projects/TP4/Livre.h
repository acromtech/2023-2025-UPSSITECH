#ifndef LIVRE_H
#define LIVRE_H

#include "Document.h"

using namespace std;

class Livre : public Document {
private:
    string editeur;
    int anneeParution;

public:
    Livre();
    Livre(const string& title, const string& summary, const string& author,
          const string& editeur, int anneeParution);
    Livre(const Livre& other);

    void display() const override;  // On utilise l'annotation override

    // Opérateur d'affectation
    Livre& operator=(const Livre& other);
    
    
    /*=======================================================
    Modification pour la partie 2 - Notion de classe abstraite  
    =========================================================*/

    // Implémentation de la fonction calculateCost pour Livre
    double calculateCost() const override;

    // Correction de la signature de clone
    Livre* clone() const override;
};

#endif // LIVRE_H
