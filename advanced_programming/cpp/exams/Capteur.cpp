#include "Capteur.h"

Capteur::Capteur(const Lieu& lieu, int capaciteInitiale) : lieu(lieu), taille(0), capacite(capaciteInitiale) {
    tableCompteurs = new Compteur*[capacite];
}

Capteur::~Capteur() {
    for (int i = 0; i < taille; ++i) {
        delete tableCompteurs[i];
    }
    delete[] tableCompteurs;
}

void Capteur::ajouterCompteur(Compteur* compteur) {
    if (taille == capacite) {
        // Si le tableau est plein, augmenter la capacité de 1
        capacite += 1;
        Compteur** nouveauTableau = new Compteur*[capacite];
        for (int i = 0; i < taille; ++i) {
            nouveauTableau[i] = tableCompteurs[i];
        }
        delete[] tableCompteurs;
        tableCompteurs = nouveauTableau;
    }

    tableCompteurs[taille++] = compteur;
}

void Capteur::afficherDonnees(const Date& date) const {
    for (int i = 0; i < taille; ++i) {
        tableCompteurs[i]->afficherDonnees(date);
    }
}
