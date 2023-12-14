#ifndef MODULE_IMAGE_H_INCLUS     /*--  Inclusion conditionnelle --> si pas déjà inclus           */
#define MODULE_IMAGE_H_INCLUS     /*--  alors créer la constante symbolique MODULE_IMAGE_H_INCLUS */

#define NB_MAX 16

/* AUTEUR : ALEXIS GIBERT                       */
/* DATE CREATION : 30/10/2022                      */
/*-------------------------------------------------*/

/* DECLARATIONS DES FONCTIONS */

int afficher_image_codee(int niveau);
int lire_image(int N, int M);
int afficher_image_codee_bis(int niveau, int N, int M);
void image_miroir(int N, int M);
void rotation_image(int N, int M, int angle);
void histogramme(int N, int M, int niveau);

/*FONCTIONS SUPPLEMENTAIRES*/
void affiche_image(int N,int M);

#endif
