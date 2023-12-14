class Personne {
    
    private :
    /* Les attributs */
    bool estVivant ; /* attribut indiquant qu’une personne est vivante ou pas */
    string nom ; /* attribut donnant le nom d’une personne */
    Personne * pere = NULL ; /* attribut acc´edant au p`ere d’une personne */
    Personne * mere = NULL ; /* attribut acc´edant `a la m`ere d’une personne */
    
    public :
    /* Les methodes */
    string getNom() { return nom ; }
    bool vivant() { return estVivant ; }
    Personne* getMere() { return mere ; }
    Personne* getPere() { return pere ; }
    void setNom(string n) { nom = n ; }
    void decede() { estVivant = false ; }
    void setMere(Personne* m) { mere = m ; }
    void setPere(Personne* p) { pere = p ; }
    string toString() {
        string s = nom ;
        if (!estVivant) s = s+ " -d´ec´ed´e(e)- " ;
        if (mere != NULL) s = s+" a pour m`ere ("+mere->toString()+")";
        if (pere != NULL) s = s +" et pour pere ("+pere->toString()+")" ;
        return s ; }

    /* les constructeurs */
    Personne (string n) { nom = n ; estVivant = true ; }
    Personne (string n, Personne * p, Personne * m) {
    nom = n ; estVivant = true ; mere = m ; pere = p ; }
};

class ArbreGen {

    public :
    /* Les attributs */
    Personne * feuilleArbre ;

    /* les constructeurs */
    ArbreGen (Personne * p) { feuilleArbre = p ; }

    /* Les methodes */
    string toString() {
    return ("Arbre g´en´ealogique: "+feuilleArbre->toString()) ; }
    } ;

    /* le programme principal */
    int main(int argc, char *argv[]) {
    Personne * p = new Personne("Alphonse");
    ArbreGen a (p) ;
    a.feuilleArbre->setMere(new Personne("Elise",new Personne("Edouard"),
    new Personne("Marguerite")));
    a.feuilleArbre->setPere(new Personne("Arthur",new Personne("Henri"),
    new Personne("Th´er`ese")));
    a.feuilleArbre->getMere()->getPere()->decede();
    a.feuilleArbre->getPere()->getPere()->decede();
    cout << a.toString() ;
}