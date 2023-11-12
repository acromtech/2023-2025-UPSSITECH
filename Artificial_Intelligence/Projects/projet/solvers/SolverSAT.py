""" module pour le solver SAT """

from pysat.formula import CNF
from pysat.solvers import Solver

class SolverSAT :
    """    
    implementation du solverSAT 
    """    

    
    def solve(base) : 
        """
        methode d'appel du solver sur la base de clauses representant le pb traite
        
        :param base: la base de clauses ; 
        la base est une liste de listes d'entiers non nuls ;
        chaque valeur absolue d'un entier correspond a une variable du pb logique ;
        si l'entier est positif dans la clause, cela correspond a un literal positif ;
        si l'entier est negatif dans la clause, cela correspond a un literal negatif.
        
        :return True si la base de clauses representant le probleme est satisfiable, 
                 False sinon
        """
        cnf = CNF(from_clauses = base)
        with Solver(bootstrap_with=cnf) as solver:
            return solver.solve()     

