#include <stdio.h>
#include <stdlib.h>

#include "gibert_module_image_v2.h"

/* AUTEUR : GIBERT ALEXIS                       */
/* DATE CREATION : 30/10/2022                      */
/*-------------------------------------------------*/

int main(void)
{
	/*-------------------------------------------------------------------------------
	Teste la fonction "lire_image()" et "afficher_image_codee_bis()"
	Dans le répertoire Test -> "Test_module_image_V2_afficher_image_codee_bis_x.res"
	-------------------------------------------------------------------------------*/
	/*
  	int niveau,lig,col;
	
	scanf("%d",&niveau);
	
	printf("Test avec niveau[%d]\n\r",niveau);
	
	scanf("%d",&lig);
	scanf("%d",&col);
	
	int image[lig][col];
	
	if(lire_image(lig,col,image)) printf("OK\n\r");
	else{
	  printf("\n\rErreur : Mémorisation impossible\n\r");
	  return 0;
	}
	
	affiche_image(lig,col,image);
	
	switch(afficher_image_codee_bis(niveau,lig,col,image)){
	  case -1:
	    printf("\n\rErreur 1 : le niveau de gris est supérieur à 256\n\r"); 
	    return 0;
	  case 0:
	    printf("\n\rErreur 2 : le niveau de gris n’est pas une puissance de 2\n\r");
	    return 0;
	  case 1:
	    printf("Traitement effectue avec succes\n\r");
	    break;
	  default:
	    printf("\n\rErreur 3 : Valeur inconnue renvoyée par la fonction\n\r");
	    return 0;
	}
	*/
	
	
	/*-------------------------------------------------------------------------------
	Teste la fonction "lire_image()" et "image_miroir()"
	Dans le répertoire Test -> "Test_module_image_V2_image_miroir_imagex.res"
	-------------------------------------------------------------------------------*/
	/*
	int lig,col;
	
	scanf("%d",&lig);
	scanf("%d",&col);
	
	int image[lig][col];
	
	if(lire_image(lig,col,image)) printf("OK\n\r");
	else{
	  printf("\n\rErreur : Mémorisation impossible\n\r");
	  return 0;
	}
	affiche_image(lig,col,image);
	
	image_miroir(lig,col,image);
	*/
	
	
	/*-------------------------------------------------------------------------------
	Teste la fonction "lire_image()" et "rotation_image()"
	Dans le répertoire Test -> "Test_module_image_V2_rotation_image_x_imagex"
	-------------------------------------------------------------------------------*/
	/*
	int lig,col;
	
	scanf("%d",&lig);
	scanf("%d",&col);
	
	int image[lig][col];
	
	if(lire_image(lig,col,image)) printf("OK\n\r");
	else{
	  printf("\n\rErreur : Mémorisation impossible\n\r");
	  return 0;
	}
	
	rotation_image(lig,col,90,image);
	*/
	
	
	/*-------------------------------------------------------------------------------
	Teste la fonction "lire_image()" et "histogramme()"
	Dans le répertoire Test -> "Test_module_image_V2_histogramme_imagex"
	-------------------------------------------------------------------------------*/
	/*
	int lig,col;
	
	scanf("%d",&lig);
	scanf("%d",&col);
	
	int image[lig][col];
	
	if(lire_image(lig,col,image)) printf("OK\n\r");
	else{
	  printf("\n\rErreur : Mémorisation impossible\n\r");
	  return 0;
	}

	affiche_image(lig,col,image);
	
	histogramme(lig,col,256,image);
	*/
  	return 0;
}
