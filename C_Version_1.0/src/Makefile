# Makefile
# @author Asma Berriri
# @author Mostafa Fateen
# @author Rebeca Machado
# @author Ramzi Sellami

.SUFFIXES: .o .c
.c.o:
	gcc -c $<

all: main

main :file_manager.o longest_common_substring_finder.o\
	longest_common_substring.o
	
	gcc file_manager.o longest_common_substring_finder.o\
		longest_common_substring.o -o longest_common_substring\

clean:
	rm -f *.o longest_common_substring