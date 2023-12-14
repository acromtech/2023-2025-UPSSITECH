/*   fichier progTestPileStat.c
     test de manipulation pour les PILEs statiques 
     
     Affiche des OK si le test est correct et NOK sinon */
/********************************************************/
#include <stdio.h>
#include "pile_statique.h"

int main()
{PILE p ; int e ; int i ;

p = init_PILE() ;
printf("OK\n") ;

if (PILE_estVide(p)) printf("OK\n") ; else printf("\t NOK\n") ; 
if (!PILE_estPleine(p)) printf("OK\n") ; else printf("\t NOK\n") ; 

p = emPILE(p,1)  ;
printf("OK\n") ;
if (!PILE_estVide(p)) printf("OK\n") ; else printf("\t NOK\n") ; 
if (!PILE_estPleine(p)) printf("OK\n") ; else printf("\t NOK\n") ; 

p = emPILE(p,2)  ;
printf("OK\n") ;
if (!PILE_estVide(p)) printf("OK\n") ; else printf("\t NOK\n") ; 
if (!PILE_estPleine(p)) printf("OK\n") ; else printf("\t NOK\n") ; 

p = emPILE(p,3)  ;
printf("OK\n") ;
if (!PILE_estVide(p)) printf("OK\n") ; else printf("\t NOK\n") ; 
if (!PILE_estPleine(p)) printf("OK\n") ; else printf("\t NOK\n") ; 

p = dePILE(p,&e)  ;
printf("OK\n") ;
if (e==3) printf("OK\n") ; else printf("\t NOK\n") ; 
if (!PILE_estVide(p)) printf("OK\n") ; else printf("\t NOK\n") ; 
if (!PILE_estPleine(p)) printf("OK\n") ; else printf("\t NOK\n") ; 

p = dePILE(p,&e)  ;
printf("OK\n") ;
if (e==2) printf("OK\n") ; else printf("\t NOK\n") ; 
if (!PILE_estVide(p)) printf("OK\n") ; else printf("\t NOK\n") ; 
if (!PILE_estPleine(p)) printf("OK\n") ; else printf("\t NOK\n") ; 

p = dePILE(p,&e)  ;
printf("OK\n") ;
if (e==1) printf("OK\n") ; else printf("\t NOK\n") ; 
if (PILE_estVide(p)) printf("OK\n") ; else printf("\t NOK\n") ; 
if (!PILE_estPleine(p)) printf("OK\n") ; else printf("\t NOK\n") ; 

p = dePILE(p,&e)  ;
printf("OK\n") ;
if (PILE_estVide(p)) printf("OK\n") ; else printf("\t NOK\n") ; 
if (!PILE_estPleine(p)) printf("OK\n") ; else printf("\t NOK\n") ; 

for (i = 0 ; i < MAX; i++)
  p = emPILE(p,i) ;
printf("OK\n") ;

p = emPILE(p,1000) ;
printf("OK\n") ;

if (PILE_estPleine(p)) printf("OK\n") ; else printf("\t NOK\n") ; 
if (!PILE_estVide(p)) printf("OK\n") ; else printf("\t NOK\n") ; 

p = dePILE(p,&e)  ;
printf("OK\n") ;
if (e==99) printf("OK\n") ; else printf("\t NOK\n") ; 
if (!PILE_estVide(p)) printf("OK\n") ; else printf("\t NOK\n") ; 
if (!PILE_estPleine(p)) printf("OK\n") ; else printf("\t NOK\n") ; 
p = emPILE(p,1000) ;
printf("OK\n") ;


}


