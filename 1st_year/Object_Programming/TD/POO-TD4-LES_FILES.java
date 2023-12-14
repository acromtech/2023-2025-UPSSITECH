//TD4 QUESTION 1
// le "/** */" permet que le commmentaire soit genere dans la javadoc
public interface File{
    /** axiome : rien car generateur de base*/
    public void enfiler(Element e) throws Exception;
    /** axiome : defiler(enfiler(e,f)) =   si estVide(f) alors f sinon enfiler(e,defiler(f)) */
    public void defiler() throws Exception;
    /** axiome :*/
    public boolean estVide();
    /** axiome :*/
    public int longueur();
    /** axiome :*/
    public Element tete() throws Exception;
}

public interface FileNonBornee extends File{
    /** axiome :*/
    public void enfiler(Element e);
}

public interface FileBornee extends File{
    /**axiome : */
    public boolean estPleine();
    /**axiome : */
    public int capacite();
}

//TD4 QUESTION 2
public class FileVector implements FileNonBornee(){
    //attributs
    private Vector corps = new Vector<Element>();
    //contructeur (correspondant au vide du TAD ici implicite)
    public void enfiler(Element e){
        corps.add(e);
    }
    public void defiler(){
        if(estVide()) throw new Exception("Defiler : file vide");
        corps.remove(0);
    }
    public boolean estVide(){
        return corps.isEmpty();
    }
    public int longueur(){
        return corps.size();
    }
    public Element tete() throws Exception{
        if(estVide()) throw new Exception("Tete : file vide");
        return corps.get();
    }
}

public class FileChainee implements FileNonBornee(){
    //attributs
    Cellule tete;
    Celulle queue;

    //constructeur
    public FileChainee(){
        /*initialisation des variable a null implicite donc pas besoin de faire :
        tete=null;
        queue=null;*/
    }

    //sous-classe
    class Cellule{
        int val;
        Cellule suiv;
        Celulle(int v){
            val=v;
            suiv=null;
        }
        // ALternative : mettre des "private" alors ajouter 3 methodes : getVal(),getSuiv(),setSuiv()
    }
    
    //methodes
    public void enfiler(int v){
        if(queue==null){
            queue=new Cellule(v);
            tete=queue;
        }
        else{
            queue.suiv=new Cellule(v);
            queue=queue.suiv;
        }
    }
    public void defiler()throws Exception{
        if(estVide()) throw new Exception("Defiler : file vide");
        tete=tete.suiv;
        if(tete==null) queue=null;
    }
    public boolean estVide(){
        return(tete==null);
    }
    public int longueur(){
        int lg=0;
        Cellule cour=tete;
        while(cour!=null){ // Attention sur "cour" et non "cour.suiv" car ca ne prend pas en compte la derniere valeur
            lg++;
            cour=cour.suiv;
        }
        return lg;
    }
    public int tete() throws Exception{
        if(estVide()) throw new Exception("Tete : file vide");
        return tete.val;
    }
}

public class FileCirculaire implements FileBornee(){
    //attributs
    int capacite=10; //taille max du tableau
    int lg; // la longueur correspond le nombre d'element actuel dans le tableau -> permettra notamment de savoir si le tableau est vide
    int tab[]; // zone de stockage
    int tete=0; // ici tete est un indice -> tab
    int queue=0; // ici queue est un indice -> tab

    //constructeurs
    public FileCirculaire(){
        capacite=c;
        tab=new int [c];
    }

    //methodes
    public void enfiler(int x)throws Exception{
        if(estPleine()) throw new Exception("Enfiler : file pleine");
        if(estVide()) tab[queue]=x;
        else tab[(queue+1)%capacite]=x;
        lg++;
    }
    public void defiler()throws Exception{
        if(estVide()) throw new Exception("Defiler : file vide");
        tete=(tete+1)%capacite;
        lg--;
        if(estVide()){
            tete=queue;
            queue=0;
        }
    }
    public boolean estVide(){
        return(lg==0);
    }
    public boolean estPleine(){
        return(lg==capacite);
    }
    public int longueur(){
        return lg;
    }
    public int capacite(){
        return capacite;
    }
    public int tete() throws Exception{
        if(estVide()) throw new Exception("Tete : file vide");
        return tab[tete];
    }
    public void enfiler(ArrayList lx) throws Exception{ //surcharge de "enfiler"
        for(int x : lx) enfiler(x);
        File tab[]=new File[3];
        tab[0]=new FileVector(); //non bornee
        tab[1]=new FileChainee(); //non bornee
        tab[2]=new FileCirculaire(5); //bornee
        for(int i=0;i<=6;i++){
            for(int j=0;j<3;j++){
                try tab[j].enfiler(i);
                catch(Exception e){
                    system.out.println(e.getMessage());
                }
            }
        }
    }
}