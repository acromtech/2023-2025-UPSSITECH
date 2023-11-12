#ifndef ENTREE_H
#define ENTREE_H

#include <string>

using namespace std;

class Entree {
public:
     // Constructeur par défaut
    Entree() : m_nom(""), m_numéroDeTéléphone("") {}

    // Constructeur
    Entree(const std::string& nom, const std::string& numéroDeTéléphone);

    // Méthode d'affichage
    void afficher() const;

    // Accesseurs pour le nom et le numéro de téléphone
    string getNom() const;
    string getNuméroDeTéléphone() const;

     // Opérateur pour comparer deux objets de type Entree
    bool operator==(const Entree& autre) const;
    bool operator!=(const Entree& autre) const;

private:
    string m_nom;
    string m_numéroDeTéléphone;
};

#endif // ENTREE_H
