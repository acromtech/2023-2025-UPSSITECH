#ifndef HORAIRE_H
#define HORAIRE_H

#include <iostream>
#include <string>
#include "Creneau.h"

class Horaire {
    int heure, minute, seconde;

public:
    Horaire(int h = 0, int m = 0, int s = 0);
    int getHeure() const;    // Ajout des accesseurs en lecture
    int getMinute() const;   // Ajout des accesseurs en lecture
    int getSeconde() const;  // Ajout des accesseurs en lecture
    bool estDans(Creneau) const; // teste si l’horaire est dans le créneau horaire donné
    std::ostream& afficher(std::ostream&) const;
};

#endif // HORAIRE_H
