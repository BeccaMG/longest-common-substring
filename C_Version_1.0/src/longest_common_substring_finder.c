/**
 * @file longest_common_substring_finder.c
 * @author Asma Berriri <asma.berriri@telecom-sudparis.eu>
 * @author Mostafa Fateen <mostafa.fateen@telecom-sudparis.eu>
 * @author Rebeca Machado <rebeca.machado_garroz@telecom-sudparis.eu>
 * @author Ramzi Sellami <ramzi.sellami@telecom-sudparis.eu>
 * @version 1.0
 * 
 * Function that finds the longest common substring between two strings.
 * 
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "longest_common_substring_finder.h"

char *find_LCS(char *s1, char *s2) {
    
	int n = strlen(s1);
	int m = strlen(s2);
    
    int matrix[n+1][m+1];

	int i = 0;
	int j = 0;
    int final_length = 0;
	char *lcs = NULL; // This will store the result

	// Matrix nitialization
	for (i = 0; i <= n; i++) {
        for (j = 0; j <= m; j++) {
            matrix[i][j] = 0;
        }
    }
	
    int match_count = 0;
    int k;
    
    // Actual algorithm
	for (i = 0; i < n; i++) {
		for (j = 0; j < m; j++) { 

			if (s1[i] == s2[j] ) {
                match_count = matrix[i][j] + 1;
				matrix[i+1][j+1] = match_count;
				
                if (match_count > final_length) {
                    final_length = match_count;
                    lcs = (char*) realloc(lcs, final_length*sizeof(char));
                    
                    // Replace everytime so the last one found is returned
                    for (k = 0; k < match_count; k++)
                        lcs[k] = s1[i+1-match_count+k];
                }
			}
		}
	}
	
	return lcs;
}