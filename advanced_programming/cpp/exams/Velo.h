#ifndef VELO_H
#define VELO_H

#include "Date.h"
#include "Horaire.h"
#include "Creneau.h"

class Velo {
    float vitesse;
    Date datePassage;
    Horaire horairePassage;

public:
    Velo(float vitesse, const Date& datePassage, const Horaire& horairePassage);
    Velo(); // Ajout du constructeur par défaut
    bool estDansCreneau(const Date& date, const Creneau& creneau) const;
};

#endif // VELO_H
