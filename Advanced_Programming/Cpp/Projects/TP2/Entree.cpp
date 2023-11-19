#include "Entree.h"
#include <iostream>

using namespace std;

// Constructeur
Entree::Entree(const string& nom, const string& numéroDeTéléphone) : m_nom(nom), m_numéroDeTéléphone(numéroDeTéléphone) {}

// Méthode d'affichage
void Entree::afficher() const {
    cout << "Nom : " << m_nom << endl;
    cout << "Numéro de téléphone : " << m_numéroDeTéléphone << endl;
}

// Accesseur pour le nom
string Entree::getNom() const {
    return m_nom;
}

// Accesseur pour le numéro de téléphone
string Entree::getNuméroDeTéléphone() const {
    return m_numéroDeTéléphone;
}

bool Entree::operator==(const Entree& autre) const {
    // Compare le nom et le numéro de téléphone pour déterminer l'égalité
    return (m_nom == autre.m_nom) && (m_numéroDeTéléphone == autre.m_numéroDeTéléphone);
}

bool Entree::operator!=(const Entree& autre) const {
    // Compare le nom et le numéro de téléphone pour déterminer l'égalité
    return (m_nom != autre.m_nom) && (m_numéroDeTéléphone != autre.m_numéroDeTéléphone);
}
