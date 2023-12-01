#include <iostream>
#include "Document.h"
#include "Livre.h"
#include "Article.h"
#include "Biblio.h"

using namespace std;

int main() {
    Biblio bibliotheque;

    Livre livre1("The C++ Programming Language", "A classic book on C++.", "Bjarne Stroustrup", "Addison-Wesley", 1985);
    Article article1("Magazine Title", "Summary of the article.", "Jane Doe", "Tech Magazine", "Tech Publications", 123);

    // Ajout des documents à la bibliothèque
    bibliotheque.ajouter(&livre1);
    bibliotheque.ajouter(&article1);

    // Recherche et affichage d'un document par titre
    Document* docTrouve = bibliotheque.rechercher("The C++ Programming Language");
    if (docTrouve != nullptr) {
        cout << "Document trouvé : ";
        docTrouve->display();
    } else {
        cout << "Aucun document trouvé avec le titre spécifié.\n";
    }

    // Affichage du contenu de la bibliothèque
    bibliotheque.afficher();

    // Calcul du coût pour Livre
    double costLivre = livre1.calculateCost();
    cout << "Cost of the book: " << costLivre << "\n";

    // Calcul du coût pour Article
    double costArticle = article1.calculateCost();
    cout << "Cost of the article: " << costArticle << "\n";

    return 0;
}
