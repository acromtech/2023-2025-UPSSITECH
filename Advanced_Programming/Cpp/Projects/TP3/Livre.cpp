#include "Livre.h"
#include <iostream>

using namespace std;

Livre::Livre() : Document(), anneeParution(0) {}

Livre::Livre(const string& title, const string& summary, const string& author,
             const string& editeur, int anneeParution)
    : Document(title, summary, author), editeur(editeur), anneeParution(anneeParution) {}

Livre::Livre(const Livre& other)
    : Document(other), editeur(other.editeur), anneeParution(other.anneeParution) {}

void Livre::display() const {
    // Appele la fonction d'affichage de la classe de base (Document)
    Document::display();

    // Ajoute l'affichage des attributs spécifiques de Livre
    cout << "Editor: " << editeur << endl;
    cout << "Publication Year: " << anneeParution << endl;
}

Livre Livre::clone() const {
    Livre cloned(*this);  // Utilise le constructeur de copie de Livre
    // Pas besoin de copier les attributs spécifiques, cela est déjà fait par le constructeur de copie
    return cloned;
}

Livre& Livre::operator=(const Livre& other) {
    if (this != &other) {  // Vérification contre l'auto-attribution
        // Appelle l'opérateur d'affectation de la classe de base
        Document::operator=(other);

        // Copie les membres spécifiques de Livre
        editeur = other.editeur;
        anneeParution = other.anneeParution;
    }
    return *this;
}
