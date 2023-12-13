#ifndef LIEU_H
#define LIEU_H

#include <iostream>
#include <string>
#include "CoordGPS.h"

using namespace std;

class Lieu {
    string nom;
    CoordGPS coordonnees;

public:
    Lieu(string nom, CoordGPS coordonnees);
    void afficher(ostream& out) const;
};

#endif // LIEU_H
