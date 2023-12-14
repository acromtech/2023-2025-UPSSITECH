#include <stdio.h>
#include <stdlib.h>

#include "gibert_module_image.h"

/* AUTEUR : GIBERT ALEXIS                       */
/* DATE CREATION : 30/10/2022                      */
/*-------------------------------------------------*/

int main(void)
{
	/*-------------------------------------------------------------------------------
	Teste la fonction "afficher_image_codee()" 
	Dans le répertoire "Test" -> "Test_module_image_V1_afficher_image_codee_x.res"
	-------------------------------------------------------------------------------*/
	/*
	int niveau;

	scanf("%d",&niveau);

	printf("\n\r[Test de la fonction afficher_image_codee() avec niveau [%d]]\n\r",niveau);
	switch(afficher_image_codee(niveau)){
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
	printf("\n\r[Test termine avec succes]\n\r");
	*/
	
	
	
	/*-------------------------------------------------------------------------------
	Teste les fonctions "afficher_image_codee()", "lire_image()" et "afficher_image_codee_bis()" 
	Dans le répertoire "Test" -> "Test_module_image_V1_afficher_image_codee_save_x.res" (contient le test avec ET sans save avec niveau "x")
	-------------------------------------------------------------------------------*/
	/*
  	int niveau,save,res;
  	int lig,col;
  	
  	scanf("%d",&save);
	scanf("%d",&niveau);
	
	printf("[Test de la fonction afficher_image_codee(), lire_image() et afficher_image_codee_bis() avec save[%d] et niveau[%d]]\n\r",save,niveau);
	
  	switch(save){
  	  case 0: 
  	    printf("Choix : Sans sauvegarde\n\r");
  	    res=afficher_image_codee(niveau);
  	    break;
  	    
  	  case 1: 
  	    printf("Choix : Avec sauvegarde\n\r");
  	    scanf("%d",&lig);
  	    scanf("%d",&col);
  	    if(lig<=NB_MAX && lig>0 && col<=NB_MAX && col>0){
  	      if(lire_image(lig,col)) printf("OK\n\r");
  	      else{
  	        printf("\n\rErreur : La taille de l'image est invalide\n\r");
  	        return 0;
  	      }
  	    }
  	    else{
  	      printf("\n\rErreur : Mémorisation impossible\n\r");
  	      return 0;
  	    }
  	    res=afficher_image_codee_bis(niveau,lig,col);
  	    break;
  	    
  	  default: 
  	    printf("\n\rErreur : Valeur de save non traitable\n\r");
  	    return 0;
  	  }
  	  
  	switch(res){
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
	printf("\n\r[Test termine avec succes]\n\r");
	*/
	
	
	
	/*-------------------------------------------------------------------------------
	Teste la fonction "image_miroir()"
	Dans le répertoire "Test" -> "Test_module_image_V1_image_miroir_imagex.res"
	-------------------------------------------------------------------------------*/
	/*
	int lig,col;
	
	printf("[Test de la fonction image_miroir()]\n\r");
	
	scanf("%d",&lig);
	scanf("%d",&col);
	
	if(lire_image(lig,col)) printf("OK\n\r");
  	else{
  	  printf("\n\rErreur : Mémorisation impossible\n\r");
  	  return 0;
  	}
  	image_miroir(lig,col);
  	printf("\n\r[Test termine avec succes]\n\r");
	*/
	
	
	
	/*-------------------------------------------------------------------------------
	Teste la fonction "rotation_image()"
	Dans le répertoire "Test" -> "Test_module_image_V1_rotation_image_imagex_x.res"
	-------------------------------------------------------------------------------*/
	/*
	int lig,col;
	
	printf("[Test de la fonction image_rotation()]\n\r");
	
	scanf("%d",&lig);
	scanf("%d",&col);
	
	if(lire_image(lig,col)) printf("OK\n\r");
  	else{
  	  printf("\n\rErreur : Mémorisation impossible\n\r");
  	  return 0;
  	}
  	rotation_image(lig,col,180);
  	printf("\n\r[Test termine avec succes]\n\r");
	*/
	
	
	
	/*-------------------------------------------------------------------------------
	Teste la fonction "histogramme()"
	Dans le répertoire "Test" -> "Test_module_image_V1_histogramme_imagex.res"
	-------------------------------------------------------------------------------*/
	/*
	int lig,col;
	
	printf("[Test de la fonction histogramme()]\n\r");
	
	scanf("%d",&lig);
	scanf("%d",&col);
	
	if(lire_image(lig,col)) printf("OK\n\r");
	else{
  	  printf("\n\rErreur : Mémorisation impossible\n\r");
  	  return 0;
  	}
  	affiche_image(lig,col);
  	histogramme(lig,col,256);
	printf("\n\r[Test termine avec succes]\n\r");
	*/
  	return 0;
}
