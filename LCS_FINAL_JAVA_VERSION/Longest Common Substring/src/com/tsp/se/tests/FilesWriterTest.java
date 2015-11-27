package com.tsp.se.tests;

import java.io.File;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.tsp.se.inputOutput.FileManager;

/**
 * This is a unit testing class related to the FilesWriter class
 * 
 * @author Asma Berriri <asma.berriri@telecom-sudparis.eu>
 * @author Mostafa Fateen <mostafafateen@gmail.com>
 * @author Ramzi Sellami <ramzi_sellami@yahoo.com>
 * @author Rebeca Machado <rebeca.machado_garroz@telecom-sudparis.eu>
 * 
 * @version 1.1.0
 * @since 13/2/2015
 */

public class FilesWriterTest {

	/** We create two instances of the class FilesWriter */
	static FileManager fw = new FileManager();

	/** Instantiate a Date object */
	Date date = new Date();
	Format formatter = new SimpleDateFormat("YYYY-MM-dd_hh-mm-ss");

	/** Get the path of the working directory according to each user */
	String userWorkingFolder = System.getProperty("user.dir");

	/**
	 * This function tests the writing function <code>writeFile()</code> giving
	 * as parameter only one file to generate.
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testWriteOneFile() throws IOException {

		/**
		 * Create a directory to put the testing files in it in the working
		 * directory
		 */
		new File(userWorkingFolder + "/LCSTestingWriterFiles").mkdirs();

		String inputData = userWorkingFolder
				+ "/LCSTestingWriterFiles/testOneFileGen"
				+ formatter.format(date) + ".txt\n";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		fw.writeFile(1);

	}
	
	

	/**
	 * This function tests the writing function <code>writeFile()</code> giving
	 * as parameter two files to generate.
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testWriteTwoFiles() throws IOException {

		/**
		 * Create a directory to put the testing files in it in the home
		 * directory
		 */
		new File(userWorkingFolder + "/LCSTestingWriterFiles").mkdirs();

		String str1 = userWorkingFolder
				+ "/LCSTestingWriterFiles/testTwoFilesGen1"
				+ formatter.format(date) + ".txt\n";

		String str2 = userWorkingFolder
				+ "/LCSTestingWriterFiles/testTwoFilesGen2"
				+ formatter.format(date) + ".txt\n";

		String inputData = str1 + str2;

		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));

		fw.writeFile(2);

	}
	
}
