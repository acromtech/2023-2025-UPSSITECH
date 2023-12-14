mon_module_image.out: mon_module_image.o main.o
	gcc -o mon_module_image.out mon_module_image.o main.o -lm -std=c99

mon_module_image.o: gibert_module_image.c
	gcc -lm -std=c99 -c gibert_module_image.c -o mon_module_image.o -W -Wall -pedantic

main.o: main.c gibert_module_image.h
	gcc -o main.o -c main.c -std=c99 -W -Wall -pedantic

clean:
	rm -rf *.o
