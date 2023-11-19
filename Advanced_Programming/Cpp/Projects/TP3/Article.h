#ifndef ARTICLE_H
#define ARTICLE_H

#include "Document.h"

class Article : public Document {
private:
    std::string revue;
    std::string editeur;
    int numeroEdition;

public:
    Article();
    Article(const std::string& title, const std::string& summary, const std::string& author,
            const std::string& revue, const std::string& editeur, int numeroEdition);
    Article(const Article& other);

    void display() const override;
    Article clone() const;

    // Opérateur d'affectation
    Article& operator=(const Article& other);
};

#endif // ARTICLE_H
