#ifndef VOITURE_H
#define VOITURE_H

#include "Date.h"
#include "Horaire.h"
#include "Creneau.h"

class Voiture {
    float vitesse;
    Date datePassage;
    Horaire horairePassage;

public:
    Voiture(float vitesse, const Date& datePassage, const Horaire& horairePassage);
    Voiture(); // Ajout du constructeur par défaut
    bool estDansCreneau(const Date& date, const Creneau& creneau) const;
};

#endif // VOITURE_H
