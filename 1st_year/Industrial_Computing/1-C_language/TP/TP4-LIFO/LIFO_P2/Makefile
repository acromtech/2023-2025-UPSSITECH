test1 : element.o pile_statique.o tst_pile_statique.o
	gcc -o test1.out element.o pile_statique.o tst_pile_statique.o
	./test1.out
element.o : element.c element.h 
	gcc -c element.c
pile_statique.o : pile_statique.c pile_statique.h element.h 
	gcc -c pile_statique.c
tst_pile_statique.o : tst_pile_statique.c pile_statique.h element.h 
	gcc -c tst_pile_statique.c
	
	
clean:
	rm -rf *.o
