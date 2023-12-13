#ifndef DATE_H
#define DATE_H

#include <iostream>
#include <string>

class Date {
    int jour, mois, an;

public:
    Date(int j = 1, int m = 1, int an = 2016);
    int getJour() const;  // Ajout des accesseurs en lecture
    int getMois() const;  // Ajout des accesseurs en lecture
    int getAn() const;    // Ajout des accesseurs en lecture
    std::ostream& afficher(std::ostream&) const;
};

#endif // DATE_H
