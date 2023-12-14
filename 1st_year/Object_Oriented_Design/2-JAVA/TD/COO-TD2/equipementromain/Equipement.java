package equipementromain;

public abstract class Equipement {
  String etat;
  String nom;

  public Equipement(String etat, String nom) {
    this.etat = etat;
    this.nom = nom;
  }
  
  public String getNom() {
    return nom;
  }

  public String toString() {
    return nom + " qui est " + etat;
  }  
}
