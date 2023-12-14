//Algo leçon 9
typedef struct etCel{
    int val;
    struct etCel *suiv;
    }Cellule,*pile;
    
void empiler(pile*pp, int v)
{
    pile paux=(pile)malloc(sizeof(Cellule));
    if(paux!=NULL){
        paux->val=v; //avant (*paux).val=v;
        paux->suiv=*pp; //avant (*paux).niv=*pp;
        *pp=paux;
    }
}
//autre version
pile empiler(pile p,int v)
{
    pile paux=(pile)malloc(sizeof(Cellule));
    if(paux!=NULL){
        paux->val=v;
        paux->suiv=p;
        return paux;
    }
    return p;
}

//Algo leçon 10
typedef struct etCel{
    int val;
    struct etCel *suiv;
    }Cellule;
typedef struct etFifo{
    Cellule *tete;
    Cellule *queue;
}Fifo;

//appel : Fifo f; f=creerFile();
Fifo creerFile()
{
    Fifo f;
    f.tete=NULL;
    f.queue=NULL;
    return f;
}

//appel : Fifo f; creerFile(&f);
void creerFile(Fifo*pf)
{
    pf->tete=NULL;
    pf->queue=NULL;
}

Fifo enfiler(Fifo f, int v)
{
    Cellule*aux;
    aux=(Cellule*)malloc(sizeof(Cellule));
    if(aux!=NULL){
        aux->val=v;
        aux->suiv=NULL;
    }
    if(f.queue==NULL)f.tete=aux;
    else f.queue->suiv=aux;
    f.queue=aux;
    return f;
}

Fifo defiler(Fifo f)
{
    if(f.tete==NULL) return f;
    if(f.tete==f.queue) f.queue=NULL;
    Cellule*aux=f.tete->suiv;
    free(f.tete);
    f.tete=aux;
    return f;
}


//Exercice d'app
typedef struct etNoeud{
    int val;
    struct etNoeud* sag;
    struct etNoeud* sad;
}Noeud;
typedef Noeud* GRD;

GRD creerGRD(){
    return NULL;
}