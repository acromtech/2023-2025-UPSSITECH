#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "gibert_module_image.h"

int IMAGE[NB_MAX][NB_MAX];

/* AUTEUR : ALEXIS GIBERT                       */
/* DATE CREATION : 30/10/2022                      */
/*-------------------------------------------------*/

/* DEFINITIONS DES FONCTIONS déclarées dans le .h */

/*-------------------------------------------------------------------------------
Affiche la transformation de l’image suivant le niveau de gris donné en paramètre.
De plus, elle renverra une valeur entière qui vaudra suivant le cas :
	[-1]	si la valeur du niveau est supérieure à 256, 
	[0]	si le niveau n’est pas une puissance de 2,
	[1]	sinon (traitement effectué).
-------------------------------------------------------------------------------*/
int afficher_image_codee(int niveau){
  int nbl,nbc,pxlc=0,i,j;
  printf("\n\r[Passage vers une image a %d niveau de gris]\n\r",niveau);
  if(niveau<256){
    if((int)log2(niveau)==log2(niveau)){
      scanf("%d",&nbl);
      scanf("%d",&nbc);
      for(i=0;i<nbl;i++){
        for(j=0;j<nbc;j++){
          scanf("%d",&pxlc);
          printf("%5d",((pxlc*niveau)/256));
        }
        printf("\n\r");
      }
    }
    else return 0;
  }
  else return -1;
  return 1;
}

/*-------------------------------------------------------------------------------
Lit et mémorise la matrice à partir des valeurs lues sur l’entrée standard. 
Elle reçoit en paramètre les valeurs N et M correspondant respectivement au nombre de lignes et au nombre de colonnes de la matrice représentant l’image. 
Ces valeurs auront été lues et testées par le programme principal. 
De plus, cette fonction renverra :
	[0]	si la mémorisation ne peut pas être faite,
	[1]	sinon (traitement effectué).
-------------------------------------------------------------------------------*/
int lire_image(int N, int M){
  int i,j,val;
  printf("\n\r[Lecture de la matrice de %d lignes et %d colonnes] : ",N,M);
  if(N<=NB_MAX && N>0 && M<=NB_MAX && M>0){
    for(i=0;i<N;i++){
      for(j=0;j<M;j++){
        scanf("%d",&val);
	IMAGE[i][j]=val;
      }
    }
    return 1;
  }
  else return 0;
}

/*-------------------------------------------------------------------------------
Effectue la transformation de l’image suivant le niveau de gris, les valeurs de N (nombre de lignes de la matrice) et M (nombre de colonne de la matrice) en paramètre.
Elle veillera a enregistrer les nouvelles valeurs dans la matrice mémorisée.
De plus, elle renverra une valeur entière qui vaudra suivant le cas :
	[-1]	si la valeur du niveau est supérieure à 256, 
	[0]	si le niveau n’est pas une puissance de 2,
	[1]	sinon (traitement effectué).
-------------------------------------------------------------------------------*/
int afficher_image_codee_bis(int niveau, int N, int M){
  int i,j;
  printf("\n\r[Passage vers une image a %d niveau de gris]\n\r",niveau);
  if(niveau<256){
    if((int)log2(niveau)==log2(niveau)){
      for(i=0;i<N;i++){
        for(j=0;j<M;j++){
          IMAGE[i][j]=((IMAGE[i][j])*niveau)/256;
          printf("%5d",IMAGE[i][j]);
        }
        printf("\n\r");
      }
    }
    else return 0;
  }
  else return -1;
  return 1;
}

/*-------------------------------------------------------------------------------
Fonction image_miroir qui affiche l’image en inversant les colonnes.
-------------------------------------------------------------------------------*/
void image_miroir(int N, int M){
  int i,j;
  affiche_image(N,M);
  printf("\n\r[Transformation de l'image en image miroir]\n\r");
  for(i=0;i<N;i++){
    for(j=M-1;j>=0;j--){
      printf("%5d",IMAGE[i][j]);
    }
    printf("\n\r");
  }
}

/*-------------------------------------------------------------------------------
Sous-programme supplémentaire permettant simplement d'afficher la matrice
-------------------------------------------------------------------------------*/
void affiche_image(int N,int M){
  int i,j;
  printf("Affichage de l'image\n\r");
  for(i=0;i<N;i++){
    for(j=0;j<M;j++){
      printf("%5d",IMAGE[i][j]);
    }
    printf("\n\r");
  }
  printf("Affichage termine\n\r");
}

/*-------------------------------------------------------------------------------
Fonction rotation_image qui affiche l’image après une rotation de 90° ou 180°.
L’angle de rotation étant passé en paramètre.
-------------------------------------------------------------------------------*/
void rotation_image(int N, int M, int angle){
  int i,j,temp;
  
  affiche_image(N,M);
  printf("\n\r[Rotation de %d° de l'image]\n\r",angle);
  switch(angle){
    case 180 :
      for(i=0;i<N/2;i++){
        for(j=i;j<N-i-1;j++){
          temp=IMAGE[i][j];
          IMAGE[i][j]=IMAGE[j][N-1-i];
          IMAGE[j][N-1-i]=IMAGE[N-1-i][N-1-j];
          IMAGE[N-1-i][N-1-j]=IMAGE[N-1-j][i];
          IMAGE[N-1-j][i]=temp;
        }
      }
    case 90 :
      for(i=0;i<N/2;i++){
        for(j=i;j<N-i-1;j++){
          temp=IMAGE[i][j];
          IMAGE[i][j]=IMAGE[j][N-1-i];
          IMAGE[j][N-1-i]=IMAGE[N-1-i][N-1-j];
          IMAGE[N-1-i][N-1-j]=IMAGE[N-1-j][i];
          IMAGE[N-1-j][i]=temp;
        }
      }
      affiche_image(N,M);
      break;
    default:
      printf("Erreur : Valeur d'angle inconnue\n\r");
      break;
  }
}

/*-------------------------------------------------------------------------------
Fonction histogramme qui calcule et affiche l’histogramme d’une image. 
Ici un histogramme correspond à la fréquence avec laquelle chaque niveau de gris est présent dans la totalité de l’image.
Cette fréquence est ramenée à un pourcentage.
-------------------------------------------------------------------------------*/
void histogramme(int N, int M, int niveau){
  int i,j,tab_histogramme[niveau];
  printf("\n\r[Histogramme]\n\r");
  for(i=0;i<niveau;i++) tab_histogramme[i]=0;
  for(i=0;i<N;i++) for(j=0;j<M;j++) tab_histogramme[IMAGE[i][j]]+=1;
  for(i=0;i<niveau;i++) if(tab_histogramme[i]!=0) printf("Fréquence de %d dans l'image : %d pourcent\n\r",i,(tab_histogramme[i]*100)/(N*M));
  printf("Toutes autres fréquences dans l'image : 0 pourcent\n\r");
}
