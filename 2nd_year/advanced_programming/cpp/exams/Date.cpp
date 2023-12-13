#include "Date.h"

Date::Date(int j, int m, int an) : jour(j), mois(m), an(an) {
}

int Date::getJour() const {
    return jour;
}

int Date::getMois() const {
    return mois;
}

int Date::getAn() const {
    return an;
}

std::ostream& Date::afficher(std::ostream& out) const {
    out << jour << "/" << mois << "/" << an;
    return out;
}
