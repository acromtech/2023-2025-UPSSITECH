#include "Biblio.h"
#include <iostream>

void Biblio::ajouter(Document* D) {
    tab.push_back(D);
}

Document* Biblio::rechercher(const std::string& T) {
    for (Document* doc : tab) {
        if (doc->getTitle() == T) {
            return doc;
        }
    }
    return nullptr;
}

void Biblio::afficher() {
    std::cout << "Contenu de la bibliothèque :\n";
    for (Document* doc : tab) {
        doc->display();
        std::cout << "---------------------\n";
    }
}
