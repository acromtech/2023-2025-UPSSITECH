#include "Tableau.h"
#include <iostream>

using namespace std;

// Constructeur
Tableau::Tableau(int tailleMax) : m_tailleMax(tailleMax), m_tableau(new Entree[tailleMax]), m_nbElem(0) {}

// Destructeur
Tableau::~Tableau() {
    delete[] m_tableau;
}

// Constructeur par copie
Tableau::Tableau(const Tableau& autreTableau) : m_tailleMax(autreTableau.m_tailleMax), m_tableau(new Entree[autreTableau.m_tailleMax]), m_nbElem(autreTableau.m_nbElem) {
    for (int i = 0; i < m_nbElem; i++) {
        m_tableau[i] = autreTableau.m_tableau[i];
    }
}

// Méthode d'affichage
void Tableau::afficher() const {
    for (int i = 0; i < m_nbElem; i++) {
        m_tableau[i].afficher();
    }
}

// Ajouter une Entree
void Tableau::ajouter(const string& nom, const string& numéroDeTéléphone) {
    if (m_nbElem < m_tailleMax) {
        m_tableau[m_nbElem] = Entree(nom, numéroDeTéléphone);
        m_nbElem++;
    } else {
        cerr << "Tableau plein, impossible d'ajouter une nouvelle Entree." << endl;
    }
}

// Supprimer une Entree en spécifiant un nom et un numéro de téléphone
void Tableau::supprimer(const string& nom, const string& numéroDeTéléphone) {
    for (int i = 0; i < m_nbElem; i++) {
        if (m_tableau[i].getNom() == nom && m_tableau[i].getNuméroDeTéléphone() == numéroDeTéléphone) {
            for (int j = i; j < m_nbElem - 1; j++) {
                m_tableau[j] = m_tableau[j + 1];
            }
            m_nbElem--;
            break;
        }
    }
}

// Supprimer toutes les Entrees correspondant à un nom
void Tableau::supprimer(const string& nom) {
    int i = 0;
    while (i < m_nbElem) {
        if (m_tableau[i].getNom() == nom) {
            for (int j = i; j < m_nbElem - 1; j++) {
                m_tableau[j] = m_tableau[j + 1];
            }
            m_nbElem--;
        } else {
            i++;
        }
    }
}

// Méthodes d'accès en lecture
int Tableau::getTaille() const {
    return m_tailleMax;
}

int Tableau::getNbElem() const {
    return m_nbElem;
}

const Entree& Tableau::getEntree(int index) const {
    if (index >= 0 && index < m_nbElem) {
        return m_tableau[index];
    } else {
        // Gérer l'erreur ici (par exemple, renvoyer une valeur par défaut ou lancer une exception).
        // Dans cet exemple, nous renvoyons la première entrée.
        return m_tableau[0];
    }
}

