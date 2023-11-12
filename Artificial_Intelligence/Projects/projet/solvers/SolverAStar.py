""" module pour le solver AStar """

from projet.outils.GrapheDeLieux import GrapheDeLieux
from projet.etape2.Etat import Etat

"""    
 * implementation du A etoile 
 """    
class SolverAStar :
    """    
    Implementation du A etoile 
    """    

    #    attributs
    #    //////////////////////////////////////////////
    __nbEtatsExplores__ : int = 0 
    """     metrique pour comparer les solutions : nb d'etat explores """    
    __nbEtatsGeneres__ : int = 0 
    """     metrique pour comparer les solutions : nb d'etat generes """    
    
    #    methodes
    #    //////////////////////////////////////////////
    def aStar(e : Etat) :
        """    implementation du A etoile pour la recherche du plus court chemin 
         depuis l'état e jusqu'à trouver une solution
         
        :param e: etat de depart de la recherche
        
        :return renverra l'etat solution s'il existe ou null sinon 
        """    
    
        SolverAStar.__nbEtatsExplores__ = 0  
        SolverAStar.__nbEtatsGeneres__ = 0 
        #    liste A_Faire, sera triee par ordre decroissant
        AF = []
        #    on utilise des tables de hachage pour faciliter l'acces 
        #    aux infos : ici l'etat sert de cle et permet d'acceder 
        #    aux valeurs de f, g et au pere
        f : dict = {}      # HashMap<Etat, Double>()
        g : dict = {}      # HashMap<Etat, Double>()
        pere : dict = {}   # HashMap<Etat, Etat>()
        f[e] = 0
        g[e] = 0
        pere[e] = None
        AF.append(e)
        SolverAStar.__nbEtatsGeneres__ =  SolverAStar.__nbEtatsGeneres__ + 1
        while len(AF) != 0 :
            
            courant = SolverAStar.__getBest__(AF, f)
            SolverAStar.__nbEtatsExplores__ =  SolverAStar.__nbEtatsExplores__ + 1
            
            gcourant = g[courant] #    poids de courant

            if (courant.estSolution()) :
                courant.displayPath(pere) 
                print("la lg du plus court chemin est ",g[courant]) 
                SolverAStar.__affMetrique__(courant) 
                return courant
            
            lesFils = courant.successeurs() 
            SolverAStar.__nbEtatsGeneres__ = SolverAStar.__nbEtatsGeneres__ + len(lesFils)           
            for s in lesFils :
                
                #    poids de courant + (poids successeur - poids courant)
                gsuivant = gcourant + courant.k(s)
                if ( s not in g ) :                    
                    #    nouvel etat 
                    #    donc mise a jour des tables de hachage et de AF
                    g[s] = gsuivant
                    f[s] = gsuivant + s.h()
                    pere[s] = courant
                    SolverAStar.__ajoutDsAF__(AF,s,f)
                
                else :
                    if g[s] > gsuivant :                        
                        #    on a ameliore le score du successeur
                        #    donc remise a jour des tables de hachage
                        g[s] = gsuivant
                        f[s] = gsuivant + s.h()
                        pere[s] = courant
                        #    remise ds AF s'il n'y est plus
                        if (s not in AF) :
                            SolverAStar.__ajoutDsAF__(AF,s,f)
                                            
        return None
    

    def aStarOpti(e : Etat) :
        """    implementation du A etoile optimise pour la recherche du plus 
          court chemin depuis l'état e jusqu'à trouver une solution
         (l'optimisation consiste à ne pas memoriser les peres, donc 
          a n'utiliser que si la liste des peres n'a pas d'importance)
          
        :param e: etat de depart de la recherche
        
        :return renverra l'etat solution s'il existe ou null sinon 
        """    
    
        SolverAStar.__nbEtatsExplores__ = 0  
        SolverAStar.__nbEtatsGeneres__ = 0 
        #    liste A_Faire, sera triee par ordre decroissant
        AF = []
        #    on utilise des tables de hachage pour faciliter l'acces 
        #    aux infos : ici l'etat sert de cle et permet d'acceder 
        #    aux valeurs de f, g 
        f : dict = {}      # HashMap<Etat, Double>()
        g : dict = {}      # HashMap<Etat, Double>()
        f[e] = 0
        g[e] = 0
        AF.append(e)
        SolverAStar.__nbEtatsGeneres__ =  SolverAStar.__nbEtatsGeneres__ + 1 
        while len(AF) != 0 :
            
            courant = SolverAStar.__getBest__(AF,f)
            #print("AF = ",SolverAStar.__afficheAF__(AF))
            #print("courant = ",courant)
            SolverAStar.__nbEtatsExplores__ =  SolverAStar.__nbEtatsExplores__ + 1
            
            gcourant = g[courant] #    poids de courant

            if (courant.estSolution()) :
                courant.displayPath() 
                print("la lg du plus court chemin est ",g[courant]) 
                SolverAStar.__affMetrique__(courant) 
                return courant
            
            lesFils = courant.successeurs() 
            SolverAStar.__nbEtatsGeneres__ = SolverAStar.__nbEtatsGeneres__ + len(lesFils)           
            for s in lesFils :
                
                #    poids de courant + (poids successeur - poids courant)
                gsuivant = gcourant + courant.k(s)
                if ( s not in g) :                    
                    #    nouvel etat 
                    #    donc mise a jour des tables de hachage et de AF
                    g[s] = gsuivant
                    f[s] = gsuivant + s.h()
                    SolverAStar.__ajoutDsAF__(AF,s,f)
                
                else :
                    if g[s] > gsuivant :                        
                        #    on a ameliore le score du successeur
                        #    donc remise a jour des tables de hachage
                        g[s] = gsuivant
                        f[s] = gsuivant + s.h()
                        #    remise ds AF s'il n'y est plus
                        if (s not in AF) :
                            SolverAStar.__ajoutDsAF__(AF,s,f)
                                            
        return None
    

    def __getBest__(AF : list, f : dict) :    
        """ recherche du meilleur suivant la valeur de f """    
        e : Etat = AF[len(AF)-1]
        AF.pop () 
        return e 
    
    

    def __ajoutDsAF__(AF : list, s : Etat, f : dict) :  
        """ mise a jour de AF avec l'etat s en respectant l'ordre 
         decroissant impose par f """    
        val = f[s] 
        i = 0
        while (i < len(AF) and (f[AF[i]] > val)) :
           i = i + 1
        if i == len(AF) :
           AF.append(s) 
        else :
           AF.insert(i,s) 
      
    
    def __afficheAF__(AF : list) :
        """ pour affichage de la liste des etats a voir """    
        s : str = "" 
        for e in AF : 
           s = s +str(e) + " - " 
        
        return s 
      

    def __affMetrique__(sol : Etat) :
        """ affichage des metriques """    
        print(str(sol)+"\n=======(nb d'etats explores = "
                                   +str(SolverAStar.__nbEtatsExplores__)+")========\n"
                                   +"=======(nb d'etats generes = "
                                   +str(SolverAStar.__nbEtatsGeneres__)+")========\n")
    

