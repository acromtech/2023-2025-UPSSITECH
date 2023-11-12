"""  module pour la classe abstraite solution """ 
from abc import ABC, abstractmethod


class Solution(ABC) :
    """ 
    classe abstraite pour representer une solution dans un espace de solutions
    """ 

    @abstractmethod
    def lesVoisins(self) :   
        """  methode recuperant la liste des voisins de la solution courante
        
        :return liste des voisins de la solution courante
        """ 
        pass

    @abstractmethod
    def unVoisin(self) :
        """  methode recuperant un voisin de la solution courante
        
        :return voisin de la solution courante
        """ 
        pass

    @abstractmethod
    def eval(self) :
        """  methode recuperant la valeur de la solution courante
        
        :return valeur de la solution courante
        """ 
        pass

    @abstractmethod
    def displayPath(self) :
        """  methode affichant la solution courante comme un chemin dans le graphe
        """ 
        pass

    @abstractmethod
    def nelleSolution(self)  :
        """  methode generant aleatoirement une nouvelle solution 
        a partir de la solution courante
        
        :return nouvelle solution generee aleatoirement a partir de la solution courante
        """ 
        pass


