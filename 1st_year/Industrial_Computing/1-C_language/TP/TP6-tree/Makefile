test1 : arbre.o tst_arbre.o
	gcc -o test1.out arbre.o tst_arbre.o
	rm -rf *.o
	./test1.out
	
arbre.o : arbre.c arbre.h
	gcc -c arbre.c
	
tst_arbre.o: tst_arbre.c arbre.h
	gcc -c tst_arbre.c
