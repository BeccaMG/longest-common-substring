/**
 * @file longest_common_substring_finder_tests.c
 * @author Asma Berriri <asma.berriri@telecom-sudparis.eu>
 * @author Mostafa Fateen <mostafa.fateen@telecom-sudparis.eu>
 * @author Rebeca Machado <rebeca.machado_garroz@telecom-sudparis.eu>
 * @author Ramzi Sellami <ramzi.sellami@telecom-sudparis.eu>
 * @version 1.0
 * @see http://cunit.sourceforge.net/
 * 
 * Functions for the longest_common_substring_finder and its functions.
 * 
 */

#include <stdio.h>
#include <string.h>

#include "CUnit/Basic.h"
#include "longest_common_substring_finder.h"


/**
 * test_find_LCS
 * 
 * @brief Tests for the find_LCS function
 *
 * 5 tests:
 *  - Two empty char arrays.
 *  - One empty char array and a non-empty one.
 *  - Two char arrays with no common substrings.
 *  - Two char arrays with a common substring.
 *  - Two char arrays with case sensitive.
 *
 */
void test_find_LCS(void) {
    CU_ASSERT(NULL == find_LCS("",""));
    CU_ASSERT(NULL == find_LCS("","a"));
    CU_ASSERT(NULL == find_LCS("My name is Khan","or"));
    CU_ASSERT(!strcmp("aa", find_LCS("aa bb cc dd","aa")));
    CU_ASSERT(!strcmp("y name is ", 
                      find_LCS("My name is Khan","my name is khan")));
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
    pSuite = CU_add_suite("Tests for longest_common_substring_finder",
                          NULL, NULL);
    if (NULL == pSuite) {
        CU_cleanup_registry();
        return CU_get_error();
    }
   
    if (NULL == CU_add_test(pSuite, "tests of find_LCS()", test_find_LCS)) {
        CU_cleanup_registry();
        return CU_get_error();
    }
    
    /* Run all tests using the CUnit Basic interface */
    CU_basic_set_mode(CU_BRM_VERBOSE);
    CU_basic_run_tests();
    CU_cleanup_registry();
    return CU_get_error();
}