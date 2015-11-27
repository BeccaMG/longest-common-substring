package com.tsp.se.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.tsp.se.lcs.LongestCommonSubstringFinder;

/**
 * This is a unit testing class related to the LongestCommonSubstringFinder
 * class
 * 
 * @author Asma Berriri <asma.berriri@telecom-sudparis.eu>
 * @author Mostafa Fateen <mostafafateen@gmail.com>
 * @author Ramzi Sellami <ramzi_sellami@yahoo.com>
 * @author Rebeca Machado <rebeca.machado_garroz@telecom-sudparis.eu>
 * 
 * @version 1.1.0
 * @since 13/2/2015
 */
public class LongestCommonSubstringFinderTest {

	/** We create one instance of the class LongestCommonSubstringFinder */
	static LongestCommonSubstringFinder lcsf = new LongestCommonSubstringFinder();

	/** Two variables to store the two strings to compare */
	static String str1, str2;

	/**
	 * This function tests a simple case using <code>findLCS()</code> comparing
	 * two simple strings.
	 */
	@Test
	public void testSimple() {

		str1 = "aa bb cc dd";
		str2 = "aa";

		@SuppressWarnings("static-access")
		String lcs = lcsf.findLCS(str1, str2);
		assertEquals("aa", lcs);
	}

	/**
	 * This function tests a null case using <code>findLCS()</code> comparing
	 * two null strings.
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testNull() {

		// Comparing 2 null strings
		str1 = "";
		str2 = "";

		String lcs = lcsf.findLCS(str1, str2);
		assertEquals("", lcs);
	}

	/**
	 * This function tests a case using <code>findLCS()</code> comparing two
	 * simple strings showing the case sensitivity.
	 */
	@Test
	public void testCaseSensitive() {

		str1 = "My name is Khan";
		str2 = "my name is khan";

		@SuppressWarnings("static-access")
		String lcs = lcsf.findLCS(str1, str2);
		assertEquals("y name is ", lcs);
	}

	/**
	 * This function tests a case in which we have no common substring using
	 * <code>findLCS()</code> comparing two simple strings.
	 */
	@Test
	public void testNoCommonSubstring() {

		str1 = "My name is Khan";
		str2 = "or";

		@SuppressWarnings("static-access")
		String lcs = lcsf.findLCS(str1, str2);
		assertEquals("", lcs);
	}

	/**
	 * This function tests a case using <code>findLCS()</code> comparing one
	 * empty string and another one.
	 */
	@Test
	public void testNullOneFile() {
		str1 = "";
		str2 = "a";

		@SuppressWarnings("static-access")
		String lcs = lcsf.findLCS(str1, str2);
		assertEquals("", lcs);
	}

}
