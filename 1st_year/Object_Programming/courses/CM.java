/*
 * Rappel : 6 exception identifiées
 * A : Exemplaire existe déja
 * B : Exemplaire n'existe pas
 * C : Exemplaire non emprunté
 * D : Ouvrage existe déja
 * E : Ouvrage existe déjà
 * F : pas d'exemplaire dispo
 * 
 * On choisi d'utiliser une hiérarachisation basé sur le modèle suivant :
 * Classe mère Exist                            Classe filles : A et D
 * Classe mère NExist                           Classe filles : B et E
 * Classe mère empruntRetour                    Classe filles : C et F
 * Classe mère Exception (préintégré dans Java) Classe filles : Exist, NExist, empruntRetour
 */

 public class Exist extends Exception{
    public Exist(){
        super("Pb d'existance");
    }
 }
 public class A extends Exist{
    private laCote;
    public A(String c) {
        super();
        this.laCote=c;
    }
    public String getMessage(){
        return(super.getMessage()+"dans l'exemplaire"+this.laCote);
    }
}

/*
 * TD Biblio
 * On complete avec le fait qu'il existe maintenant des emprunteurs identifiées par 1 nom et 1 numéro d'abonné unique
 */


public class D{

}

 public class NExist{
    public NExist(){
        super("Pb de non existance");
    }
    public class B{
        
    }
    public class E{
        
    }
 }

 public class empruntRetour{
    public empruntRetour(){
        super("Pb lors de l'emprunt retour");
    }
    public class C{
        
    }
    public class F{
        
    }
 }