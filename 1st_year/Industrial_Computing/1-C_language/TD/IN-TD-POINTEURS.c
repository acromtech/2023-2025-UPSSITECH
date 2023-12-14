void moy(int *tab)
{
    float moy=0;
    for(int i=0;i<sizeof(tab)/sizeof(int);i++)
        moy+=tab[i];
    moy/=i;
    printf("%d",moy);
}

void moy_max_min(int *tab,float *pmoy, int *pmax,int *pmin)
{

    for(int i=0;i<sizeof(*tab)/sizeof(int);i++)
    {
        *pmoy+=tab[i];
        if(*pmax<tab[i]) *pmax=tab[i];
        if(*pmin>tab[i]) *pmin=tab[i];
    }
    printf("moy : %d\n max : %d\n min : %d\n",*pmoy/=i,*pmax,*pmin);
}

void dec_circ(int tab[N], int N)
{
    int tmp=tab[0];
    for(int i=0;i<(sizeof(tab)/sizeof(int))-1;i++) tab[i]=tab[i+1];
    tab[N-1]=tmp;
}

void somme_tab(int tab1[N],int tab2[M],int N,int M)
{
    for(int i=0;i<(sizeof(tab)/sizeof(int));i++) tab1[i]+=tab2[i];
}

void recu(int mat[M][N],int recu[M],int *nbrecu)
{
    float moy;
    *nbrecu=0
    for(int i=0;i<M,i++)
    {
        moy=moyenne(mat[i],N);
        if(moy>=10)
        {
            recu[*nbrecu];
            nbrecu++;
        }
    }
}
