"""
module pour la classe Fils et ses tests
"""

class Fils  :
    """  
    Classe pour definir un fils d'un lieu ds le graphe des lieux
    """ 
    # attributs
    # //////////////////////////////////////////////
    __nom__ : int
    """  numero du sommet correspondant au fils courant """ 
    __poids__ : float
    """  poids de l'arete ayant mene a ce fils """ 
    
    # constructeur 
    # //////////////////////////////////////////////
    def __init__ (self, n : int, p : float) :
        """  constructeur
        
        :param n: numero du sommet correspondant au fils courant
        
        :param p: poids de l'arete ayant mene a ce fils
        """ 
        self.__nom__ = n
        self.__poids__ = p 
    
    
    # les methodes
    # //////////////////////////////////////////////
    def getNom(self) :
        """  recuperation du numero du sommet correspondant au fils courant
        
        :return numero du sommet correspondant au fils courant
        """ 
        return self.__nom__ 
    
    def getPoids(self) :
        """  recuperation du poids de l'arete ayant mene a ce fils
        
        :return poids de l'arete ayant mene a ce fils
        """ 
        return self.__poids__ 
    
    def __str__(self) :
        """  methode mettant le fils courant sous la forme d'une 
        chaine de caracteres en prevision d'un futur affichage
        
        :return representation du fils courant sour la forme d'une chaine de caracteres
        """ 
        return str(self.__nom__)+"-"+str(self.__poids__)
    
    def __eq__(self, f) :
        """  methode equals pour un Fils
        
        :param f: le fils avec lequel on teste
        
        :return true si f est egal au fils courant
        """ 
        return (self.__nom__ == f.__nom__) and (self.__poids__ == f.__poids__)


class __testFils__ : 
    # tests
    # //////////////////////////////////////////////
    """ 
    methode principale de test de la classe Fils
    """
    if __name__ == '__main__':
        l = Fils(0, 0.85) 
        print("l = "+str(l)) 
        print("nom = ",l.getNom(),", poids = ",l.getPoids())
        l2 = Fils(0, 0.85)
        l3 = Fils(0, 1.5)
        print("l = l2 (on attend True)", l==l2)
        print("l = l3 (on attend False)", l==l3)


