#include "Voiture.h"

Voiture::Voiture(float vitesse, const Date& datePassage, const Horaire& horairePassage) : 
    vitesse(vitesse), 
    datePassage(datePassage), 
    horairePassage(horairePassage) {
}

Voiture::Voiture() : vitesse(0.0), datePassage(), horairePassage() {
}

bool Voiture::estDansCreneau(const Date& date, const Creneau& creneau) const {
    // Comparaison de la date
    if (datePassage.getJour() != date.getJour() || datePassage.getMois() != date.getMois() || datePassage.getAn() != date.getAn()) {
        return false;  // Les dates ne correspondent pas
    }

    // Comparaison de l'heure avec le créneau
    if (horairePassage.estDans(creneau)) {
        return false;  // L'heure n'est pas dans le créneau
    }

    // Si les deux conditions précédentes sont satisfaites, la voiture est dans le créneau
    return true;
}

