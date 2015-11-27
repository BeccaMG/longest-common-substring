/**
 * @file file_manager_tests.c
 * @author Asma Berriri <asma.berriri@telecom-sudparis.eu>
 * @author Mostafa Fateen <mostafa.fateen@telecom-sudparis.eu>
 * @author Rebeca Machado <rebeca.machado_garroz@telecom-sudparis.eu>
 * @author Ramzi Sellami <ramzi.sellami@telecom-sudparis.eu>
 * @version 1.0
 * @see http://cunit.sourceforge.net/
 * 
 * Functions for the file_manager and its functions.
 * 
 */

#include <stdio.h>
#include <string.h>

#include "CUnit/Basic.h"
#include "file_manager.h"


/**
 * test_read_file
 * 
 * @brief Tests for the read_file function
 *
 * 3 tests:
 *  - One empty file.
 *  - One file with a single line.
 *  - One file with 3 lines.
 *
 */
void test_read_file(void) {
    CU_ASSERT(!strcmp("", read_file("fileToRead1.txt")));
    CU_ASSERT(!strcmp("Please give me 1 billion dollars.",
                      read_file("fileToRead2.txt")));
    CU_ASSERT(!strcmp("Line1\nLine2\nLine3", read_file("fileToRead3.txt")));
}


/**
 * main
 * 
 * @brief Main function
 * @see http://cunit.sourceforge.net/
 *
 */
int main() {
    CU_pSuite pSuite = NULL;
    
    /* initialize the CUnit test registry */
    if (CUE_SUCCESS != CU_initialize_registry())
        return CU_get_error();
    
    /* add a suite to the registry */
    pSuite = CU_add_suite("Tests for file_manager", NULL, NULL);
    if (NULL == pSuite) {
        CU_cleanup_registry();
        return CU_get_error();
    }
    
    if (NULL == CU_add_test(pSuite, "tests of read_file()", test_read_file))
    {
        CU_cleanup_registry();
        return CU_get_error();
    }
    
    /* Run all tests using the CUnit Basic interface */
    CU_basic_set_mode(CU_BRM_VERBOSE);
    CU_basic_run_tests();
    CU_cleanup_registry();
    return CU_get_error();
}