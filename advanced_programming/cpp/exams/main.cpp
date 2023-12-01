#include "Capteur.h"
#include "CptVoiture.h"
#include "CptVelo.h"
#include "Date.h"
#include "Creneau.h"

int main() {
    // Création des lieux
    Lieu site1("Site 1", CoordGPS(0.0, 0.0));
    Lieu site2("Site 2", CoordGPS(1.0, 1.0));

    // Création des capteurs
    Capteur capteurVoitures(site1);
    Capteur capteurVelos(site2);

    // Création des compteurs spécifiques
    CptVoiture compteurVoitures(&site1);
    CptVelo compteurVelos(&site2);

    // Ajout des compteurs aux capteurs
    capteurVoitures.ajouterCompteur(&compteurVoitures);
    capteurVelos.ajouterCompteur(&compteurVelos);

    // Simulation de passages de voitures
    Voiture voiture1(60.0, Date(30, 11, 2023), Horaire(10, 30, 0));
    Voiture voiture2(55.0, Date(30, 11, 2023), Horaire(12, 15, 0));
    Voiture voiture3(70.0, Date(30, 11, 2023), Horaire(14, 45, 0));

    // Ajout des voitures au compteur de voitures
    compteurVoitures + voiture1;
    compteurVoitures + voiture2;
    compteurVoitures + voiture3;

    // Simulation de passages de vélos
    Velo velo1(10.0, Date(30, 11, 2023), Horaire(11, 0, 0));
    Velo velo2(12.0, Date(30, 11, 2023), Horaire(13, 30, 0));
    Velo velo3(18.0, Date(30, 11, 2023), Horaire(16, 0, 0));

    // Ajout des vélos au compteur de vélos
    compteurVelos + velo1;
    compteurVelos + velo2;
    compteurVelos + velo3;

    // Affichage des données à une date donnée
    Date dateTest(30, 11, 2023);
    capteurVoitures.afficherDonnees(dateTest);
    capteurVelos.afficherDonnees(dateTest);

    return 0;
}
