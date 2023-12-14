public class Personne {
    
    /* Les attributs */
    private String nom ; /* attribut donnant le nom d’une personne */
    private Personne pere ; /* attribut donnant le p`ere d’une personne */
    private Personne mere ; /* attribut donnant la m`ere d’une personne */
    private boolean estVivant ; /* attribut indiquant si la personne est vivante (true)
    ou d´ec´ed´ee (false) */

    /* Les m´ethodes */

    /* les accesseurs : pour acceder aux attributs */
    public String getNom() { return nom ; }
    public Personne getMere() { return mere ; }
    public Personne getPere() { return pere ; }
    public boolean vivant() { return estVivant ; }

    /* les setteurs */
    public void setNom(String n) { nom = n ; }
    public void setMere(Personne m) { mere = m ; }
    public void setPere(Personne p) { pere = p ; }
    public void decede() { estVivant = false ; }
    public String toString() {
    String s = nom ;
    if (!estVivant) s = s+ " -d´ec´ed´e(e)- " ;
    s = s+" a pour m`ere ("+mere+") et pour pere ("+pere+")" ;
    return s ; }

    /* les constructeurs */
    public Personne (String n) { nom = n ; estVivant = true ; }
    public Personne (String n, Personne p, Personne m) {
    nom = n ; estVivant = true ; mere = m ; pere = p ; }
}

public class ArbreGen {

    /* Les attributs */
    private Personne feuilleArbre ;

    /* les constructeurs */
    public ArbreGen (Personne p) { feuilleArbre = p ; }

    /* Les m´ethodes */
    public String toString() { return ("Arbre g´en´ealogique: "+feuilleArbre) ; }

    /* le programme principal */
    public static void main (String args[]) {
    Personne p = new Personne("Alphonse");
    ArbreGen a = new ArbreGen(p) ;
    a.feuilleArbre.setMere(new Personne("Elise",new Personne("Edouard"), new Personne("Marguerite")));
    a.feuilleArbre.setPere(new Personne("Arthur",new Personne("Henri"), new Personne("Th´er`ese")));
    a.feuilleArbre.getMere().getPere().decede();
    a.feuilleArbre.getPere().getPere().decede();
    System.out.println(a) ; }
}