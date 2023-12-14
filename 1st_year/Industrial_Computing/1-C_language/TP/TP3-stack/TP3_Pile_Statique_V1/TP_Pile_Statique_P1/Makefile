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

