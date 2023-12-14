#include <stdio.h>

typedef float ELEMENT;

/*-------------------------------------------------------------------
Affiche l'élément
-------------------------------------------------------------------*/
void affiche_ELEMENT(ELEMENT elm){
  printf("%f ",elm);
}

/*-------------------------------------------------------------------
Affecte un élément a un autre élément
-------------------------------------------------------------------*/
void affect_ELEMENT(ELEMENT* elm1,ELEMENT* elm2){
	*elm1=*elm2;
}

/*-------------------------------------------------------------------
Compare un élément à un autre élément
-------------------------------------------------------------------*/
int compare_ELEMENT(ELEMENT elm1,ELEMENT elm2){
	return (elm1==elm2);
}


/*-------------------------------------------------------------------
Permet de saisir un élement
-------------------------------------------------------------------*/
ELEMENT saisir_ELEMENT(){
  ELEMENT elm;
  scanf("%f",&elm);
  return elm;
}

int main()
{
	ELEMENT elm1,elm2;
	
	/*Teste saisir_ELEMENT*/
	printf("Saisir 1er élément : ");
	elm1=saisir_ELEMENT();
	printf("Element 1 : %f\n\r",elm1);
	do{
		printf("Saisir un 2e élément différent du 1er : ");
		elm2=saisir_ELEMENT();
	}while(elm1==elm2);
	printf("Element 2 : %f\n\r",elm2);
	
	/*Teste compare_ELEMENT*/
	if(!compare_ELEMENT(elm1,elm2))printf("Fonction compare_ELEMENT : OK\n\r");
	else{
		printf("Fonction compare_ELEMENT : NOK\n\r");
		return 0;
	}
	
	/*Teste affect_ELEMENT*/
	affect_ELEMENT(&elm1,&elm2);
	if(compare_ELEMENT(elm1,elm2))printf("Fonction affect_ELEMENT : OK\n\r");
	else{
		printf("Fonction affect_ELEMENT : NOK\n\r");
		return 0;
	}
	
	/*Teste affiche_ELEMENT*/
	affiche_ELEMENT(elm1);
	affiche_ELEMENT(elm2);
	
	return 0;
}


