#include "Creneau.h"

Creneau::Creneau(int h1, int h2) : heure1(h1), heure2(h2) {
    // Initialiser d'autres membres si nécessaire
}

int Creneau::getHeure1() const {
    return heure1;
}

int Creneau::getHeure2() const {
    return heure2;
}

std::ostream& Creneau::afficher(std::ostream& out) const {
    out << "Créneau horaire : " << heure1 << "h - " << heure2 << "h";
    return out;
}
