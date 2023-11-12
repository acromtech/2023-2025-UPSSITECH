"""
module principal pour l'etape 2
"""

from projet.outils.GrapheDeLieux import GrapheDeLieux
# rajouter ensuite le import permettant d'utiliser le solver (l'algo) choisi
# from solvers.... import ...

from projet.etape2.EtatCas1 import EtatCas1
from projet.etape2.EtatCas2 import EtatCas2
from projet.etape2.EtatCas3 import EtatCas3

class Etape2 :
    """ 
    classe pour realiser les tests de l'etape 2 du projet (execution des cas 1, 2 et 3 : tache 2) 
    """ 

    
    # tests 
    # ////////////////////////////////////////////
    """ methode de TESTS pour Etape2
    """ 
    if __name__ == '__main__':
                              
        # ///////////////////////////////////////////////
        # tests sur CAS 1 : entre 2 villes donnees
        # ///////////////////////////////////////
        # cas : 10 villes de 0 à 9
        tg = GrapheDeLieux.loadGraph("Data/town10.txt",True) 
        cas1 = EtatCas1(tg) 
        print("======== TEST CAS 1 10 villes de 0 a 9 : \n")
        # choisir ici un algo et l'executer 
                                 
        # cas : 10 villes de 5 à 9
        cas1 = EtatCas1(tg,5,9) 
        print("======== TEST CAS 1 10 villes de 5 a 9 : \n")
        # choisir ici un algo et l'executer                                
                               
        # cas : 10 villes de 2 à 9
        cas1 = EtatCas1(tg,2,9) 
        print("======== TEST CAS 1 10 villes de 2 a 9 : \n")
        # choisir ici un algo et l'executer 
                                           
        # cas : 10 villes de 1 à 7
        cas1 = EtatCas1(tg,1,7) 
        print("======== TEST CAS 1 10 villes de 1 a 7 : \n")
        # choisir ici un algo et l'executer 
        
        # cas : 26 villes de 0 à 25
        tg = GrapheDeLieux.loadGraph("Data/town30.txt",True) 
        cas1 = EtatCas1(tg) 
        print("======== TEST CAS 1 26 villes de 0 a 25 : \n")
        # choisir ici un algo et l'executer 
        
        # cas : 146 villes de 0 à 145
        tg = GrapheDeLieux.loadGraph("Data/town150.txt",True) 
        cas1 = EtatCas1(tg) 
        print("======== TEST CAS 1 146 villes de 0 a 145 : \n")
        # choisir ici un algo et l'executer 
        
        # cas : 998 villes de 0 à 997
        tg = GrapheDeLieux.loadGraph("Data/town1000.txt",True) 
        cas1 = EtatCas1(tg) 
        print("======== TEST CAS 1 1000 villes : \n")
        # choisir ici un algo et l'executer  
        
                                           
        # ///////////////////////////////////////////////
        # tests sur CAS 2 : tour complet par voie de terre
        # ///////////////////////////////////////////
        # cas : 10 villes de 0 à 9
        tg = GrapheDeLieux.loadGraph("Data/town10.txt",True) 
        cas2 = EtatCas2(tg) 
        print("======== TEST CAS 2 10 villes de 0 a 9 : \n")
        # choisir ici un algo et l'executer
        
        
        # ///////////////////////////////////////////////
        # tests sur CAS 3 : tour complet par voie des airs
        # ///////////////////////////////////////////////
        # cas : 6 villes de 0 à 5
        tg = GrapheDeLieux.loadGraph("Data/town6.txt",True) 
        cas3 = EtatCas3(tg) 
        print("======== TEST CAS 3 6 villes de 0 a 5 : \n")
        # choisir ici un algo et l'executer 
                                                        
        # cas : 7 villes de 0 à 6
        tg = GrapheDeLieux.loadGraph("Data/town7.txt",True) 
        cas3 = EtatCas3(tg) 
        print("======== TEST CAS 3 7 villes de 0 a 6 : \n")
        # choisir ici un algo et l'executer 
        
        # cas : 8 villes de 0 à 7
        tg = GrapheDeLieux.loadGraph("Data/town8.txt",True) 
        cas3 = EtatCas3(tg) 
        print("======== TEST CAS 3 8 villes de 0 a 7 : \n")
        # choisir ici un algo et l'executer                         
        
        # cas : 9 villes de 0 à 8
        tg = GrapheDeLieux.loadGraph("Data/town9.txt",True) 
        cas3 = EtatCas3(tg) 
        print("======== TEST CAS 3 9 villes de 0 a 8 : \n")
        # choisir ici un algo et l'executer                          
        
        # cas : 10 villes de 0 à 9
        tg = GrapheDeLieux.loadGraph("Data/town10.txt",True) 
        cas3 = EtatCas3(tg) 
        print("======== TEST CAS 3 10 villes de 0 a 9 : \n")
        # choisir ici un algo et l'executer                          
        
        # cas : 11 villes de 0 à 10
        tg = GrapheDeLieux.loadGraph("Data/town11.txt",True) 
        cas3 = EtatCas3(tg) 
        print("======== TEST CAS 3 11 villes de 0 a 10 : \n")
         # choisir ici un algo et l'executer                                    
                                                                                                        

