#include "Document.h"
#include "Livre.h"  // Ajoutez l'inclusion de Livre.h si nécessaire
#include "Article.h"  // Ajoutez l'inclusion de Article.h si nécessaire
#include <iostream>

using namespace std;

Document::Document() : summary(nullptr) {}

Document::Document(const string& title, const string& summary, const string& author)
    : title(title), summary(new string(summary)), author(author) {}

Document::Document(const Document& other)
    : title(other.title), summary(new string(*other.summary)), author(other.author) {}

Document::~Document() {
    delete summary;
}

void Document::display() const {
    cout << "Title: " << title << endl;
    cout << "Summary: " << *summary << endl;
    cout << "Author: " << author << endl;
}

Document& Document::operator=(const Document& other) {
    if (this != &other) {  // Vérification contre l'auto-attribution
        // Copie les membres de other dans this
        title = other.title;
        delete summary;  // Supprime le résumé existant
        summary = new string(*other.summary);  // Crée un nouveau résumé
        author = other.author;
    }
    return *this;
}

string Document::getTitle() const {
    return title;
}


/*=======================================================
Modification pour la partie 2 - Notion de classe abstraite  
=========================================================*/

// Correction/Adaptation de la méthode clone
Document* Document::clone() const {
    // Utilisation des classes dérivées pour créer une instance
    // appropriée en fonction du type réel de l'objet actuel

    // Par exemple, si l'objet actuel est un Livre, créez un nouveau Livre
    if (dynamic_cast<const Livre*>(this) != nullptr) {
        return new Livre(*dynamic_cast<const Livre*>(this));
    }
    // Sinon, si l'objet actuel est un Article, créez un nouveau Article
    else if (dynamic_cast<const Article*>(this) != nullptr) {
        return new Article(*dynamic_cast<const Article*>(this));
    }
    // On peut ajouter d'autres classes dérivées si nécessaire
    // ...

    // Si l'objet actuel n'est d'aucun type connu, on renvoie nullptr
    return nullptr;
}