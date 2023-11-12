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

    // Ajouter une Entree à l'agenda
    void ajouter(const string& nom, const string& numéroDeTéléphone);

    // Supprimer une Entree en spécifiant un nom et un numéro de téléphone
    void supprimer(const string& nom, const string& numéroDeTéléphone);

    // Supprimer toutes les Entrees correspondant à un nom
    void supprimer(const string& nom);

    // Méthode d'affichage
    void afficher() const;

    // Destructeur
    ~Agenda();

    // Concaténation de deux agendas
    Agenda operator+(const Agenda& autreAgenda) const;

    // Concaténation d'un agenda avec un autre
    Agenda& operator+=(const Agenda& autreAgenda);

    // Ajout d'une Entree à l'agenda
    Agenda& operator+=(const Entree& Entree);

    // Opérateur de copie
    Agenda& operator=(const Agenda& autreAgenda);

    // Opérateur [] pour rechercher une Entree par nom
    const Entree& operator[](const std::string& nom) const;

    // Suppression de toutes les occurrences d'un nom
    Agenda& operator-=(const std::string& nom);

    // Comparaison d'agendas
    bool operator==(const Agenda& autreAgenda) const;
    bool operator!=(const Agenda& autreAgenda) const;

    // Vérification de la présence d'un nom dans l'agenda
    bool operator()(const std::string& nom) const;

    // Affichage des noms commençant par une lettre donnée
    void operator()(char lettre) const;

    // Affichage de l'agenda
    friend std::ostream& operator<<(std::ostream& os, const Agenda& agenda);

private:
    Tableau m_tableau;
};

#endif // AGENDA_H
