/**
 * @file file_manager.c
 * @author Asma Berriri <asma.berriri@telecom-sudparis.eu>
 * @author Mostafa Fateen <mostafa.fateen@telecom-sudparis.eu>
 * @author Rebeca Machado <rebeca.machado_garroz@telecom-sudparis.eu>
 * @author Ramzi Sellami <ramzi.sellami@telecom-sudparis.eu>
 * @version 1.0
 * 
 * Functions related to file managing, particularly file reading.
 * 
 */

#include <stdio.h>
#include <stdlib.h>

#include "file_manager.h"

/**
 * @brief Char constant used to represent the end of a string.
 */
#define EOS '\0'

char *read_file(char *file_path) {
        
    int read_size;
    int string_size;
    char *buffer;
    FILE *handler;
    
    buffer = NULL;
    handler = fopen(file_path, "r");

    if (handler) {
        // Seek the last byte and allocate memory for the whole file
        fseek(handler, 0, SEEK_END);
        string_size = ftell(handler);
        rewind(handler);

        // Read and save file content
        buffer = (char*) malloc(sizeof(char) * (string_size));
        read_size = fread(buffer, sizeof(char), string_size, handler);
        buffer[string_size-1] = EOS;

        // Error checking
        if (string_size != read_size) {
            free(buffer);
            buffer = NULL;
        }
    } else {
        perror("Error opening the file");
        return NULL;
    }
    
    fclose(handler);

    return buffer;
}