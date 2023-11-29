""" module pour le solver CSP """

from constraint import *

from projet.outils.GrapheDeLieux import GrapheDeLieux


class SolverCSP :
    """ 
    Implementation du solveur CSP 
    """ 

    #    attributs
    #    //////////////////////////////////////////////
    #    metriques pour comparer les solutions
    __problem__ : Problem
    """ le problem CSP a resoudre """
    __nbCouleurs__ : int
    """ le nb de couleurs utilise pour la resolution """
    __lesVariables__ : list
    """ la liste des variables du CSP """
    
    #    constructeur
    def __init__ (self, g : GrapheDeLieux, nb : int) : 
        """  construction du solver
        
        :param g: graphe des lieux (chaque sommet sera une variable et 
                 chaque arete induira une contrainte disant que les 
                 deux extremités doivent etre differentes)
                 
        :param nb: nb de valeurs possibles pour les variables (de 1 a nb)
        """  
        self.__problem__ = Problem()
        self.__nbCouleurs__ = nb
        self.__lesVariables__ = g.getSommets()
        domaine = []
        #    construction du domaine (le même pour toutes les variables)
        for i in range(1,nb+1) :
            domaine.append(i)
        #    ajout des variables avec leur domaine ds le CSP
        self.__problem__.addVariables (self.__lesVariables__, domaine)   
        #    construction des contraintes associees
        for  v1 in self.__lesVariables__ :       
             for  v2 in g.getAdjacents(v1) :
                  if v2 >= v1 :
                     l : list = []
                     l.append(v1)
                     l.append(v2)
                     self.__problem__.addConstraint(self.__fcDifferentIfConnected__,l)
    
    
    #    methodes
    #  //////////////////////////////////
    #    calcul de la contrainte
    def __fcDifferentIfConnected__ (self, s1 : int, s2 : int) :
        """ pour construire la contrainte du CSP disant que deux sommets connectes
            ne doivent pas avoir la meme valeur
            
        :param s1 : valeur du sommet 1
        
        :param s2 : valeur du sommet 2
        """
        return s1 != s2
    
    #    affichage des metriques
    def __affMetriques__(self, complet : bool, res) :
        """ pour afficher le resultat
        
        :param complet: si True le resultat est l'ensemble de toutes les solutions
                        si False le resultat est une seule solution
        
        :param res: le resultat de la resolution du pb par le solveur CSP
        """
        if (res != None and len(res)  != 0) :
            st = "======== OK avec "+str(self.__nbCouleurs__)+" couleurs !\n\t | " 
            if complet : # cas ou il y a plusieurs solutions
               st = st +" \t (nb de solutions = "+str(len(res)) +")\n\t"  
               for sol in res :
                  for cle in self.__lesVariables__ :
                     st = st + str(cle) +" = "+str(sol[cle])+" | "  
                  st = st +"\n\t"  
            else : # cas ou il y a une seule solution
               for cle in self.__lesVariables__ :
                  st = st + str(cle) +" = "+str(res[cle])+" | "  
        else :
            st = "======== NOK ! Pas de solution"
        print (st)
    
    def solve(self, complet : bool) :
        """  execution du solver pour avoir 1 solution
        
        :param complet: False si on veut une seule solution, True si on les veut toutes
        """  
        #    resolution du CSP
        if not complet :
           res = self.__problem__.getSolution()
        else :
           res = self.__problem__.getSolutions()
        self.__affMetriques__(complet, res) 
        

