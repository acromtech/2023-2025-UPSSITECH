#include "Document.h"
#include <iostream>

Document::Document() : summary(nullptr) {}

Document::Document(const std::string& title, const std::string& summary, const std::string& author)
    : title(title), summary(new std::string(summary)), author(author) {}

Document::Document(const Document& other)
    : title(other.title), summary(new std::string(*other.summary)), author(other.author) {}

Document::~Document() {
    delete summary;
}

void Document::display() const {
    std::cout << "Title: " << title << std::endl;
    std::cout << "Summary: " << *summary << std::endl;
    std::cout << "Author: " << author << std::endl;
}

Document Document::clone() const {
    return Document(*this);
}

Document& Document::operator=(const Document& other) {
    if (this != &other) {  // Vérification contre l'auto-attribution
        // Copiez les membres de other dans this
        title = other.title;
        delete summary;  // Supprimez le résumé existant
        summary = new std::string(*other.summary);  // Créez un nouveau résumé
        author = other.author;
    }
    return *this;
}

std::string Document::getTitle() const {
    return title;
}
