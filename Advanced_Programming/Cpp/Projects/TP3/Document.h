#ifndef DOCUMENT_H
#define DOCUMENT_H

#include <string>

using namespace std;

class Document {
private:
    string title;
    string* summary;
    string author;

public:
    Document();
    Document(const string& title, const string& summary, const string& author);
    Document(const Document& other);
    virtual ~Document();  // On déclare le destructeur comme virtuel

    virtual void display() const;
    Document clone() const;

    // Opérateur d'affectation
    Document& operator=(const Document& other);
};

#endif // DOCUMENT_H
