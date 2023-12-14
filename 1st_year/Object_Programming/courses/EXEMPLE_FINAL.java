enum Statut{MILITAIRE,NEUTRE};
enum Nature{HUMAIN,IA};
enum TypeNav{CHALUTIER,DESTROYER,SOUSMARIN};
enum Action{DEPLACEMENT,TIR,PECHE};
enum Direction{NORD,SUD,EST,OUEST};

public interface Joueur{
    public interface JHumain extends Joueur{

    }
    public interface JIA extends Joueur{
    
    }
}

public class Jeu{
    public class Plateau{
        public class CasePlateau{

        }
    }
    public class Equipe implements JHumain JIA{
        /* Equipe avec capacite de tir (impact sur le type de commande disponible) */
        public class EqBataillon extends Equipe{

        }

        /* Equipe avec capacite de peche (impact sur le type de commande disponible) */
        public class EqPecheur extends Equipe{

        }
    }
    public class Commande{
        /* DEUX EXCEPTIONS :
         *      OccupException : pour traiter le cas ou un deplacement ne serait pas possible car il y a dej`a trop de navires dans la case ciblee, 
         *      LimiteException : pour traiter le cas ou un deplacement ou un tir ne seraient pas possibles car la position visee serait hors du plateau.
         */
    }
    public class Navire{
        public class NavireSurface extends Navire{
            public class Destroyer extends NavireSurface{

            }
            public class Chalutier extends NavireSurface{

            }
        }
        public class NavireProfondeur extends Navire{
            public class SousMarin extends NavireProfondeur{

            }
        }
    }
}





