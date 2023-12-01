#include "Lieu.h"

using namespace std;

Lieu::Lieu(string nom, CoordGPS coordonnees): nom(nom), coordonnees(coordonnees){
}

void Lieu::afficher(std::ostream& out) const {
    out << "Nom: " << nom << ", Coordonnées: ";
    coordonnees.afficher();
}