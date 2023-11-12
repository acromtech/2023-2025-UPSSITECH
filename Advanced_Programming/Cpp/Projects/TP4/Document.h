#ifndef DOCUMENT_H
#define DOCUMENT_H

#include <string>

class Document {
private:
    std::string title;
    std::string* summary;
    std::string author;

public:
    Document();
    Document(const std::string& title, const std::string& summary, const std::string& author);
    Document(const Document& other);
    virtual ~Document();  // Déclarer le destructeur comme virtuel

    virtual void display() const;
    Document clone() const;

    // Opérateur d'affectation
    Document& operator=(const Document& other);

    // Getteur pour la classe Biblio
    std::string getTitle() const;
};

#endif // DOCUMENT_H
