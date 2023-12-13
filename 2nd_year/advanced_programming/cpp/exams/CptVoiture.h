#ifndef CPTVOITURE_H
#define CPTVOITURE_H

#include "Compteur.h"
#include "Voiture.h"

class CptVoiture : public Compteur {
    Voiture* voitures;  // Tableau dynamique de voitures
    int nombreVoitures; // Nombre actuel de voitures dans le tableau
    int capaciteMax;    // Capacité maximale du tableau

public:
    CptVoiture(Lieu* lieu, int capaciteMax = 10);  // Constructeur avec paramètres
    CptVoiture(const CptVoiture& autre);           // Constructeur copie
    ~CptVoiture();                                // Destructeur
    CptVoiture& operator=(const CptVoiture& autre); // Opérateur d'affectation

    // Méthode héritée de Compteur
    virtual int getNombre(const Date& date, const Creneau& creneau) const override;
    virtual void afficherDonnees(const Date& date) const override;
    virtual Compteur* cloner() const override;

    // Méthode spécifique à CptVoiture
    CptVoiture& operator+(const Voiture& nouvelleVoiture); // Opérateur + pour ajouter une voiture au tableau
};

#endif // CPTVOITURE_H
