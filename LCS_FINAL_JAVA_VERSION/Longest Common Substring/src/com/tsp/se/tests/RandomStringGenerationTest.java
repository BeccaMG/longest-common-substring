package com.tsp.se.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.tsp.se.inputOutput.RandomStringGeneration;

/**
 * This is a unit testing class related to the RandomStringGeneration class
 * 
 * @author Asma Berriri <asma.berriri@telecom-sudparis.eu>
 * @author Mostafa Fateen <mostafafateen@gmail.com>
 * @author Ramzi Sellami <ramzi_sellami@yahoo.com>
 * @author Rebeca Machado <rebeca.machado_garroz@telecom-sudparis.eu>
 * 
 * @version 1.1.0
 * @since 13/2/2015
 */
public class RandomStringGenerationTest {

	/** We create one instance of the class RandomStringGeneration */
	static RandomStringGeneration rsg = new RandomStringGeneration();

	/** Two variables to store the two strings randomly generated */
	static String str1, str2;

	/**
	 * This function tests a case in which we generate an empty random string
	 * using <code>randomString()</code>.
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testRandomStringNull() {

		str1 = rsg.randomString(0);

		assertEquals(0, str1.length());

	}

	/**
	 * This function tests a case in which we generate a random string using
	 * <code>randomString()</code>.
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testRandomString() {

		str1 = rsg.randomString(500);

		assertEquals(500, str1.length());
		assertTrue(StringUtils.isAlphanumeric(str1));

	}

	/**
	 * This function tests a case in which we generate two random strings using
	 * <code>randomString()</code> and showing that they are different.
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testCompareTwoRandomStrings() {

		str1 = rsg.randomString(500);
		str2 = rsg.randomString(500);

		assertEquals(500, str1.length());
		assertEquals(500, str2.length());

		assertTrue(StringUtils.isAlphanumeric(str1));
		assertTrue(StringUtils.isAlphanumeric(str2));

		assertTrue(!str1.equals(str2));

	}
}
