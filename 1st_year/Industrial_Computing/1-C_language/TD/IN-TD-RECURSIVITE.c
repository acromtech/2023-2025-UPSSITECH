int serie_harmonique(int n)
{
    int t;
    t=1/serie_harmonique(n);
    printf("%4d",t);
    if(n>0)return(n-1);
    else return 0;
}

int multiplication_v1(int a, int b)
{
    if(a==0||b==0) return 0;
    return(a+multiplication_v1(a,(b-1))); // ici pas besoin de condition cela ne ferait que retarder l'execution du programme
}

int multiplication_v2(int a,int b)
{
    if(a==0||b==0) return 0;
    if(b%2==0)//pair
        return(multiplication_v2(a+a,b/2));
    else//impair
        return(a+multiplication_v2(a+a,(b-1)/2));
}

int ackermann(int n, int m)
{
    if(m==0)return(n+1);
    if(n==0)return(ackermann(m-1,1));
    return(ackermann(m-1,ackermann(m,n-1)));
}

int pavage(int N)
{
    if(N==1)return 1;
    if(N==2)return 2;
    return(pavage(N-1)+pavage(N-2));
}

void hanoi(int N, int pique_dep, int pique_int, int pique_arr)
{
    if(N!=0){
        hanoi(N-1,pique_dep,pique_arr,pique_int);
        deplacer(pique_dep,pique_arr);
        hanoi(N-1,pique_int,pique_dep,pique_arr);
    }
}

#define P 5
int partition(int deb, int fin, int T[P])
{
    //ecrire une partition de telle sorte a ce que chaque valeur ne soit traitée qu'une seule fois
    //renvoi l'indice du pivot apres le positionnnement
    //voir code dans le corrigé
}
void tri_rapide(int deb, int fin, int T[P]) //deb et fin sont les indices des tableaux de la zone a trouver
{
    int place_pivot;
    if(fin>deb){
        place_pivot=partition(deb,fin,T);
        tri_rapide(deb,place_pivot-1,T);
        tri_rapide(place_pivot+1,fin,T);
    }
}



void main(){
    
    //EXERCICE 3.1 : LA SERIE HARMONIQUE
    int n;
    do{
        scanf("%d",&n);
    }while(n<0);
    printf("%4d",serie_harmonique(n));

    //EXERCICE 3.2 : CALCUL FINANCIER

    //EXERCICE 3.3 : LA FONCTION MULTIPLICATION
    int a,b,res;
    do{
        printf("a=");
        scanf("%d",&a);
        printf("b=");
        scanf("%d",&b);
        if(a<=0||b<=0) printf("Rentrez des valeurs >=0\n");
    }while(a<=0||b<=0);
    res=multiplication(a,b);
    printf("%d x %d = %d",a,b,res);
    
    //EXERCICE 3.4 : LA FONCTION D'ACKERMANN
    int n,m,res;
    do{
        printf("n=");
        scanf("%d",&n);
        printf("m=");
        scanf("%d",&m);
        if(n<=0||m<=0) printf("Rentrez des valeurs >=0\n");
    }while(n<=0||m<=0);
    res=ackermann(n,m);

    //EXERCICE 4.1 : LA FONCTION DE PAVAGE
    const int N=6;
    pavage(N);

    //EXERCICE 4.2 : LE JEU D'HANOI
    const int N=5;
    int dep,aux,arr;
    hanoi(N,dep,aux,arr);

    //EXERCICE 4.3 : LE TRI RAPIDE
    int deb,fin,T[P];
    tri_rapide(deb,fin,T[P]);
}
