/**
 * @file longest_common_substring.c
 * @author Asma Berriri <asma.berriri@telecom-sudparis.eu>
 * @author Mostafa Fateen <mostafa.fateen@telecom-sudparis.eu>
 * @author Rebeca Machado <rebeca.machado_garroz@telecom-sudparis.eu>
 * @author Ramzi Sellami <ramzi.sellami@telecom-sudparis.eu>
 * @version 1.0
 * 
 * Gets two files as input from command line when running the program and 
 * retrieve the longest substring between both in stdout.
 * 
 */

#include <stdio.h>
#include <string.h>

#include "file_manager.h"
#include "longest_common_substring_finder.h"


/**
 * @var file1
 * @brief Saves the name of the first input file.
 */
char *file1;

/**
 * @var file2
 * @brief Saves the name of the second input file.
 */
char *file2;


/**
 * display_result
 * 
 * @brief Receives an array of char with the LCS result and show it in stdout.
 * 
 * @param result Result to be processed and displayed.
 * 
 * The result should be a array of characters holding the longest substring
 * between the two input files.
 * 
 * If the array is not empty then the output will follow this format:
 * 
 * <b>The longest substring between [Input File 1] and [Input File 2] is
 * "[longest substring]".</b>
 *
 * Otherwise, the output would be <b>No common substrings</b>
 * 
 * If the return value is asigned to a variable outside the function, there's no
 * need of allocating memory for it since the function does it. 
 *
 */
void display_result(char *result) {
    
    if (result != NULL) {
        printf("The longest substring between %s and %s is \"%s\".\n",
                file1, file2, result);
    } else {
        printf("No common substrings\n");
    }
}


/**
 * main
 * 
 * @brief Main function.
 * 
 * @param argc Number of parameters received by command line when running.
 * @param argv Value of parameters received by command line when running.
 * @return Integer with value 0 in case of no errors, -1 otherwise.
 * 
 * This main checks the input as it should be two files of extension .txt, then 
 * reads the files and shows the LCS between both.
 *
 */
int main(int argc, char *argv[]) {
    char *s1;
    char *s2;
    char *result;
    char *ext;
    
    if (argc < 3) {
        printf("Usage: longest_common_substring <file1> <file2>\n");
        return(-1);
    }
    
    file1 = argv[1];
    file2 = argv[2];
    
    ext = strrchr(file1, '.');
    if (!ext) {
        fprintf(stderr, "File1 extension should be .txt\n");
        return(-1);
    }
    ext = ext + 1;
    if (strcmp(ext,"txt")) {
        fprintf(stderr, "File1 extension should be .txt\n");
        return(-1);
    }
    
    ext = strrchr(file2, '.');
    if (!ext) {
        fprintf(stderr, "File2 extension should be .txt\n");
        return(-1);
    }
    ext = ext + 1;
    if (strcmp(ext,"txt")) {
        fprintf(stderr, "File2 extension should be .txt\n");
        return(-1);
    }
    
    s1 = read_file(file1);
    if (s1 == NULL) {
        return -1;
    }
    
    s2 = read_file(file2);
    if (s2 == NULL) {
        return -1;
    }
    
    result = find_LCS(s1,s2);
    display_result(result);
    
    return 0;
}