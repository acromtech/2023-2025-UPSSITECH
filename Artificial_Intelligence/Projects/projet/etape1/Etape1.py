# import os
# os.system("export PYTHONPATH=$PYTHONPATH:~/UPSSITECH/Artificial_Intelligence/Projects")

from outils.GrapheDeLieux import GrapheDeLieux
from solvers.SolverSAT import SolverSAT

class Etape1:  # For Task 1
    # ATTRIBUTES
    g: GrapheDeLieux  # The graph representing the world
    base: list  # The clause base representing the problem.
    # It is a list of lists of integers, one integer per variable
    # (positive if positive literal, negative otherwise).
    # Note that 0 is not allowed to represent a variable (updated by updateBase)
    nbVariables: int  # The number of variables used to represent the problem (updated by updateBase)

    # CONSTRUCTOR
    def __init__(self, fn: str, form: bool):
        # :param fn: the filename containing the vertices and edges
        # :param form: used to distinguish between different types of files
        # (for those containing weights and coordinates, form is True; for others, form is False)

        self.g = GrapheDeLieux.loadGraph(fn, form)
        self.base = []  # Base (edge list + node list + color list)
        self.color = []  # Color possibilities list
        self.node = []  # Color possibilities for each node list
        self.edge = []  # Constraints list (graph edges / node links)
        self.nbVariables = 0  # Initial color number

        # Set lists to sorted lists
        self.color.sort()
        self.node.sort()
        self.edge.sort()

    # METHOD
    def updateBase(self, x: int):  # Method to update the clause base and the number of variables based on the problem being solved
        # Initialization
        self.base.clear()
        self.color.clear()
        self.node.clear()
        self.edge.clear()
        self.nbVariables = x * (self.g.getNbSommets())

        # Set up the possible color choices for each state of the graph
        # Example: for 3 colors and a given state, we will have (1001, 1002, 1003)
        # Example: for 4 colors and 2 given states, we will have (1001, 1002, 1003, 1004), (2001, 2002, 2003, 2004)
        for node in range(self.g.getNbSommets()):  # For all graph states
            for color in range(x):  # For all colors
                self.color.extend([(color + 1) + 1000 * (node + 1)])  # Store all color possibilities (up to 999 colors)
                for edge in self.g.getAdjacents(node):  # For all node edges
                    if (1000 + (color + 1) + 1000 * node) != ((edge + 1) * 1000 + (color + 1)):  # If it's not the same node
                        self.edge.append([-(1000 + (color + 1) + 1000 * node),
                                          -((edge + 1) * 1000 + (color + 1))])  # Add the color constraint to the edge list for the node

            self.node.append(self.color)  # Store in a new list for all nodes
            self.color = []  # Empty the color list for the next time

        # Include node, edge, and color constraints in the base list
        self.base.extend(self.node)  # Fill the base with the node list
        self.base.extend(self.edge)  # Fill the base with the edge list

    def runSolver(self):  # Method to call the solver on the clause base representing the problem
        return SolverSAT.solve(self.base)  # :return True if the clause base representing the problem is satisfiable, False otherwise

    def displayBase(self):  # Display the clause base representing the problem
        print('Clause base uses', self.nbVariables, 'variables and contains the following clauses:')
        for clause in self.base:
            print(clause)

class TestStep1:  # Main testing method
    # TESTS
    if __name__ == '__main__':
        step = Etape1("Data/town10.txt", True)
        step.updateBase(3)
        print("town10 with 3 colors (expecting True): ", step.runSolver())
        step.updateBase(2)
        print("town10 with 2 colors (expecting False): ", step.runSolver())
        step.updateBase(4)
        print("town10 with 4 colors (expecting True): ", step.runSolver())

        step = Etape1("Data/pb-etape1/flat20_3_0.col", False)
        step.updateBase(4)
        print("flat20_3_0.col with 4 colors (expecting True): ", step.runSolver())
        step.updateBase(3)
        print("flat20_3_0.col with 3 colors (expecting True): ", step.runSolver())
        step.updateBase(2)
        print("flat20_3_0.col with 2 colors (expecting False): ", step.runSolver())

        step = Etape1("Data/pb-etape1/jean.col", False)
        step.updateBase(10)
        print("jean.col with 10 colors (expecting True): ", step.runSolver())
        step.updateBase(9)
        print("jean.col with 9 colors (expecting False): ", step.runSolver())
        step.updateBase(3)
        print("jean.col with 3 colors (expecting False): ", step.runSolver())