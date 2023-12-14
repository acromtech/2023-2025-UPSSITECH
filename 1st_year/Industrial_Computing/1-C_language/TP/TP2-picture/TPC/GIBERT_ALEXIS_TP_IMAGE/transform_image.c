#include <stdio.h>

void main(){
  int nbl,nbc,pxlc=0;

  scanf("%d",&nbl);
  scanf("%d",&nbc);

  for(int i=0;i<nbl;i++){
    for(int j=0;j<nbc;j++){
      scanf("%d",&pxlc);
      printf("%5d",((pxlc*4)/256));
    }
    printf("\n\r");
  }
}
