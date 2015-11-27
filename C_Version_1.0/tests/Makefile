# Makefile
# @author Asma Berriri
# @author Mostafa Fateen
# @author Rebeca Machado
# @author Ramzi Sellami
	
src_dir = ../src
include_dirs = \
	-I./CUnit/include\
	-I${src_dir}
	
command = gcc -Wall ${include_dirs} -L./CUnit/lib -lcunit
	
	
FM = file_manager_tests.c ${src_dir}/file_manager.o
LCS = longest_common_substring_finder_tests.c \
	${src_dir}/longest_common_substring_finder.o
	
	
all: main lcs fm exports clean

main:
	@$(MAKE) -C ${src_dir};

fm: ${FM}
	${command} ${FM} -o file_manager_tests
	
lcs: ${LCS}
	${command} ${LCS} -o longest_common_substring_finder_tests

exports:
	export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:./CUnit/lib
	
clean:
	@$(MAKE) clean -C ${src_dir};

