""" module pour le solver Tabou """

import sys

from projet.etape3.Solution import Solution

class SolverTabou :
    """ 
    Implementation du tabou 
    """ 
    
    #    attribut
    #    //////////////////////////////////////////////
    __nbSolutionsExplores__ : int = 0 
    """ metriques pour comparer les solutions : nb de solutions explorees """
    
    #    methodes
    #    //////////////////////////////////////////////
    def tabou(e : Solution, nb : int) :
        """  implementation du tabou (liste de tabou non limitee)
        
        :param e: solution de depart
        
        :param nb: nb d'essais
        
        :return renverra la meilleure solution trouvee d'apres l'algo du tabou
        """  
        
        em : Solution = e
        bestval : float = e.eval() #    meilleure valeur de reference
        courant : Solution = e
        cval : float = courant.eval() #    valeur courante
        T : list = []
        
        for i in range(0, nb) :
            
            SolverTabou.__nbSolutionsExplores__ = SolverTabou.__nbSolutionsExplores__ +1
            voisins = courant.lesVoisins()
            y : Solution = SolverTabou.__getBest__(voisins, T)
            if(y==None) :
                SolverTabou.__affMetriques__(em,nb,T) 
                return em
            
            yval : float = y.eval()
            if(yval>=cval) :
                #    le voisin est pire ou egal a la valeur courante
                #    ==> le courant devient tabou
                T.append(courant)
            if(yval<bestval) :
            
                #    le voisin est meilleur que le meilleur de reference
                #    ===> il devient le nouveau meilleur
                em=y
                bestval=yval
            
            #    ds ts les cas le voisin devient le nouveau courant
            courant=y
            cval=yval
        
        SolverTabou.__affMetriques__(em,nb,T) 
        return em
    
    
    #    recuperation du meilleur des voisins qui ne soit pas tabou
    def __getBest__(voisins : list, T : list) :
        """ methode de recuperation du meilleur voisin ds la liste des voisins qui n'est pas tabou
        
        :param voisins: liste des voisins
        
        :param T: liste des tabous
        """
        
        best : Solution = None
        val : float = sys.maxsize
        for e in voisins :
            
            v : float = e.eval()
            if (v < val) and (e not in T) :
                
                best = e
                val = v
            
        
        return best
    
    
    #    affichage des metriques
    def __affMetriques__(sol : Solution, nbEssais : int, T :list) :
        """ affichage de la solution
        
        :param sol: la solution obtenue par le solver
        
        :param nbEssais: le nb d'essais utilises pour obtenir cette solution
        
        :param T: liste des tabous
        """
        
        print("\t Il y a " +str(len(T))+" tabou(s) :")
        print("\nLa meilleure solution obtenue : "+str(sol)+"=======(arret apres "
                           +str(nbEssais)+" essais : nb d'etats explores = "
                           +str(SolverTabou.__nbSolutionsExplores__)+")========\n")
    

