// TD2 : La bibliotheque
public class Exemplaire{
    protected String _editeur;
    protected int _annee;
    protected String _cote;
    protected boolean _emprunte;
    public Exemplaire (String editeur, int annee, String cote){
        _editeur = editeur;
        _annee = annee;
        _cote = cote;
    }
    public String getCote(){
        return _cote;
    }
    public boolean isEmprunte(){
        return _emprunte;
    } 
    public void setEmprunte(){
        _emprunte = true;
    }
    public void setRetourne(){
        _emprunte = false;
    }
    public String toString(){
        String s = _cote + ", "+_editeur+", ";
        if (_emprunte) return s + "emprunte";
        else return s + "dispo";
    }

    //AJOUT DE EQUALS POUR add_e
    public boolean equals(Object o){
        Exemplaire ex=(Exemplaire)o;
        return(ex.cote==o.cote);
    }
}

public class Ouvrage{
    //ATTRIBUTS
    protected String titre;
    protected String auteur;
    protected ArrayList<Exemplaire>lesExemplaires; //permet de préciser le type du contenu des exemplaires
    
    //CONSTRUCTEURS
    public Ouvrage(String t, String a){
        titre=new String(t)//titre=t; moins bien car risque de remplacer on préfère donc re-créer de nouveaux objets
        auteur=new String(a)//auteur=a; moins bien car risque de remplacer on préfère donc re-créer de nouveaux objets
        lesExemplaires=new ArrayList<Exemplaire>()
    }
    
    //METHODES
    public void add_e(String c, String e, int a){
        //lesExemplaires.add(new Exemplaire(e,a,c)); n'est pas assez robuste
        Exemplaire ex=new Exemplaire(e,a,c);
        if(!lesExemplaires.contains(ex))
            lesExemplaires.add(ex);
            //Contains n'utilise equals -> obligation de redeffinir le equals dans Exemplaire
    }
    /*Deux possibilités :
     *  -"string emprunter" qui va renvoyer la cote du premier explaire trouvé correspondant a l'ouvrage recherché
     *  -"void emprunter" qui va stocker la cote de l'exemplaire dans le paramètre c
    */
    public String emprunter(){
        for(int i;i<lesExemplaires.size();i++){
            Exemplaire e=lesExemplaires.get(i);
        /*Autre variante :
         * for(Exemplaire e:lesExemplaires){
        */
            if(!e.isEmprunte()) return e.getCote();
        }
        //cas ou aucun explaire n'ext dispo
        throw new Exeption("Pas d'exemplaires dispo"); //au lieu de "return null;" car c'est sale
    }
    public void emprunter(String c){
        for(Exemplaire e : lesExemplaires){
            if((e.getCote()==c)&&(!e.isEmprunte())) break;
        throw new Exeption("Emprunt impossible");
        }
        /*Autre variante :
         * Exemplaire e=new Exemplaire("","",c);
         * int i=lesExemplaires.indexOf(e);
         * if(i=-1) throw new Exeption("l'exemplaire n'existe pas");
         * if(lesExemplaires.get(i).isEmprunte()) throw new Exeption("Pas dispo");
         * lesExemplaires.get(i).setEmprunte();
        */
    }
    public void removeExemplaire(String c){
        int i=0;// on doit sortir le i du for sinon la dernière ligne va générer une erreur
        for(;i<lesExemplaires.size();i++){
            if(e.getCote()==c) break;
        }
        if(i<lesExemplaires.size()) lesExemplaires.remove(i);

        /* Autre variante :
         * Exemplaire eaux;
         * for(Exemplaire e : lesExemplaires){
         *      eaux=e; 
         *      if(e.getCote()==e) break;
         * }
         * lesExemplaires.remove(eaux);
         */
        
        /* Autre variante :
         * Exemplaire e =new Exemplaire("","",c);
         * lesExemplaires.remove(e);
         */
    }
}
