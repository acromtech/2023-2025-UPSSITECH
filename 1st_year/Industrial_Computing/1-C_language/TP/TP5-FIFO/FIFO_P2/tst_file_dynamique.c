#include <stdio.h>
#include "file_dynamique.h"

int main()
{
	/*------------------------------
	Programme de la caisse de cinema
	Sortie : 
		- Nombre de tickets vendus
		- Valeur de la caisse
	------------------------------*/
	int ticket=0,caisse=0; // en debut de journee, la caisse est vide
	MA_FILE seance[NB_SEANCE]; // chaque séance correspond a une file de client
	ELEMENT elm;

	for(int i=0;i<NB_SEANCE;i++){ // pour chaque seance
		printf("\n\rSEANCE %d : ",i+1);
		seance[i]=SAISIR_FILE(); // saisir la file de client (nb_tickets + prix)
		AFFICHE_FILE(seance[i]);
		while(!FILE_EST_VIDE(seance[i])){
			seance[i]=DEFILER(seance[i],&elm);
			ticket+=elm.nb_tickets;
			caisse+=elm.prix;
		}
	}
	printf("Le cinéma à vendu %d tickets et possède %d€ dans sa caisse\n\r",ticket,caisse);
	return 0;
}


