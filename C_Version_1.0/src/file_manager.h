/**
 * @file file_manager.h
 * @author Asma Berriri <asma.berriri@telecom-sudparis.eu>
 * @author Mostafa Fateen <mostafa.fateen@telecom-sudparis.eu>
 * @author Rebeca Machado <rebeca.machado_garroz@telecom-sudparis.eu>
 * @author Ramzi Sellami <ramzi.sellami@telecom-sudparis.eu>
 * @version 1.0
 * @see file_manager.c
 *
 * Definition of functions related to file managing.
 * 
 */


/**
 * read_file
 * 
 * @brief Reads a file and return a char array with its content.
 * 
 * @param file_path Path of the file to read.
 * @return Array of characters where the content is stored.
 * 
 * A given text file is opened and the size is computed by finding the last
 * byte. An array of char is then allocated to match the size of the file,
 * filled with its content and returned as result.
 * 
 * If there's an error with opening the file, perror would be called and NULL 
 * will be returned.
 * 
 * If the file is empty, the char array will be empty too (length 0).
 * 
 * If the return value is asigned to a variable outside the function, there's no
 * need of allocating memory for it since the function does it. 
 *
 */
char *read_file(char *file_path);