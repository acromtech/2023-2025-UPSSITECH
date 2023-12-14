#include <stdio.h>
#include <stdlib.h>

#include "gibert_module_image_v2.h"

/* AUTEUR : GIBERT ALEXIS                       */
/* DATE CREATION : 30/10/2022                      */
/*-------------------------------------------------*/

int main(void)
{
	/*-------------------------------------------------------------------------------
	[1] Lit une image, 
	[2] Calcule l’histogramme des niveaux de gris,
	[3] Code l’image sur P niveaux de gris (image1), 
	[4] Calcule l’image miroir de l’image codée (image_miroir1), 
	[5] Lit une seconde image,
	[6] Calcule l’image après une rotation de 180° de l’image codée (image2),
	[7] Calcule l’image miroir associée (image_miroir2).
	[8] Les quatre images seront affichées de telle sorte que l’on ait la configuration suivante :
	image1 | image_miroir1
	image2 | image_miroir2
	
	Dans le réperoire Test -> "Test_module_image_V2_main_x.res"
	-------------------------------------------------------------------------------*/
	int lig1,col1,res,niveau;
	int lig2,col2;
	
	scanf("%d",&niveau);
	scanf("%d",&lig1);
	scanf("%d",&col1);
	
	int image1[lig1][col1];
	
	/*[1]*/
	res=lire_image(lig1,col1,image1);
	if(res==1) printf("OK\n\r");
	else{
	  printf("\n\rErreur : Mémorisation impossible\n\r");
	  return 0;
	}
	
	/*DEBUG*/
	affiche_image(lig1,col1,image1);
	
	/*[2]*/
	histogramme(lig1,col1,256,image1);
	
	/*[3]*/
	res=afficher_image_codee_bis(niveau,lig1,col1,image1);
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
	
	/*[4]*/
	int image_miroir1[lig1][col1];
	copie(lig1,col1,image1,image_miroir1);
	image_miroir(lig1,col1,image_miroir1);
	
	/*[5]*/
	scanf("%d",&lig2);
	scanf("%d",&col2);
	int image2[lig2][col2];
	res=lire_image(lig2,col2,image2);
	if(res==1) printf("OK\n\r");
	else{
	  printf("\n\rErreur : Mémorisation impossible\n\r");
	  return 0;
	}
	  
	/*[6]*/
	rotation_image(lig2,col2,180,image2);
	
	/*[7]*/
	int image_miroir2[lig2][col2];
	copie(lig2,col2,image2,image_miroir2);
	image_miroir(lig2,col2,image_miroir2);
	
	/*[8]*/
	affichage_formate(lig1,col1,lig2,col2,image1,image_miroir1,image2,image_miroir2);
	
  	return 0;
}
