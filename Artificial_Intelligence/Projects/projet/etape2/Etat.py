"""
module pour l'état de l'etape 2
"""
from abc import ABC, abstractmethod

class Etat(ABC) :
    """ 
    classe abstraite pour representer un etat dans un espace d'etats
    """
    
    @abstractmethod
    def estSolution(self) :
        """  methode detectant si l'etat est une solution
        
        :return true si l'etat courant est une solution, false sinon
        """
        pass

    @abstractmethod
    def successeurs(self) :
        """  methode permettant de recuperer la liste des etats successeurs de l'etat courant
        
        :return liste des etats successeurs de l'etat courant
        """
        pass

    @abstractmethod
    def h(self) :
        """  methode permettant de recuperer l'heuristique de l'etat courant 
        
        :return heuristique de l'etat courant
        """
        pass

    @abstractmethod
    def k(self, e) :
        """  methode permettant de recuperer le cout du passage de l'etat courant à l'etat e
        
        :param e: un etat
        
        :return cout du passage de l'etat courant à l'etat e
        """
        pass
    
    @abstractmethod
    def displayPath(self, pere) :
        """  methode pour afficher le chemin qui a mene a l'etat courant en utilisant la map des peres
        
        :param pere: map donnant pour chaque etat, son pere 
        """
        pass
   

