#ifndef LIVRE_H
#define LIVRE_H

#include "Document.h"

class Livre : public Document {
private:
    std::string editeur;
    int anneeParution;

public:
    Livre();
    Livre(const std::string& title, const std::string& summary, const std::string& author,
          const std::string& editeur, int anneeParution);
    Livre(const Livre& other);

    void display() const override;  // Utiliser l'annotation override
    Livre clone() const;

    // Opérateur d'affectation
    Livre& operator=(const Livre& other);
};

#endif // LIVRE_H
