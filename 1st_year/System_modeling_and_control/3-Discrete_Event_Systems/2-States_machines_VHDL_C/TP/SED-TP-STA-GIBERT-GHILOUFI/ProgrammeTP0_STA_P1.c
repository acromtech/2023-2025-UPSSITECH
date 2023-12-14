
/* ===================================================*/
/*    Programme de mise en oeuvre de MEF              */
/*             Maquette du STA                        */
/* ===================================================*/

/******************************************************/
/*  POUR COMPILER   (renommer le fichier)             */
/*  gcc -Wall xxx.c -o xxx -lcomedi -lsta             */
/******************************************************/

#include <stdio.h>    // pour printf/scanf uniquement
#include <unistd.h>   // pour usleep();
#include <sta.h>      // definition des identifiants ES et des tempos entre autres

int main(void)
{
  ////////////////////////////////////////////////////////////////////////////////////
  /* Déclarations variables */
  // les variables d'état et initialisation
  int EtatPresent = 1;
  int EtatSuivant = 1;
  int cpt = 0;

  // les entrées
  int ag, c, lh, lv, p, op;

  // les sorties
  int V, H, B, G, D, A;

  ////////////////////////////////////////////////////////////////////////////////////
  /* Initialisation du programme */
  // initialisation des ports 
  init_io();
  InitSta();

  printf(" * ***************************************** * \n");
  printf(" *      CTRL-C pour arrêter la commande      * \n");
  printf(" * ***************************************** * \n");

  /*********************************************************/  
  /*      Début de la boucle de fonctionnement             */
  /*********************************************************/
  while(!stop()) // interrompre le programme par appui sur CTRL+C
  {
    // lecture des entrées
    ag = entree(AG);
    c  = entree(C);
    lh = entree(LH);
    lv = entree(LV);
    p  = entree(P);
    op = entree(OP);
    //printf("Capteurs :\n\tLAG\tC\tAD\tP\tLH\tLV\tOP\n\t%d\t%d\t%d\t%d\t%d\t%d\t%d\n",AG,C,AD,P,LH,LV,OP); // Affichage pour débug

    /* allongement du cycle programme */
    usleep(1000);

    /************/
    /* Bloc F  */
    /************/	
    switch(EtatPresent)
    {
      case 1 :  if (op) 			        EtatSuivant = 2;  break;
      case 2 :  if (!p) 			        EtatSuivant = 3;  break;  
      case 3 :  if (p) 	 		          EtatSuivant = 4;  break;
      case 4 :  if (ag)			          EtatSuivant = 5;  break;
      case 5 :  if (c) 			          EtatSuivant = 6;  break;
      case 6 :  if(!lv)	   		        EtatSuivant = 7;  break;
      case 7 :  if(lv)   			        EtatSuivant = 8;  break;
      case 8 :  if(!c)				        EtatSuivant = 9;  break;
      case 9 :  if(c){if(cpt==1){		  EtatSuivant = 10;} else{cpt++;EtatSuivant = 8;}}  break;
      case 10 :  if(!lv) 			        EtatSuivant = 11;  break;  
      case 11 :  if(lv){ sleep(8);		EtatSuivant = 1;}  break;
      //case 12 :  if(!lh) 			EtatSuivant = 13;  break;
      //case 13 :  if(lh) 			EtatSuivant = 14;  break;
     }   
 
    /************/
    /* Bloc M  */
    /************/       
    EtatPresent = EtatSuivant;

    printf("Etat Present : \t%d\n",EtatPresent); // Affichage pour débug
    printf("cpp : \t%d\n",cpt); // Affichage pour débug

    /************/
    /* Bloc G   */
    /************/
    V = ((EtatPresent==1));
    //if(c){ cpt++;}
    //A = (EtatPresent==14);
    B = ((EtatPresent==10)||(EtatPresent==11));
    H = ((EtatPresent==6)||(EtatPresent==7));
    D = ((EtatPresent==4)||(EtatPresent==1));
    G = ((EtatPresent==2)||(EtatPresent==3)||(EtatPresent==5)||(EtatPresent==8)||(EtatPresent==9));

    printf("Capteurs    :\n\tlv\tlh\tag\tc\tp\n\t%d\t%d\t%d\t%d\t%d\n",lv,lh,ag,c,p); // Affichage pour débug
    printf("Actionneurs :\n\tH\tB\tG\tD\tA\n\t%d\t%d\t%d\t%d\t%d\n\n",H,B,G,D,A); // Affichage pour débug

    /****************************/
    /* Ecriture des sorties     */
    /****************************/
    sortie(VV,V);
    sortie(HH,H);
    sortie(BB,B);
    sortie(GG,G);
    sortie(DD,D);
    sortie(AA,A);
  }

  /*********************************************************/
  /*    Fin de boucle de fonctionnement                    */
  /*********************************************************/

  mzSorties(); // coupe toutes les sorties avant d'arrêter la commande
  printf("\n\n*** Arrêt provoqué par l'utilisateur (CTRL-C) ***\n\n");  
  return 0;
}
