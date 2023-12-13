#include "Horaire.h"

Horaire::Horaire(int h, int m, int s) : heure(h), minute(m), seconde(s) {
}

int Horaire::getHeure() const {
    return heure;
}

int Horaire::getMinute() const {
    return minute;
}

int Horaire::getSeconde() const {
    return seconde;
}

bool Horaire::estDans(Creneau creneau) const {
    // Implémentation de la méthode estDans
    // Compare l'heure avec les bornes du créneau horaire
    int heurePassage = getHeure();
    return (heurePassage >= creneau.getHeure1() && heurePassage <= creneau.getHeure2());
}

std::ostream& Horaire::afficher(std::ostream& out) const {
    out << heure << ":" << minute << ":" << seconde;
    return out;
}
