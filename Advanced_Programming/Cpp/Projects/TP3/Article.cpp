#include "Article.h"
#include <iostream>

Article::Article() : Document(), numeroEdition(0) {}

Article::Article(const std::string& title, const std::string& summary, const std::string& author,
                 const std::string& revue, const std::string& editeur, int numeroEdition)
    : Document(title, summary, author), revue(revue), editeur(editeur), numeroEdition(numeroEdition) {}

Article::Article(const Article& other)
    : Document(other), revue(other.revue), editeur(other.editeur), numeroEdition(other.numeroEdition) {}

void Article::display() const {
    // Appeler la fonction d'affichage de la classe de base (Document)
    Document::display();

    // Ajouter l'affichage des attributs spécifiques de Article
    std::cout << "Magazine: " << revue << std::endl;
    std::cout << "Editor: " << editeur << std::endl;
    std::cout << "Issue Number: " << numeroEdition << std::endl;
}

Article Article::clone() const {
    // Appeler la fonction de clonage de la classe de base (Document)
    Article cloned(*this);

    // Pas besoin de copier les attributs spécifiques, cela est déjà fait par le constructeur de copie

    return cloned;
}

Article& Article::operator=(const Article& other) {
    if (this != &other) {  // Vérification contre l'auto-attribution
        // Appel à l'opérateur d'affectation de la classe de base
        Document::operator=(other);

        // Copiez les membres spécifiques de Article
        revue = other.revue;
        editeur = other.editeur;
        numeroEdition = other.numeroEdition;
    }
    return *this;
}
