#include "pile_statique.h"

int main()
{
  ELEMENT test;
  PILE Est, Garage, Ouest;

  Ouest = init_PILE();
  Garage = init_PILE();
  Est = init_PILE();

  Est = saisir_PILE();
  printf("\r\n");
  printf("Gare Est : ");
  affiche_PILE(Est);
  printf("\r\n\n\n");
  printf("Gare Ouest :");
  affiche_PILE(Ouest);
  printf("Garage :   ");
  affiche_PILE(Garage);
  printf("Gare Est : ");
  affiche_PILE(Est);
  printf("\r\n");


  while (PILE_estVide(Est)!=1)
  {
    Est=dePILE(Est,&test);
    Garage=emPILE(Garage,test);
    printf("Gare Ouest :");
    affiche_PILE(Ouest);
    printf("Garage :   ");
    affiche_PILE(Garage);
    printf("Gare Est : ");
    affiche_PILE(Est);
    printf("\r\n");
  }
  

  while (PILE_estVide(Garage)!=1)
  {
    Garage=dePILE(Garage,&test);
    Ouest=emPILE(Ouest,test);
    printf("Gare Ouest :");
    affiche_PILE(Ouest);
    printf("Garage :   ");
    affiche_PILE(Garage);
    printf("Gare Est : ");
    affiche_PILE(Est);
    printf("\r\n");
  }
  
  
}
