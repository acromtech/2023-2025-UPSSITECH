#include "Livre.h"
#include <iostream>

Livre::Livre() : Document(), anneeParution(0) {}

Livre::Livre(const std::string& title, const std::string& summary, const std::string& author,
             const std::string& editeur, int anneeParution)
    : Document(title, summary, author), editeur(editeur), anneeParution(anneeParution) {}

Livre::Livre(const Livre& other)
    : Document(other), editeur(other.editeur), anneeParution(other.anneeParution) {}

void Livre::display() const {
    // Appeler la fonction d'affichage de la classe de base (Document)
    Document::display();

    // Ajouter l'affichage des attributs spécifiques de Livre
    std::cout << "Editor: " << editeur << std::endl;
    std::cout << "Publication Year: " << anneeParution << std::endl;
}

Livre Livre::clone() const {
    Livre cloned(*this);  // Utiliser le constructeur de copie de Livre

    // Pas besoin de copier les attributs spécifiques, cela est déjà fait par le constructeur de copie

    return cloned;
}

Livre& Livre::operator=(const Livre& other) {
    if (this != &other) {  // Vérification contre l'auto-attribution
        // Appel à l'opérateur d'affectation de la classe de base
        Document::operator=(other);

        // Copiez les membres spécifiques de Livre
        editeur = other.editeur;
        anneeParution = other.anneeParution;
    }
    return *this;
}
