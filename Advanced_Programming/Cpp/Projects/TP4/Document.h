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
    virtual ~Document();  // Déclaration du destructeur comme virtuel

    virtual void display() const;

    // Opérateur d'affectation
    Document& operator=(const Document& other);

    // Getteur pour la classe Biblio
    string getTitle() const;
    

    /*=======================================================
    Modification pour la partie 2 - Notion de classe abstraite  
    =========================================================*/

    // Ajout de la fonction virtuelle pure
    virtual double calculateCost() const = 0;

    // Déclaration de la fonction clone comme virtuelle pure
    virtual Document* clone() const = 0;
};

#endif // DOCUMENT_H
