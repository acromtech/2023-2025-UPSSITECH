test5: element.o pile_statique.o demi_tour.o
	gcc -o test5.out element.o pile_statique.o demi_tour.o
	./test5.out
element.o : element.c element.h
	gcc -c element.c
pile_statique.o : pile_statique.c pile_statique.h
	gcc -c pile_statique.c
demi_tour.o: demi_tour.c pile_statique.h element.h
	gcc -c demi_tour.c
	

test6 : element.c element.h pile_statique.c pile_statique.h demi_tour.c
	gcc -c element.c
	gcc -c pile_statique.c
	gcc -c demi_tour.c
	gcc -o test6.out element.o pile_statique.o demi_tour.o
	./test6.out

clean:
		rm -rf *.o
