#include "Agenda.h"
#include <iostream>

using namespace std;

// Constructeur
Agenda::Agenda(int tailleMax) : m_tableau(tailleMax) {}

// Constructeur par copie
Agenda::Agenda(const Agenda& autreAgenda) : m_tableau(autreAgenda.m_tableau) {}

// Concaténation de deux agendas
Agenda Agenda::concat(const Agenda& autreAgenda) const {
    int nouvelleTailleMax = m_tableau.getTaille() + autreAgenda.m_tableau.getTaille();
    Agenda nouvelAgenda(nouvelleTailleMax);

    // Copie des entrées du premier agenda
    for (int i = 0; i < m_tableau.getNbElem(); i++) {
        const Entree& entrée = m_tableau.getEntree(i);
        nouvelAgenda.ajouter(entrée.getNom(), entrée.getNuméroDeTéléphone());
    }

    // Copie des entrées du deuxième agenda
    for (int i = 0; i < autreAgenda.m_tableau.getNbElem(); i++) {
        const Entree& entrée = autreAgenda.m_tableau.getEntree(i);
        nouvelAgenda.ajouter(entrée.getNom(), entrée.getNuméroDeTéléphone());
    }

    return nouvelAgenda;
}

// Ajouter une entrée à l'agenda
void Agenda::ajouter(const string& nom, const string& numéroDeTéléphone) {
    m_tableau.ajouter(nom, numéroDeTéléphone);
}

// Supprimer une entrée en spécifiant un nom et un numéro de téléphone
void Agenda::supprimer(const string& nom, const string& numéroDeTéléphone) {
    m_tableau.supprimer(nom, numéroDeTéléphone);
}

// Supprimer toutes les entrées correspondant à un nom
void Agenda::supprimer(const string& nom) {
    m_tableau.supprimer(nom);
}

// Méthode d'affichage
void Agenda::afficher() const {
    m_tableau.afficher();
}
