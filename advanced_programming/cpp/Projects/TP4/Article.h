#ifndef ARTICLE_H
#define ARTICLE_H

#include "Document.h"

using namespace std;

class Article : public Document {
private:
    string revue;
    string editeur;
    int numeroEdition;

public:
    Article();
    Article(const string& title, const string& summary, const string& author,
            const string& revue, const string& editeur, int numeroEdition);
    Article(const Article& other);

    void display() const override;

    // Opérateur d'affectation
    Article& operator=(const Article& other);


    /*=======================================================
    Modification pour la partie 2 - Notion de classe abstraite  
    =========================================================*/

    // Implémentation de la fonction calculateCost pour Article
    double calculateCost() const override;

    // Correction de la signature de clone
    Article* clone() const override;
};

#endif // ARTICLE_H
