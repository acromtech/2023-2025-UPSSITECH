#include "Velo.h"

Velo::Velo(float vitesse, const Date& datePassage, const Horaire& horairePassage) : 
    vitesse(vitesse), 
    datePassage(datePassage), 
    horairePassage(horairePassage) {
}

Velo::Velo() : vitesse(0.0), datePassage(), horairePassage() {
}

bool Velo::estDansCreneau(const Date& date, const Creneau& creneau) const {
    // Comparaison de la date
    if (datePassage.getJour() != date.getJour() || datePassage.getMois() != date.getMois() || datePassage.getAn() != date.getAn()) {
        return false;  // Les dates ne correspondent pas
    }
    // Comparaison de l'heure avec le créneau
    int heurePassage = horairePassage.getHeure();
    if (heurePassage < creneau.getHeure1() || heurePassage > creneau.getHeure2()) {
        return false;  // L'heure n'est pas dans le créneau
    }
    // Si les deux conditions précédentes sont satisfaites, le vélo est dans le créneau
    return true;
}
