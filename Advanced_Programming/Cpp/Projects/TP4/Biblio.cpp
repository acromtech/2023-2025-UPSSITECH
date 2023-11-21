#include "Biblio.h"
#include <iostream>

using namespace std;

void Biblio::ajouter(Document* D) {
    tab.push_back(D);
}

Document* Biblio::rechercher(const string& T) {
    for (Document* doc : tab) {
        if (doc->getTitle() == T) {
            return doc;
        }
    }
    return nullptr;
}

void Biblio::afficher() {
    cout << "Contenu de la bibliothèque :\n";
    for (Document* doc : tab) {
        doc->display();
        cout << "---------------------\n";
    }
}
