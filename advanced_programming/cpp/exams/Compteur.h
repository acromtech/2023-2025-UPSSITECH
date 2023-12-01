#ifndef COMPTEUR_H
#define COMPTEUR_H

#include <iostream>
#include "Lieu.h"
#include "Date.h"
#include "Creneau.h"

class Compteur {
    Lieu* lieuAssocie;

public:
    Compteur(Lieu* lieu);
    virtual ~Compteur();  // Ajout du destructeur virtuel
    virtual int getNombre(const Date& date, const Creneau& creneau) const = 0; // Méthode virtuelle pure
    virtual void afficherDonnees(const Date& date) const = 0; // Méthode virtuelle pure
    virtual Compteur* cloner() const = 0; // Méthode virtuelle pure
};

#endif // COMPTEUR_H
