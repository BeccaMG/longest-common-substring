package com.tsp.se.inputOutput;

import java.util.Random;

/**
 * This class contains one method, in this method we generate a random string
 * with a given length <code>len</code>.
 */
public class RandomStringGeneration {

	/**
	 * In this variable we store the possible characters that the randomly
	 * generated string could contain
	 */
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	/** In this variable we store a new random number generator */
	static Random rnd = new Random();

	/**
	 * Generates and returns a random string of characters from the string
	 * <code>AB</code>. The length of the string is passed to the function in
	 * <code>len</code>
	 * <p>
	 * For example: if len = 7 the return is a random alphanumeric string of
	 * characters such as "7ef81V5"
	 * 
	 * @param len
	 *            Length of the generated string
	 * 
	 * @return A randomly generated string
	 */
	public static String randomString(int len) {

		/**
		 * In this variable we store a string builder with no characters in it
		 * and an initial capacity specified by <code>len</code>
		 */
		StringBuilder sb = new StringBuilder(len);
		/**
		 * In this loop, we append random characters from the constant
		 * <code>AB</code> to the string builder <code>sb</code>
		 */
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}

}
