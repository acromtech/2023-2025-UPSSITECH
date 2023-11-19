"""
module pour la classe GrapheDeLieux et ses tests
"""


import sys
import math
from projet.outils.Lieu import Lieu
from projet.outils.Fils import Fils


class GrapheDeLieux  :
    """  
    Classe pour definir le graphe des lieux. Chaque lieu correspond a un sommet ds le graphe. 
    Les sommets sont identifies par un numero unique a partir de 0.
    """
    
    # attributs
    # //////////////////////////////////////////////
    __lesSommets__ : list
    """  la liste des lieux composant le graphe """
    __nb__ : int
    """  le nb de lieux composant le graphe """
    __poidsMinTerre__ : float
    """  le poids minimum des aretes dans le graphe par les routes """
    __poidsMinAir__ : float
    """  le poids minimum des aretes dans le graphe par les airs """
    
    # constructeur
    # //////////////////////////////////////////////
    def __init__(self) :
        """  constructeur d'un graphe vide """
        self.__lesSommets__ = []
        self.__nb__ = 0
        self.__poidsMinTerre__ = sys.maxsize
        self.__poidsMinAir__ = sys.maxsize
    
    
    # methodes accesseurs
    # //////////////////////////////////////////////
    def getNbSommets(self) :
        """  recuperation du nb de sommets ds le graphe 
        
        :return nb de sommets ds le graphe
        """
        return self.__nb__
    
    
    def  getLesLieux(self) :
        """  recuperation de la liste des lieux composant le graphe
        
        :return liste des lieux composant le graphe
        """
        return self.__lesSommets__
    
    
    def getCoutArete(self, x : int, y : int) :
        """  recuperation du cout de l'arete entre deux sommets du graphe
        
        :param x: premier sommet
        
        :param y: second sommet
        
        :return cout de l'arete entre deux sommets x et y du graphe (0 si l'arete n'existe pas)
        """
        for f in self.__lesSommets__[x].getFils() :
            if (f.getNom() == y) :
                return f.getPoids() 
        return 0;
    
    
    def getPoidsMinTerre(self) :
        """  recuperation du cout minimum des aretes du graphe 
           (par les routes)
           
        :return cout minimum des aretes du graphe
        """   
        return self.__poidsMinTerre__ ;
    
    
    def getPoidsMinAir(self) :
        """  recuperation du cout minimum entre deux sommets du graphe 
           (par les airs)
           
        :return cout minimum des aretes du graphe
        """   
        return self.__poidsMinAir__ ;
    
    
    def getAdjacents(self, x : int) :
        """  recuperation liste des sommets adjacents a un sommet donne
        
        :param x: sommet dont on cherche les adjacents
        
        :return liste des sommets adjacents a x
        """    
        l = [] 
        for f in self.__lesSommets__[x].getFils() :
            l.append(f.getNom()) 
        return l 
    
      
    def getSommets(self) :
        """  recuperation liste des sommets du graphe
        
        :return liste des sommets du graphe
        """    
        l = [] 
        for i in range (0, self.__nb__) :
            l.append(i) 
        return l 
    
    
    # methodes modifieurs
    # //////////////////////////////////////////////
    def setNbSommets(self, n : int) :
        """ maj du nb de sommets du graphe 
        
        :param n: nb de sommets du graphe
        """
        self.__nb__ = n
    
    
    # methode pour affichage futur 
    # //////////////////////////////////////////////
    def __str__(self) :
        """  methode mettant le graphe  sous la forme d'une 
         chaine de caracteres en prevision d'un futur affichage
         
        :return representation du graphe sous la forme d'une chaine de caracteres
        """
        s = "Graphe avec "+str(self.__nb__)+" sommets : \n" 
        for l in  self.__lesSommets__ :
            s = s + str(l) +"\n"
        return s 
    
    
    # methodes pour le calcul des distances
    # //////////////////////////////////////////////
    
    # methode STATIC 
    # //////////////////////////////////////////////
    def __poidsAvDist__(g) :
        """ methode STATIC de calcul du poids min d'une arete ds un graphe en utilisant 
         la distance euclidienne entre les sommets
         
        :param g: le graphe
        
        :return poids minimal d'une arete ds le graphe
        """
        poidsMin : float = sys.maxsize
        for i in range( 0, len(g.__lesSommets__) - 1) :
            for j in range(i+1, len(g.__lesSommets__)) :
                poidsCourant : float = GrapheDeLieux.dist(i,j,g) 
                if poidsCourant < poidsMin :
                   poidsMin = poidsCourant 
        return poidsMin 
    
    
    # methode STATIC 
    # //////////////////////////////////////////////
    def dist(x1 : int, x2 : int, x3, x4 = None) :
        """  methode STATIC pour recuperer la distance euclidienne entre deux 
         lieux ou deux points d'un espace 2D.
         A utiliser avec un nb de parametres variable (soit 3, soit 4).
         
        :param x1: sommet ou abscisse premier point
        
        :param x2: sommet ou ordonnee premier point
        
        :param x3: graphe des lieux si x1 et x2 sont des lieux ou abscisse second point
        
        :param x4: rien ou ordonnee second point
        
        :return distance euclidienne entre les deux sommets x1 et x2 ou les 2 points (x1,x2) et (x3, x4)
        """
        if (x3 != None and type(x3) == GrapheDeLieux) and (x4 == None) :
           # cas ou on passe des lieux x1 et x2 d'un graphe donne x3
           a1 : int = x3.__lesSommets__[x1].getX()
           o1 : int = x3.__lesSommets__[x1].getY()
           a2 : int = x3.__lesSommets__[x2].getX()
           o2 : int = x3.__lesSommets__[x2].getY()
           return GrapheDeLieux.dist(a1,o1,a2,o2)
        else :
           if (type(x3) != int) or (x4 == None) : 
              # cas ou les parametres passes seraient errones
              return sys.maxsize
           else :
              a :float = (x3 - x1) * (x3 - x1)
              b :float = (x4 - x2) * (x4 - x2)
              val :float = math.sqrt(a + b)
              return val
    
    
    # methodes pour charger le graphe a partir d'un fichier
    # //////////////////////////////////////////////
    
      
    def __loadGraphPourColor__(filename : str) :
        """ methode STATIC pour recuperer les donnees ds des fichiers pour la coloration.
         Ds ce cas là, 
     
        - il y a juste la liste des aretes dans le fichier
        
        - les sommets sont numerotes a partir de 1 => a ramener à partir de 0
        
        - pas de poids, ni de coordonnees
        
        :param filename: nom du fichier contenant les donnees
        """
        g = GrapheDeLieux()
        fic = open(filename, "r")
        nbSom : int = 0
        lignes = fic.readlines()
        for ligne in lignes :
            s = ligne.split(" ")
            if s[0] == "e" :        
                # traiter les aretes         
                a : int = int(s[1])-1
                b : int = int(s[2])-1
                g.__lesSommets__[a].addFils(Fils(b,0)) 
                g.__lesSommets__[b].addFils(Fils(a,0))                                  
            else :
                if s[0]== "p":        
                    # la ligne commencant par p est avant ttes celles commencant par e          
                    nbSom = int(s[2])
                    g.setNbSommets(nbSom) 
                    print(g.getNbSommets())
                    # traiter les sommets
                    for i in range(0, nbSom) :
                       x : int = 0
                       y : int = 0
                       g.__lesSommets__.append(Lieu(i,x,y)) 
        fic.close()
        return(g)
    
    def __loadGraphAvPoids__(filename : str) :
        """ methode STATIC pour recuperer les donnees ds des fichiers avec poids et coordonnees.
         Ds ce cas-la, on a ds le fichier les infos suivantes :
        
        - le nb de sommets
    
        - puis la liste des coord en x et en y pour chaque sommet ds l'ordre
    
        - puis la liste des aretes avec sommet depart, sommet arrivee et poids
    
          Attention, il faut dupliquer pour avoir tous les arcs
      
          Attention, les noms des sommets vont de 0 a nb-1
          
        :param filename: nom du fichier contenant les donnees
        """
        g =  GrapheDeLieux()
        poidsMin : float = sys.maxsize
        fic = open(filename)
        lignes = fic.readlines()
        nb : int = int(lignes[0])
        g.setNbSommets(nb) 
        print(nb)
        # lecture des sommets
        for i in range(1, nb+1) : 
            tmp = lignes[i].split(" ")
            x : int = int(tmp[0])
            y : int = int(tmp[1])
            g.__lesSommets__.append(Lieu(i-1,x,y)) 
        # lecture des aretes
        for i in range(nb+1,len(lignes)) :
            tmp = lignes[i].split(" ")
            a : int = int(tmp[0])
            b : int = int(tmp[1])
            d : float = float(tmp[2])
            if d < poidsMin :
               poidsMin = d 
            g.__lesSommets__[a].addFils(Fils(b,d)) 
            g.__lesSommets__[b].addFils(Fils(a,d)) 
        fic.close()
        g.__poidsMinTerre__ = poidsMin 
        g.__poidsMinAir__ = GrapheDeLieux.__poidsAvDist__(g) 
        return g
    
    # methode STATIC pour creer le graphe a partir d'un fichier
    # //////////////////////////////////////////////
    def loadGraph(filename : str,  form : bool) :
        """   methode STATIC pour creer le graphe a partir d'un fichier
        
        :param filename: nom du fichier contenant les donnees
        
        :param form: true si le fichier correspond a un graphe avec des coordonnees et des poids, 
                     false sinon
                     
        :return le graphe des lieux cree a partir des donnees qui etaient ds le fichier
        """
        if form == True :
            return GrapheDeLieux.__loadGraphAvPoids__(filename) 
        else :
            return GrapheDeLieux.__loadGraphPourColor__(filename) 
        

class __testGrapheDeLieux__ : 
    # TESTS
    # //////////////////////////////////////////////
    """  
    methode principale de test pour la classe GrapheDeLieux
    """
    if __name__ == '__main__':
        
        g = GrapheDeLieux.loadGraph("Data/town10.txt",True)
        print("Cas 1 : le graphe contient des poids et des coordonnees :\n"+str(g)) 
        print("avec un poids min de (on attend 152.4958208392524) :"+str(g.getPoidsMinTerre())) 
        
        g = GrapheDeLieux.loadGraph("Data/town30.txt",True)
        print("Cas 1 : le graphe contient des poids et des coordonnees :\n"+str(g)) 
        print("avec un poids min de (on attend 16.3) :"+str(g.getPoidsMinTerre())) 
        
        g = GrapheDeLieux.loadGraph("Data/pb-etape1/jean.col",False)
        print("Cas 2 : le graphe ne contient pas de poids, ni de coordonnees :\n"+str(g)) 
        
        g = GrapheDeLieux.loadGraph("Data/pb-etape1/flat20_3_0.col",False)
        print("Cas 2 : le graphe ne contient pas de poids, ni de coordonnees :\n"+str(g)) 

