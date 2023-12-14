#include "pile_statique.h"

volatile int taille_wagon;

PILE init_PILE(){
	PILE p;
	p.tete = -1;
	return p;
}

void affiche_PILE(PILE p){
	for (int i = p.tete; i >= 0; i--)affiche_ELEMENT(p.train[i]);
	printf("\r\n");
}

int PILE_estVide(PILE p){
	return (p.tete==-1);
}

int PILE_estPlein(PILE p){
	return (p.tete==MAX-1);
}

PILE emPILE(PILE p, ELEMENT x){
	if (PILE_estPlein(p) == 1)printf("Erreur : PILE PLEINE ");
	else{
		p.tete++;
		affect_ELEMENT(x,&(p.train[p.tete]));
	}
	return p;
}

PILE dePILE(PILE p, ELEMENT *y){
	if (PILE_estVide(p) == 1)printf("Erreur : PILE VIDE ");
	else{
		affect_ELEMENT(p.train[p.tete],y);
		p.tete--;
	}
	return p;
}

PILE saisir_PILE(){
	ELEMENT val;
	PILE p;
	p=init_PILE();
	do{
		printf("Combien de wagons souhaitez-vous ? : ");
		scanf("%d",&taille_wagon);
		printf("\n\r(la locomotive sera toujours PRErentre \n\r Donc vous commencerai toujours Apres L)\n\n\r");
		taille_wagon++; // Par ce que dans tous les cas il y a la locomotive
	}while ((taille_wagon<=0)||(taille_wagon>=MAX));

	for (int i=0;i<taille_wagon;i++){
		if (i==taille_wagon-1){
			val.composant='L';
			val.ID=taille_wagon-1;
		}
		else{
			val=saisir_ELEMENT();
			val.ID=i;
		}
		p=emPILE(p,val);
	}
	return p;
}
