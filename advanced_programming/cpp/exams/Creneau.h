#ifndef CRENEAU_H
#define CRENEAU_H

#include <iostream>
#include <string>

using namespace std;

class Creneau {
    int heure1, heure2;

public:
    Creneau(int h1 = 10, int h2 = 12);
    int getHeure1() const;
    int getHeure2() const;
    ostream& afficher(ostream& out) const;
};

#endif // CRENEAU_H
