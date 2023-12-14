public class pile{
    //ATTRIBUTS
    private int T[];
    private int nb,deb;         //nombre d'elements significatifs
    private final int N;    //nombre de case du tableau (de la pile)
    //Info : "final" signifie que la valeur restera inchangée / comme "static" en C
    
    //CONSTRUCTEUR
    public Pile(int N){
        T=new int[N];
        this.N=N;   
        //this.nb=0; n'est pas utile car comme c'est un attribut, Java les initialise à NULL dès le départ
    }

    //METHODES
    public void ajout(int x){
        //ajoute un entier donné en paramètre en tête de la pile statique

        //ANCIENNE VERSION 
        //ATTENTION : Sera a modifier plus tard pour avoir un peu plus d'ergonomie
        /*
        if(!pilePleine()){
            T[nb]=x;
            nb++;
        }//
        */

        //NOUVELLE VERSION
        if(!pilePleine()){
            T[(deb+nb)%N]=x;
            nb++;
        }
    }
    public int longueur(){
        //renvoie le nombre d'entiers la pile statique
        return(nb);
    }
    public boolean pileVide(){
        //renvoie True si la pile statique est vide sinon False
        return(nb==0);
    }
    public boolean pilePleine(){
        //renvoie True si la pile statique est pleine sinon False
        return(nb==N);
    }
    public void enleverTete(){
        //supprime la tete de la pile statique
        if(!pileVide())nb=nb-1;
    }
    public void enleverDernier(){
        //supprime le dernier entier de la pile statique
        //METHODE 1 : Methode triviale
        /*if(!pileVide()){
            for(int i=0;i<nb-1;i++){
                T[i]=T[i+1];
            }
            nb--;
        }*/
        //METHODE 2 : Buffer circulaire
        if(!pileVide()){
            deb=(deb+1)%N;
            nb--;
        }
    }
    public int tete(){
        //renvoie la tete de la pile statique
        //ATTENTION : A n'utiliser que si la pile n'est pas vide
        return T[(deb+nb-1)%N];
    }
    public int dernier(){
        //renvoie le dernier entier de la pile statique
        //ATTENTION : A n'utiliser que si la pile n'est pas vide
        return T[deb];
    }
    public queue(){
        //renvoie la queue de la pile statique
        Pile paux=new Pile(N);
        for(int i=0;i<this.nb-1;i++){
            paux.T[i]=this.T[(deb+i)%N];
        }
        paux.nb=this.nb-1;
        return paux;
    }
    public boolean appartient(int x){
        //renvoie true si l'entier donné appartient a la pile statique
        for(int i;i<nb;i++){
            if(T[(deb+i)%N]==x)
                return true;
        }
        return false;
    }
    public String toString(){
        //renvoie la pile statique sous forme de caractere
        String s="la pile contient"+nb,"entiers";
        for(int i=0;i<nb;i++)
            s=s+T[(deb+i)%N]+"-";
        s=s+"(Classe par anciennete decroissante)";
        return s;
    }
    public boolean equals(Object o){
        //renvoie true si la pile passé en parametre est egale a la pile courante
        Pile paux=(Pile)o; //cast du o
        if(paux.N!=this.N)return false;
        if(paux.nb!=this.nb)return false;
        for(int i=0;i<this.nb;i++){
            if(paux.T[(paux.deb+1)%N]!=this.T[this.deb+i]%N)
                return false;
        }
        return true;
    }
    public Pile clone(){
        //cree un clone de la pile statique
        Pile paux=new Pile(N);
        for(int i=0;i<this.nb;i++)
            paux.T[i]=this.T[(deb+i)%N];
        paux.nb=this.nb;
        return paux;
    }
}

//APPLICATION DE LA CLASSE AU PROGRAMME DU HANOI
public class HANOI{
    //ATTRIBUTS
    private Pile p1;
    private Pile p2;
    private Pile p3;
    private int nbD;

    //CONSTRUCTEUR
    public HANOI(int N){
        nbD=N;
        p1=new Pile(N);
        for(int i=N;i>0;i--)
            p1.ajout(i);
        p2=new Pile(N);
        p3=new Pile(N);
    }
    public void solve(int n, Pile p1, Pile p2, Pile p3){
        if(n>0){
            solve(n-1,p1,p2,p3);
            int d=p1.tete();
            p1.enleverTete();
            p1.ajout(d);
            solve(n-1,p2,p1,p3)
        }
    }
    public static void main(String []arg){
        HANOI pb=new HANOI(1000);
        pb.solve();
    }
}