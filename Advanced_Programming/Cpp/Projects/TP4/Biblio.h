#ifndef BIBLIO_H
#define BIBLIO_H

#include <list>
#include "Document.h"

class Biblio {
private:
    std::list<Document*> tab;

public:
    void ajouter(Document* D);
    Document* rechercher(const std::string& T);
    void afficher();
};

#endif // BIBLIO_H
