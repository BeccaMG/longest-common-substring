/**
 * @file longest_common_substring_finder.h
 * @author Asma Berriri <asma.berriri@telecom-sudparis.eu>
 * @author Mostafa Fateen <mostafa.fateen@telecom-sudparis.eu>
 * @author Rebeca Machado <rebeca.machado_garroz@telecom-sudparis.eu>
 * @author Ramzi Sellami <ramzi.sellami@telecom-sudparis.eu>
 * @version 1.0
 * 
 * Definition of a function that finds the longest common substring between two
 * strings.
 * 
 */


/**
 * find_LCS
 * 
 * @brief Receives two strings and find the LCS between both.
 * @see https://www.youtube.com/watch?v=RUckZMzqUcw
 * 
 * @param s1 First array of characters (String)
 * @param s2 Second array of characters (String)
 * @return Array of characters with the LCS between s1 and s1.
 * 
 * The algorithm was taken from the link referenced and implemented by the team.
 * The returned substring -if not empty- could be a word, a single letter, a
 * blank space, a phrase or even the whole input string (if equals).
 *
 */
char *find_LCS(char *s1, char *s2);