mon_module_image.out: mon_module_image.o main.o
	gcc -o mon_module_image.out mon_module_image.o main.o

mon_module_image.o: ferrane_module_image.c 
	gcc -c ferrane_module_image.c -o mon_module_image.o  -W -Wall -ansi -pedantic

main.o: main.c ferrane_module_image.h
	gcc -o main.o -c main.c -W -Wall -ansi -pedantic
	
clean:
	rm -rf *.o
	
	
				