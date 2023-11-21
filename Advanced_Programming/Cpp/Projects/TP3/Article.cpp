#include "Article.h"
#include <iostream>

using namespace std;

Article::Article() : Document(), numeroEdition(0) {}

Article::Article(const string& title, const string& summary, const string& author,
                 const string& revue, const string& editeur, int numeroEdition)
    : Document(title, summary, author), revue(revue), editeur(editeur), numeroEdition(numeroEdition) {}

Article::Article(const Article& other)
    : Document(other), revue(other.revue), editeur(other.editeur), numeroEdition(other.numeroEdition) {}

void Article::display() const {
    // Appele la fonction d'affichage de la classe de base (Document)
    Document::display();

    // Ajoute l'affichage des attributs spécifiques de Article
    cout << "Magazine: " << revue << endl;
    cout << "Editor: " << editeur << endl;
    cout << "Issue Number: " << numeroEdition << endl;
}

Article Article::clone() const {
    // Appele la fonction de clonage de la classe de base (Document)
    Article cloned(*this);
    // Pas besoin de copier les attributs spécifiques, cela est déjà fait par le constructeur de copie
    return cloned;
}

Article& Article::operator=(const Article& other) {
    if (this != &other) {  // Vérification contre l'auto-attribution
        // Appelle l'opérateur d'affectation de la classe de base
        Document::operator=(other);
        // Copie les membres spécifiques de Article
        revue = other.revue;
        editeur = other.editeur;
        numeroEdition = other.numeroEdition;
    }
    return *this;
}
