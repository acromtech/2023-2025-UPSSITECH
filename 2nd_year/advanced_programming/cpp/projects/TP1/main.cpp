#include <iostream>
#include "Entree.h"
#include "Tableau.h"
#include "Agenda.h"

using namespace std;

int main() {
    // Création d'entrées
    Entree entrée1("Alice", "123-456-7890");
    Entree entrée2("Bob", "987-654-3210");

    // Création d'un tableau
    Tableau tableau(10);

    // Ajout d'entrées au tableau
    tableau.ajouter("Charlie", "555-123-4567");
    tableau.ajouter("David", "111-222-3333");

    // Affichage du tableau
    cout << "Tableau d'entrées : " << endl;
    tableau.afficher();

    // Suppression d'une entrée par nom et numéro de téléphone
    tableau.supprimer("Charlie", "555-123-4567");

    // Affichage du tableau mis à jour
    cout << "Tableau d'entrées après suppression : " << endl;
    tableau.afficher();

    // Création de deux agendas
    Agenda agenda1(5);
    Agenda agenda2(5);

    // Ajout d'entrées aux agendas
    agenda1.ajouter("Eve", "777-888-9999");
    agenda2.ajouter("Frank", "444-555-6666");

    // Affichage des agendas
    cout << "Agenda 1 : " << endl;
    agenda1.afficher();
    cout << "Agenda 2 : " << endl;
    agenda2.afficher();

    // Concaténation des agendas
    Agenda agendaConcat = agenda1.concat(agenda2);

    // Affichage de l'agenda concaténé
    cout << "Agenda concaténé : " << endl;
    agendaConcat.afficher();

    return 0;
}
