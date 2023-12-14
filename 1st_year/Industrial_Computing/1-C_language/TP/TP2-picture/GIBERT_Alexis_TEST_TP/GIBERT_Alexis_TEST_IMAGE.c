#include <stdio.h>
#include <math.h>

void main(){
  int nbl,nbc,pxlc=0;
  int niveau;
  
  scanf("%d",&nbl);
  scanf("%d",&nbc);
  scanf("%d",&niveau);
  
  if(niveau<256){
    if((int)log2(niveau)==log2(niveau)){
      for(int i=0;i<nbl;i++){
        for(int j=0;j<nbc;j++){
          scanf("%d",&pxlc);
          printf("%5d",((pxlc*niveau)/256));
        }
        printf("\n\r");
      }
    }
    else printf("Erreur 1 : le niveau de gris est supérieur à 256\n\r");
  }
  else printf("Erreur 2 : le niveau de gris n’est pas une puissance de 2\n\r");
}


