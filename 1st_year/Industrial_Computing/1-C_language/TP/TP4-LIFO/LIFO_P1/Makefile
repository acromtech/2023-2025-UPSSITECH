test1 : element.o pile_dynamique.o tst_pile_dynamique.o
	gcc -o test1.out element.o pile_dynamique.o tst_pile_dynamique.o
	./test1.out
element.o : element.c element.h 
	gcc -c element.c
pile_dynamique.o : pile_dynamique.c pile_dynamique.h element.h 
	gcc -c pile_dynamique.c
tst_pile_dynamique.o : tst_pile_dynamique.c pile_dynamique.h element.h 
	gcc -c tst_pile_dynamique.c
	
clean:
	rm -rf *.o
