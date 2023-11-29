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

    void display() const override;  // On iutilise l'annotation override
    Livre clone() const;

    // Opérateur d'affectation
    Livre& operator=(const Livre& other);
};

#endif // LIVRE_H
