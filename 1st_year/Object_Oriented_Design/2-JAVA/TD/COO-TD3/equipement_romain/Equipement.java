package equipement_romain;

public abstract class Equipement {
  String nom;

  public Equipement(String nom) {
    this.nom = nom;
  }
  
  public String getNom() {
    return nom;
  }

  public String toString() {
    return nom;
  }
}
