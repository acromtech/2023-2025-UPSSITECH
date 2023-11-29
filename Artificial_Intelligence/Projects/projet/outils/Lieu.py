"""
module pour la classe Lieux et ses tests
"""

from projet.outils.Fils import Fils

class Lieu  :
    """ 
    Classe pour definir un lieu du graphe des lieux
    """
    # attributs
    # //////////////////////////////////////////////
    __nom__ : int 
    """ numero du sommet correspondant au lieu courant """
    __x__ : int
    """ coordonnee x (abscisse) du lieu courant """
    __y__ : int
    """ coordonnee y (ordonnee) du lieu courant """
    __lesFils__ : list
    """ liste des fils du lieu courant """
    
    # constructeur 
    # //////////////////////////////////////////////
    def __init__ (self, n : int, x : int, y : int) :
        """ constructeur
        
        :param n: numero du sommet correspondant au lieu courant 
        
        :param x: abscisse du lieu courant 
        
        :param y: ordonnee du lieu courant
        """
        self.__nom__ = n 
        self.__x__ = x 
        self.__y__ = y 
        self.__lesFils__ = [] ;
    
    # les methodes
    # //////////////////////////////////////////////
    def getFils(self) : 
        """ recuperation liste des fils du lieu courant 
        
        :return  liste des fils du lieu courant 
        """
        return self.__lesFils__ 
    
    def getX(self) :
        """ recuperation abscisse du lieu courant 
        
        :return abscisse du lieu courant 
        """
        return self.__x__ 
    
    def getY(self) :
        """ recuperation ordonnee du lieu courant 
        
        :return ordonnee du lieu courant 
        """
        return self.__y__ 
    
    def getNom(self) :
        """ recuperation numero du sommet correspondant au lieu courant
         
        :return numero du sommet correspondant au lieu courant 
        """
        return self.__nom__ 
     
    def __containsFils__(self, f : Fils) :
        """ verification de l'appartenance d'un fils à la liste des fils du lieu courant 
        
        :param f: fils qu'on cherche ds la liste des fils du lieu courant 
        
        :return True si f est ds la liste, False sinon 
        """
        for x in self.__lesFils__ :
            if x == f : 
                return True
        return False
        
    def addFils(self, f : Fils) :
        """ ajout d'un fils à la liste des fils du lieu courant 
        
        :param f: fils a ajouter à la liste des fils du lieu courant 
        """
        if not self.__containsFils__ (f) :
            self.__lesFils__.append(f) 

    def __str__(self) :
        """ methode mettant le lieu courant sous la forme d'une 
         chaine de caracteres en prevision d'un futur affichage
        :return representation du lieu courant sour la forme d'une chaine de caracteres
        """
        s = "("+str(self.__nom__)+",(" 
        for f in self.__lesFils__ :
            s = s + str(f) +" / " 
        return s +"))" 

class __testLieu__ : 
    # tests
    # //////////////////////////////////////////////
    """ methode principale de test pour la classe Lieu
    """
    if __name__ == '__main__':
        l = Lieu(0, 50, 100) 
        print("l = "+str(l)) 
        l.addFils(Fils(1,0.56))
        print("l = "+str(l)) 
        l.addFils(Fils(2,3.14))
        print("l = "+str(l)) 
        print("nom = ",l.getNom(),", x = ",l.getX(),", y = ",l.getY())
        print("les fils = ",str(l.getFils()))
        l.addFils(Fils(2,3.14))
        print("l = "+str(l)) 


