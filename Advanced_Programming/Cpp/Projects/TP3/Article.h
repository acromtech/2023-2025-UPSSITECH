#ifndef ARTICLE_H
#define ARTICLE_H

#include "Document.h"

using namespace std;

class Article : public Document {
private:
    string revue;
    string editeur;
    int numeroEdition;

public:
    Article();
    Article(const string& title, const string& summary, const string& author,
            const string& revue, const string& editeur, int numeroEdition);
    Article(const Article& other);

    void display() const override;
    Article clone() const;

    // Opérateur d'affectation
    Article& operator=(const Article& other);
};

#endif // ARTICLE_H
