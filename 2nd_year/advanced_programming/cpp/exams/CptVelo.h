#ifndef CPTVELO_H
#define CPTVELO_H

#include "Compteur.h"
#include "Velo.h"

class CptVelo : public Compteur {
    Velo* tableauVelos; // Tableau dynamique de vélo
    int nombreVelos;    // Nombre actuel de voitures dans le tableau
    int capaciteMax;    // Capacité maximale du tableau

public:
    CptVelo(Lieu* lieu, int capaciteInitiale = 10);
    CptVelo(const CptVelo& autreCptVelo);
    ~CptVelo();
    CptVelo& operator=(const CptVelo& autreCptVelo);
    CptVelo& operator+(const Velo& velo);

    virtual int getNombre(const Date& date, const Creneau& creneau) const override;
    virtual void afficherDonnees(const Date& date) const override;
    virtual Compteur* cloner() const override;
};

#endif // CPTVELO_H
