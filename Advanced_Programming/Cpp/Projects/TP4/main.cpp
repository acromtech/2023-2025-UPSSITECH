#include <iostream>
#include "Document.h"
#include "Biblio.h"
#include "Livre.h"
#include "Article.h"

int main() {
    Biblio bibliotheque;

    // Création de quelques documents
    Document doc1("C++ Programming", "Introduction to C++ programming language.", "John Doe");
    Livre livre1("The C++ Programming Language", "A classic book on C++.", "Bjarne Stroustrup", "Addison-Wesley", 1985);
    Article article1("Magazine Title", "Summary of the article.", "Jane Doe", "Tech Magazine", "Tech Publications", 123);

    // Ajout des documents à la bibliothèque
    bibliotheque.ajouter(&doc1);
    bibliotheque.ajouter(&livre1);
    bibliotheque.ajouter(&article1);

    // Recherche et affichage d'un document par titre
    Document* docTrouve = bibliotheque.rechercher("The C++ Programming Language");
    if (docTrouve != nullptr) {
        std::cout << "Document trouvé : ";
        docTrouve->display();
    } else {
        std::cout << "Aucun document trouvé avec le titre spécifié.\n";
    }

    // Affichage du contenu de la bibliothèque
    bibliotheque.afficher();

    return 0;
}
