#ifndef CAPTEUR_H
#define CAPTEUR_H

#include "Lieu.h"
#include "Compteur.h"

class Capteur {
    Lieu lieu;
    Compteur** tableCompteurs;
    int taille;
    int capacite;

public:
    Capteur(const Lieu& lieu, int capaciteInitiale = 10);
    ~Capteur();

    void ajouterCompteur(Compteur* compteur);
    void afficherDonnees(const Date& date) const;
};

#endif // CAPTEUR_H
