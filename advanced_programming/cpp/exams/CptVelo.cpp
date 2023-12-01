#include "CptVelo.h"

CptVelo::CptVelo(Lieu* lieu, int capaciteMax) : Compteur(lieu), capaciteMax(capaciteMax), nombreVelos(0) {
    tableauVelos = new Velo[capaciteMax];
    // Initialiser d'autres membres si nécessaire
}

CptVelo::CptVelo(const CptVelo& autre) : Compteur(autre), capaciteMax(autre.capaciteMax), nombreVelos(autre.nombreVelos) {
    tableauVelos = new Velo[capaciteMax];
    for (int i = 0; i < nombreVelos; ++i) {
        tableauVelos[i] = autre.tableauVelos[i];
    }
    // Copier d'autres membres si nécessaire
}

CptVelo::~CptVelo() {
    delete[] tableauVelos;
}

CptVelo& CptVelo::operator=(const CptVelo& autre) {
    if (this != &autre) {
        delete[] tableauVelos;
        capaciteMax = autre.capaciteMax;
        nombreVelos = autre.nombreVelos;
        tableauVelos = new Velo[capaciteMax];
        for (int i = 0; i < nombreVelos; ++i) {
            tableauVelos[i] = autre.tableauVelos[i];
        }
    }
    return *this;
}

int CptVelo::getNombre(const Date& date, const Creneau& creneau) const {
    int nombreVeloDansCreneau = 0;
    for (int i = 0; i < nombreVelos; ++i) {
        if (tableauVelos[i].estDansCreneau(date, creneau)) {
            // Si le vélo est dans le créneau, incrémenter le nombre de vélos
            ++nombreVeloDansCreneau;
        }
    }
    return nombreVeloDansCreneau;
}


void CptVelo::afficherDonnees(const Date& date) const {
    cout << "Données des compteurs de vélos pour la date : ";
    date.afficher(cout);
    cout << endl;

    for (int i = 0; i < nombreVelos; ++i) {
        cout << "Compteur " << i + 1 << ": " << getNombre(date, Creneau()) << " vélos dans le créneau." << endl;
    }
}

CptVelo& CptVelo::operator+(const Velo& nouveauVelo) {
    if (nombreVelos < capaciteMax) {
        tableauVelos[nombreVelos++] = nouveauVelo;
    } else {
        throw std::overflow_error("Capacité maximale atteinte pour le tableau de vélos.");
    }
    return *this;
}

