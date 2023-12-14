#ifndef MODULE_IMAGE_H_INCLUS     /*--  Inclusion conditionnelle --> si pas déjà inclus           */
#define MODULE_IMAGE_H_INCLUS     /*--  alors créer la constante symbolique MODULE_IMAGE_H_INCLUS */

#define NB_MAX 16

/* AUTEUR : ALEXIS GIBERT                       */
/* DATE CREATION : 30/10/2022                      */
/*-------------------------------------------------*/

/* DECLARATIONS DES FONCTIONS */

int lire_image(int N, int M, int image[N][M]);
int afficher_image_codee_bis(int niveau, int N, int M, int image[N][M]);
void image_miroir(int N, int M, int image[N][M]);
void rotation_image(int N, int M, int angle, int image[N][M]);
void histogramme(int N, int M, int niveau, int image[N][M]);

/*FONCTIONS SUPPLEMENTAIRES*/
void affiche_image(int N, int M, int image[N][M]);
void copie(int N, int M, int image[N][M], int image_copie[N][M]);
void affichage_formate(int N1, int M1, int N2, int M2, int image1[N1][M1],int image_miroir1[N1][M1],int image2[N2][M2],int image_miroir2[N2][M2]);

#endif
