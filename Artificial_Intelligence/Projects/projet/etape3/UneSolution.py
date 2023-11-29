"""  module pour la classe UneSolution """ 

from projet.outils.GrapheDeLieux import GrapheDeLieux
from projet.etape3.Solution import Solution

class UneSolution(Solution) :
    """  
    Classe pour definir une solution pour le cas 3 de la tache 2 (hérite de Solution)
    """ 
    
    
    #    attributs
    #    A COMPLETER
    #    //////////////////////////////////////////////
    tg : GrapheDeLieux
    """  le graphe representant le monde """ 
    
    #    constructeurs
    #    A ECRIRE/COMPLETER
    #    //////////////////////////////////////////////
    def __init__(self, tg : GrapheDeLieux) :
        """  constructeur d'une solution a partir du graphe representant le monde
        
        :param tg: graphe representant le monde
        """ 
        #    A ECRIRE en completant eventuellement par des parametres optionnels
        self.tg = tg
    
    
    
    #    methodes de la classe abstraite Solution
    #    //////////////////////////////////////////////
    def lesVoisins(self) :
        """  methode recuperant la liste des voisins de la solution courante
        
        :return liste des voisins de la solution courante
        """ 
        #    A ECRIRE et MAJ la valeur retournee
        return None 
    

    def unVoisin(self) : 
        """  methode recuperant un voisin de la solution courante
        
        :return voisin de la solution courante
        """ 
        #    A ECRIRE et MAJ la valeur retournee
        return None 
    

    def eval(self) : 
        """  methode recuperant la valeur de la solution courante
        
        :return valeur de la solution courante
        """ 
        #    A ECRIRE et MAJ la valeur retournee
        return 0
    
    
    def nelleSolution(self) : 
        """  methode generant aleatoirement une nouvelle solution 
        a partir de la solution courante
        
        :return nouvelle solution generee aleatoirement a partir de la solution courante
        """ 
        #    A ECRIRE et MAJ la valeur retournee
        return None 
    
    
    def displayPath(self) : 
        """  methode affichant la solution courante comme un chemin dans le graphe
        """ 
        #    A ECRIRE
        print("la meilleure solution est :")
    
    
    #    methodes pour pouvoir utiliser cet objet dans des listes et des map
    #    //////////////////////////////////////////////
    def __hash__(self) :
        """  methode permettant de recuperer le code de hachage de la solution courante
        pour une utilisation dans des tables de hachage
        
        :return code de hachage
        """ 
        #    A ECRIRE et MODIFIER le return en consequence
        return 0 
    
    
    def __eq__(self,o) :
        """  methode de comparaison de la solution courante avec l'objet o
        
        :param o: l'objet avec lequel on compare
        
        :return True si la solution courante et o sont egaux, False sinon
        """ 
        #    A ECRIRE et MODIFIER le return en consequence
        return False 
    
    
    
    #    methode pour affichage futur (heritee d'Object)
    #    //////////////////////////////////////////////
    def __str__(self) : 
        """  methode mettant la solution courante sous la forme d'une 
        chaine de caracteres en prevision d'un futur affichage
        
        :return representation de la solution courante sour la forme d'une chaine de caracteres
        """ 
        #    A ECRIRE et MODIFIER le return en consequence
        return "" 
    


