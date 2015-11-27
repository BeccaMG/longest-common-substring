package com.tsp.se.tests;

import static org.junit.Assert.assertEquals;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tsp.se.inputOutput.FileManager;

/**
 * This is a unit testing class related to the FilesReader class
 * 
 * @author Asma Berriri <asma.berriri@telecom-sudparis.eu>
 * @author Mostafa Fateen <mostafafateen@gmail.com>
 * @author Ramzi Sellami <ramzi_sellami@yahoo.com>
 * @author Rebeca Machado <rebeca.machado_garroz@telecom-sudparis.eu>
 * 
 * @version 1.1.0
 * @since 13/2/2015
 */
@SuppressWarnings("static-access")
public class FilesReaderTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}

	/** We create an instance of the class FilesReader */
	static FileManager fr = new FileManager();

	/** A variable to store the content of the file to compare */
	static String str1;

	/** Get the path of the working directory according to each user */
	String userWorkingFolder = System.getProperty("user.dir");

	/**
	 * This function tests the reading function <code>readFile()</code> with an
	 * empty file.
	 */
	@Test
	public void testNull() throws IOException {

		/**
		 * Create a directory to put the testing files in it in the working
		 * directory
		 */
		new File(userWorkingFolder + "/LCSTestingReaderFiles").mkdirs();

		File file = new File(userWorkingFolder
				+ "/LCSTestingReaderFiles/testNullFile.txt");

		file.createNewFile();

		str1 = fr.readFile(userWorkingFolder
				+ "/LCSTestingReaderFiles/testNullFile.txt");

		assertEquals("", str1);
	}

	/**
	 * This function tests the reading function <code>readFile()</code> with a
	 * one line file.
	 */
	@Test
	public void testOneLineFile() throws IOException {

		/**
		 * Create a directory to put the testing files in it in the working
		 * directory
		 */
		new File(userWorkingFolder + "/LCSTestingReaderFiles").mkdirs();

		File file = new File(userWorkingFolder
				+ "/LCSTestingReaderFiles/testOneLineFile.txt");

		file.createNewFile();

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("Please give me 1 billion dollars.");
		bw.close();

		str1 = fr.readFile(userWorkingFolder
				+ "/LCSTestingReaderFiles/testOneLineFile.txt");

		assertEquals("Please give me 1 billion dollars.", str1);
	}

	/**
	 * This function tests the reading function <code>readFile()</code> with
	 * multiple lines in a file.
	 */
	@Test
	public void testMultipleLineFile() throws IOException {

		/**
		 * Create a directory to put the testing files in it in the working
		 * directory
		 */
		new File(userWorkingFolder + "/LCSTestingReaderFiles").mkdirs();

		File file = new File(userWorkingFolder
				+ "/LCSTestingReaderFiles/testMultipleLineFile.txt");

		file.createNewFile();

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("Line1\nLine2\nLine3");
		bw.close();

		str1 = fr.readFile(userWorkingFolder
				+ "/LCSTestingReaderFiles/testMultipleLineFile.txt");

		assertEquals("Line1\nLine2\nLine3", str1);
	}

	/**
	 * 
	 * This function tests the reading function <code>readFile()</code> when
	 * sending a directory
	 */

	@Test
	public void testReadDirectory() throws IOException {

		/**
		 * Create a directory to put the testing files in it in the working
		 * directory
		 */
		new File(userWorkingFolder + "/LCSTestingReaderFiles").mkdirs();

		String inputData = userWorkingFolder
				+ "/LCSTestingReaderFiles/testNullFile.txt";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));

		str1 = fr.readFile(userWorkingFolder);
		assertEquals(
				"Please enter a valid path to an already existing file.\r\n",
				outContent.toString());
	}

	@Test
	public void testReadNonExistingFile() throws IOException {

		/**
		 * Create a directory to put the testing files in it in the working
		 * directory
		 */
		new File(userWorkingFolder + "/LCSTestingReaderFiles").mkdirs();

		String inputData = userWorkingFolder
				+ "/LCSTestingReaderFiles/testMultipleLineFile.txt";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));

		str1 = fr.readFile(userWorkingFolder + "IdoNotExist.beurk");
		assertEquals(
				"Please enter a valid path to an already existing file.\r\n",
				outContent.toString());
	}

}
