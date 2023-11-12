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

    // Copie des Entrees du premier agenda
    for (int i = 0; i < m_tableau.getNbElem(); i++) {
        const Entree& Entree = m_tableau.getEntree(i);
        nouvelAgenda.ajouter(Entree.getNom(), Entree.getNuméroDeTéléphone());
    }

    // Copie des Entrees du deuxième agenda
    for (int i = 0; i < autreAgenda.m_tableau.getNbElem(); i++) {
        const Entree& Entree = autreAgenda.m_tableau.getEntree(i);
        nouvelAgenda.ajouter(Entree.getNom(), Entree.getNuméroDeTéléphone());
    }

    return nouvelAgenda;
}

// Ajouter une Entree à l'agenda
void Agenda::ajouter(const string& nom, const string& numéroDeTéléphone) {
    m_tableau.ajouter(nom, numéroDeTéléphone);
}

// Supprimer une Entree en spécifiant un nom et un numéro de téléphone
void Agenda::supprimer(const string& nom, const string& numéroDeTéléphone) {
    m_tableau.supprimer(nom, numéroDeTéléphone);
}

// Supprimer toutes les Entrees correspondant à un nom
void Agenda::supprimer(const string& nom) {
    m_tableau.supprimer(nom);
}

// Méthode d'affichage
void Agenda::afficher() const {
    m_tableau.afficher();
}

// Operateurs
Agenda Agenda::operator+(const Agenda& autreAgenda) const {
    int nouvelleTailleMax = m_tableau.getTaille() + autreAgenda.m_tableau.getTaille();
    Agenda nouvelAgenda(nouvelleTailleMax);

    for (int i = 0; i < m_tableau.getNbElem(); i++) {
        nouvelAgenda += m_tableau.getEntree(i);
    }

    for (int i = 0; i < autreAgenda.m_tableau.getNbElem(); i++) {
        nouvelAgenda += autreAgenda.m_tableau.getEntree(i);
    }

    return nouvelAgenda;
}

Agenda& Agenda::operator+=(const Agenda& autreAgenda) {
    for (int i = 0; i < autreAgenda.m_tableau.getNbElem(); i++) {
        *this += autreAgenda.m_tableau.getEntree(i);
    }
    return *this;
}

Agenda& Agenda::operator+=(const Entree& Entree) {
    m_tableau.ajouter(Entree.getNom(), Entree.getNuméroDeTéléphone());
    return *this;
}

Agenda& Agenda::operator=(const Agenda& autreAgenda) {
    if (this != &autreAgenda) {
        m_tableau = autreAgenda.m_tableau;
    }
    return *this;
}

const Entree& Agenda::operator[](const string& nom) const {
    int i = m_tableau.getIndice(nom);
    if (i != -1) {
        return m_tableau.getEntree(i);
    } else {
        throw std::runtime_error("Entry not found in Agenda");
    }
}


Agenda& Agenda::operator-=(const std::string& nom) {
    for (int i = 0; i < m_tableau.getNbElem(); i++) {
        if (m_tableau.getEntree(i).getNom() == nom) {
            m_tableau.supprimer(nom);
        }
    }
    return *this;
}

bool Agenda::operator==(const Agenda& autreAgenda) const {
    return m_tableau == autreAgenda.m_tableau;
}

bool Agenda::operator!=(const Agenda& autreAgenda) const {
    return !(*this == autreAgenda);
}

bool Agenda::operator()(const std::string& nom) const {
    for (int i = 0; i < m_tableau.getNbElem(); i++) {
        if (m_tableau.getEntree(i).getNom() == nom) {
            return true;
        }
    }
    return false;
}

void Agenda::operator()(char lettre) const {
    for (int i = 0; i < m_tableau.getNbElem(); i++) {
        if (m_tableau.getEntree(i).getNom()[0] == lettre) {
            std::cout << m_tableau.getEntree(i).getNom() << std::endl;
        }
    }
}

std::ostream& operator<<(std::ostream& os, const Agenda& agenda) {
    for (int i = 0; i < agenda.m_tableau.getNbElem(); i++) {
        os << "Nom : " << agenda.m_tableau.getEntree(i).getNom() << std::endl;
        os << "Numéro de téléphone : " << agenda.m_tableau.getEntree(i).getNuméroDeTéléphone() << std::endl;
    }
    return os;
}

// Destructeur
Agenda::~Agenda() {
}
