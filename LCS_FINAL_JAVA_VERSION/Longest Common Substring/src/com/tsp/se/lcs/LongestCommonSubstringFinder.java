package com.tsp.se.lcs;

/**
 * This class contains one method, in this method we find the longest common
 * substring between 2 strings.
 */

public class LongestCommonSubstringFinder {

	/**
	 * Finds the longest common substring between 2 strings passed by as inputs
	 * arguments can be two strings with any length and any content.
	 * <p>
	 * This method returns the longest common substring <code>lcs</code> if
	 * found or an empty string if there was nothing in common between both
	 * files.
	 * 
	 * The source of this file is from
	 * "http://www.sanfoundry.com/java-program-longest-common-substring-algorithm/"
	 * but we fixed some stuff in it.
	 *
	 * @param str1
	 *            First string
	 * @param str2
	 *            Second string
	 * @return The longest common substring between both strings
	 */
	public static String findLCS(String str1, String str2) {

		if (str1.isEmpty() || str2.isEmpty())
			return "";

		/** The Longest Common Substring will be stored in this variable. */
		String lcs;

		/** Length of the first string. */
		int l1 = str1.length();
		/** Length of the second string. */
		int l2 = str2.length();

		/** Matrix storing the position of matched characters. */
		int[][] arr = new int[l1 + 1][l2 + 1];

		/** Two indices used when comparing character by character. */
		int len = 0, pos = -1;

		/**
		 * With these two consecutive for loops, we browse <code>str1</code> and
		 * <code>str2</code> in order to get the longest common substring
		 * between them.
		 */
		for (int x = 1; x < l1 + 1; x++) {
			for (int y = 1; y < l2 + 1; y++) {
				/**
				 * Here, we are comparing character by character the two
				 * strings. If we have a match, we save the character's position
				 * in the matrix <code>arr</code>.
				 */
				if (str1.charAt(x - 1) == str2.charAt(y - 1)) {
					arr[x][y] = arr[x - 1][y - 1] + 1;
					if (arr[x][y] > len) {
						len = arr[x][y];
						pos = x;
					}
				} else
					arr[x][y] = 0;
			}
		}

		/**
		 * Here we extract a substring from the string <code>str1</code> from
		 * the index <code>pos-len</code> to the index <code>pos</code>.
		 */
		if (len == 0)
			lcs = str1.substring(1, 1);
		else
			lcs = str1.substring(pos - len, pos);

		return lcs;
	}
}