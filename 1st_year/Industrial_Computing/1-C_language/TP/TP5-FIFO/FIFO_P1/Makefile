test1 : element.o file_dynamique.o tst_file_dynamique.o
	gcc -o test1.out element.o file_dynamique.o tst_file_dynamique.o
	./test1.out
element.o : element.c element.h 
	gcc -c element.c
file_dynamique.o : file_dynamique.c file_dynamique.h element.h 
	gcc -c file_dynamique.c
tst_file_dynamique.o : tst_file_dynamique.c file_dynamique.h element.h 
	gcc -c tst_file_dynamique.c
	
clean:
	rm -rf *.o