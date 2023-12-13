#include "CptVoiture.h"

CptVoiture::CptVoiture(Lieu* lieu, int capaciteMax) : Compteur(lieu), capaciteMax(capaciteMax), nombreVoitures(0) {
    voitures = new Voiture[capaciteMax];
}

CptVoiture::CptVoiture(const CptVoiture& autre) : Compteur(autre), capaciteMax(autre.capaciteMax), nombreVoitures(autre.nombreVoitures) {
    voitures = new Voiture[capaciteMax];
    for (int i = 0; i < nombreVoitures; ++i) {
        voitures[i] = autre.voitures[i];
    }
}

CptVoiture::~CptVoiture() {
    delete[] voitures;
}

CptVoiture& CptVoiture::operator=(const CptVoiture& autre) {
    if (this != &autre) {
        delete[] voitures;
        capaciteMax = autre.capaciteMax;
        nombreVoitures = autre.nombreVoitures;
        voitures = new Voiture[capaciteMax];
        for (int i = 0; i < nombreVoitures; ++i) {
            voitures[i] = autre.voitures[i];
        }
    }
    return *this;
}

int CptVoiture::getNombre(const Date& date, const Creneau& creneau) const {
    int nombreVoitureDansCreneau = 0;
    for (int i = 0; i < nombreVoitures; ++i) {
        if (voitures[i].estDansCreneau(date, creneau)) {
            // Si la voiture est dans le créneau, incrémenter le nombre de voitures
            ++nombreVoitureDansCreneau;
        }
    }
    return nombreVoitureDansCreneau;
}


void CptVoiture::afficherDonnees(const Date& date) const {
    cout << "Données des compteurs de voitures pour la date : ";
    date.afficher(cout);
    cout << endl;

    for (int i = 0; i < nombreVoitures; ++i) {
        cout << "Compteur " << i + 1 << ": " << getNombre(date, Creneau()) << " voitures dans le créneau." << endl;
    }
}


CptVoiture& CptVoiture::operator+(const Voiture& nouvelleVoiture) {
    if (nombreVoitures < capaciteMax) {
        voitures[nombreVoitures++] = nouvelleVoiture;
    } else {
        throw std::overflow_error("Capacité maximale atteinte pour le tableau de voitures.");
    }
    return *this;
}
