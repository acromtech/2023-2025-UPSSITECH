#ifndef BIBLIO_H
#define BIBLIO_H

#include <list>
#include "Document.h"

using namespace std;

class Biblio {
private:
    list<Document*> tab;

public:
    void ajouter(Document* D);
    Document* rechercher(const string& T);
    void afficher();
};

#endif // BIBLIO_H
