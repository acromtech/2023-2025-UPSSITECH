mon_module_image_v2.out: mon_module_image_v2.o main.o
	gcc -o mon_module_image_v2.out mon_module_image_v2.o main.o -lm -std=c99

mon_module_image_v2.o: gibert_module_image_v2.c
	gcc -lm -std=c99 -c gibert_module_image_v2.c -o mon_module_image_v2.o -W -Wall -pedantic

main.o: main.c gibert_module_image_v2.h
	gcc -o main.o -c main.c -std=c99 -W -Wall -pedantic
	
test_mon_module_image_v2.out: mon_module_image_v2.o test_mon_module_image_v2.o
	gcc -o test_mon_module_image_v2.out mon_module_image_v2.o test_mon_module_image_v2.o -lm -std=c99 -W -Wall -pedantic

test_mon_module_image_v2.o: 
	gcc -o test_mon_module_image_v2.o -c test_module_image_v2.c -std=c99 -W -Wall -pedantic

clean:
	rm -rf *.o
