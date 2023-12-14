#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "gibert_module_image_v2.h"

/* AUTEUR : ALEXIS GIBERT                       */
/* DATE CREATION : 30/10/2022                      */
/*-------------------------------------------------*/

/* DEFINITIONS DES FONCTIONS déclarées dans le .h */


/*-------------------------------------------------------------------------------
Lit et mémorise la matrice à partir des valeurs lues sur l’entrée standard. 
Elle reçoit en paramètre les valeurs N et M correspondant respectivement au nombre de lignes et au nombre de colonnes de la matrice représentant l’image. 
Ces valeurs auront été lues et testées par le programme principal. 
De plus, cette fonction renverra :
	[0]	si la mémorisation ne peut pas être faite,
	[1]	sinon (traitement effectué).
-------------------------------------------------------------------------------*/
int lire_image(int N, int M, int image[N][M]){
  int i,j,val;
  printf("\n\r[Lecture de la matrice de %d lignes et %d colonnes] : ",N,M);
  if(N<=NB_MAX && N>0 && M<=NB_MAX && M>0){
    for(i=0;i<N;i++){
      for(j=0;j<M;j++){
        scanf("%d",&val);
	image[i][j]=val;
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
int afficher_image_codee_bis(int niveau, int N, int M, int image[N][M]){
  int i,j;
  printf("\n\r[Passage vers une image a %d niveau de gris]\n\r",niveau);
  if(niveau<256){
    if((int)log2(niveau)==log2(niveau)){
      for(i=0;i<N;i++){
        for(j=0;j<M;j++){
          image[i][j]=((image[i][j])*niveau)/256;
        }
      }
      affiche_image(N,M,image);
    }
    else return 0;
  }
  else return -1;
  return 1;
}

/*-------------------------------------------------------------------------------
Fonction image_miroir qui affiche l’image en inversant les colonnes.
-------------------------------------------------------------------------------*/
void image_miroir(int N, int M, int image[N][M]){
  int i,j,temp;
  printf("\n\r[Transformation de l'image en image miroir]\n\r");
  for(i=0;i<N;i++){
    for(j=0;j<M/2;j++){
      temp=image[i][N-1-j];
      image[i][N-1-j]=image[i][j];
      image[i][j]=temp;
    }
  }
  affiche_image(N,M,image);
}


/*-------------------------------------------------------------------------------
Sous-programme supplémentaire permettant simplement d'afficher la matrice
-------------------------------------------------------------------------------*/
void affiche_image(int N, int M, int image[N][M]){
  int i,j;
  printf("Affichage de l'image\n\r");
  for(i=0;i<N;i++){
    for(j=0;j<M;j++){
      printf("%5d",image[i][j]);
    }
    printf("\n\r");
  }
  printf("Affichage termine\n\r");
}

/*-------------------------------------------------------------------------------
Fonction rotation_image qui affiche l’image après une rotation de 90° ou 180°.
L’angle de rotation étant passé en paramètre.
-------------------------------------------------------------------------------*/
void rotation_image(int N, int M, int angle, int image[N][M]){
  int i,j,temp;
  
  affiche_image(N,M,image);
  printf("\n\r[Rotation de %d° de l'image]\n\r",angle);
  switch(angle){
    case 180 :
      for(i=0;i<N/2;i++){
        for(j=i;j<N-i-1;j++){
          temp=image[i][j];
          image[i][j]=image[j][N-1-i];
          image[j][N-1-i]=image[N-1-i][N-1-j];
          image[N-1-i][N-1-j]=image[N-1-j][i];
          image[N-1-j][i]=temp;
        }
      }
    case 90 :
      for(i=0;i<N/2;i++){
        for(j=i;j<N-i-1;j++){
          temp=image[i][j];
          image[i][j]=image[j][N-1-i];
          image[j][N-1-i]=image[N-1-i][N-1-j];
          image[N-1-i][N-1-j]=image[N-1-j][i];
          image[N-1-j][i]=temp;
        }
      }
      affiche_image(N,M,image);
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
void histogramme(int N, int M, int niveau, int image[N][M]){
  int i,j,tab_histogramme[niveau];
  printf("\n\r[Histogramme]\n\r");
  for(i=0;i<niveau;i++) tab_histogramme[i]=0;
  for(i=0;i<N;i++) for(j=0;j<M;j++) tab_histogramme[image[i][j]]+=1;
  for(i=0;i<niveau;i++) if(tab_histogramme[i]!=0) printf("Fréquence de %d dans l'image : %d pourcent\n\r",i,(tab_histogramme[i]*100)/(N*M));
  printf("Toutes autres fréquences dans l'image : 0 pourcent\n\r");
}


/*-------------------------------------------------------------------------------
Fonction qui copie les valeurs d'une matrice dans une autre matrice
-------------------------------------------------------------------------------*/
void copie(int N, int M, int image[N][M], int image_copie[N][M]){
  int i,j;
  for(i=0;i<N;i++) for(j=0;j<M;j++) image_copie[i][j]=image[i][j];
  printf("\n\rCopie : OK\n\r");
}


/*-------------------------------------------------------------------------------
Fonction affiche les différentes images selon le format suivant :
image1 | image_miroir1
image2 | image_miroir2
-------------------------------------------------------------------------------*/

void affichage_formate(int N1, int M1, int N2, int M2, int image1[N1][M1],int image_miroir1[N1][M1],int image2[N2][M2],int image_miroir2[N2][M2]){
  int i,j;
  printf("\n\r[Affichage formate]\n\r");
  for(i=0;i<N1;i++){
    for(j=0;j<((M2/2)-(M1/2));j++) printf("%5c",' ');
    for(j=0;j<M1;j++) printf("%5d",image1[i][j]);
    for(j=0;j<((M2/2)-(M1/2));j++) printf("%5c",' ');
    printf("%5c%5c%5c",' ','*',' ');
    for(j=0;j<((M2/2)-(M1/2));j++) printf("%5c",' ');
    for(j=0;j<M1;j++) printf("%5d",image_miroir1[i][j]);
    printf("\n\r");
  }
  printf("\n\r");
  for(i=0;i<(M2*2)+3;i++) printf("%5c",'*');
  printf("\n\r\n\r");
  for(i=0;i<N2;i++){
    for(j=0;j<M2;j++) printf("%5d",image2[i][j]);
    printf("%5c%5c%5c",' ','*',' ');
    for(j=0;j<M2;j++) printf("%5d",image_miroir2[i][j]);
    printf("\n\r");
  }
}
