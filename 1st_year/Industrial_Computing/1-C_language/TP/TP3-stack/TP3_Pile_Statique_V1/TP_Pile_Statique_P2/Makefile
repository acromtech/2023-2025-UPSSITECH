test1 : pile_statique.c pile_statique.h tst_pile_statique.c
	gcc -c pile_statique.c
	gcc -c tst_pile_statique.c
	gcc -o test1.out pile_statique.o tst_pile_statique.o
	./test1.out
	
test2 : pile_statique.c pile_statique.h progTestPileStat.c
	gcc -c pile_statique.c
	gcc -c progTestPileStat.c
	gcc -o test2.out pile_statique.o progTestPileStat.o
	./test2.out


test3 : element.o pile_statique.o tst_pile_statique.o
	gcc -o test3.out element.o pile_statique.o tst_pile_statique.o
	./test3.out
element.o : element.c element.h 
	gcc -c element.c
pile_statique.o : pile_statique.c pile_statique.h element.h 
	gcc -c pile_statique.c
tst_pile_statique.o : tst_pile_statique.c pile_statique.h element.h 
	gcc -c tst_pile_statique.c
clean:
	rm -rf *.o
