all : 
	python3 projet/etape1/Etape1.py > log ; python3 projet/etape1/Etape1.py >> log; \
	python3 projet/etape2/Etape2.py >> log ; python3 projet/etape3/Etape3.py >> log ; \
	python3 projet/etape4/Etape4.py >> log ; python3 projet/outils/Lieu.py  >> log; \
	python3 projet/outils/Fils.py >> log ; python3 projet/outils/GrapheDeLieux.py  >> log; \
	python3 projet/solvers/SolverAStar.py >> log ; python3 projet/solvers/SolverCSP.py  >> log; \
	python3 projet/solvers/SolverHC.py >> log ; python3 projet/solvers/SolverSAT.py >> log ; \
	python3 projet/solvers/SolverTabou.py >> log 
	diff log projet/tests/logReference

clear :
	\rm log
		
doc :	
	pdoc --html -f -o Doc projet


