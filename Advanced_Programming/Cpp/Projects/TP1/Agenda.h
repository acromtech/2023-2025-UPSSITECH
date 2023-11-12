#ifndef AGENDA_H
#define AGENDA_H

#include "Tableau.h"

using namespace std;

class Agenda {
public:
    // Constructeur
    Agenda(int tailleMax);

    // Constructeur par copie
    Agenda(const Agenda& autreAgenda);

    // Concaténation de deux agendas
    Agenda concat(const Agenda& autreAgenda) const;

    // Ajouter une entrée à l'agenda
    void ajouter(const string& nom, const string& numéroDeTéléphone);

    // Supprimer une entrée en spécifiant un nom et un numéro de téléphone
    void supprimer(const string& nom, const string& numéroDeTéléphone);

    // Supprimer toutes les entrées correspondant à un nom
    void supprimer(const string& nom);

    // Méthode d'affichage
    void afficher() const;

private:
    Tableau m_tableau;
};

#endif // AGENDA_H
