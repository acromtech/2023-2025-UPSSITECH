#include "Document.h"
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

Document Document::clone() const {
    return Document(*this);
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
