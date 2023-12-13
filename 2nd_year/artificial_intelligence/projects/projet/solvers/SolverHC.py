""" module pour le solver Hill Climbing """

from projet.etape3.Solution import Solution

class SolverHC :
    """ 
    implementation du hillclimbing. Differentes versions. 
    """ 
    
    #    attribut
    #    //////////////////////////////////////////////
    __nbSolutionsExplores__ : int = 0 
    """ metriques pour comparer les solutions : nb de solutions explorees """

    #    methodes
    #    //////////////////////////////////////////////
    def hilClimbing2(eRef : Solution, nbEssai: int) :
        """  implementation du hillclimbing avec plusieurs essais possibles et, 
          a chaque essai, tirage aleatoire d'une nouvelle solution de depart
          
        :param eRef: solution de depart
        
        :param nbEssai: nb d'essais à faire
        
        :return renverra la meilleure solution trouvee
        """ 
        
        SolverHC.__nbSolutionsExplores__ = 0
        best : Solution = eRef
        e : Solution = eRef 
        bestval : float = eRef.eval()
        for  i in range(0, nbEssai) :
          flag : bool = True
          while (flag) :
            SolverHC.__nbSolutionsExplores__ = SolverHC.__nbSolutionsExplores__ + 1
            flag = False
            v : Solution = e.unVoisin()[0]
            if (v.eval() < e.eval()) :
                #    on ameliore
                e = v 
                flag = True
          
          
          #    plus d'amelioration pour cet essai
          if (e.eval() < bestval) :
            bestval = e.eval()
            best = e
          
          #    tirage nelle solution pour essai suivant
          e = eRef.nelleSolution() 
        
        SolverHC.__affMetriques__(best,nbEssai,1) 
        return best
    


    def hilClimbing(e : Solution, nbEssai : int = None) :
        """  implementation du hillclimbing avec un seul ou plusieurs essais possibles
        
        :param e: solution de depart
        
        :param nbEssai: nb d'essais à faire (si param absent alors un seul essai)
        
        :return renverra la meilleure solution trouvee
        """ 
        
        SolverHC.__nbSolutionsExplores__ = 0
        best : Solution = e
        bestval : float = e.eval()
        flag : bool = True
        if nbEssai == None :
            while (flag) :
                
                SolverHC.__nbSolutionsExplores__ = SolverHC.__nbSolutionsExplores__ +1
                flag = False
                v : Solution = e.unVoisin()[0]
                if (v.eval() < e.eval()) :
                    e = v 
                    flag = True
        else :
            for i in range(0, nbEssai) :
                
                SolverHC.__nbSolutionsExplores__ =  SolverHC.__nbSolutionsExplores__ + 1
                v : Solution= e.unVoisin()[0]
                if (v.eval() < e.eval()) :
                    e = v 
        
        
        if (e.eval() < bestval) :
            bestval = e.eval()
            best = e
        
        if nbEssai == None :
            SolverHC.__affMetriques__(best,1,2) 
        else :
            SolverHC.__affMetriques__(best,nbEssai,3) 
        return best
    


    #    affichage des metriques
    def __affMetriques__(sol : Solution, nbEssais : int, cas :int) : 
        """ affichage des resultats
        
        :param sol: la solution obtenue par le solver
        
        :param nbEssais: le nb d'essais utilises pour obtenir cette solution
        
        :param cas: le type de solver utilise 
        
            -> 1 : HC avec plusieurs essais et tirage aleatoire d'une nelle solution pour chaque essai
            
            -> 2 : HC avec un seul essai
            
            -> 3 : HC avec plusieurs essais mais pas de tirage aleatoire d'une nelle solution 
              pour chaque essai
        """
        if cas == 1 :
           print("HC avec plusieurs essais et tirage aleatoire d'une nelle solution pour chaque essai") 
        else :
           if cas == 2 :
              print("HC avec un seul essai") 
           else :
              if cas == 3 :
                 print("HC avec plusieurs essais mais pas de tirage aleatoire d'une nelle solution pour chaque essai") 
              else :
                 print("Pas normal !!") 
        
        print("\nLa meilleure solution obtenue : "+str(sol)+"=======(arret apres "
                           +str(nbEssais)+" essais : nb d'etats explores = "
                           +str(SolverHC.__nbSolutionsExplores__)+")========\n")
    


