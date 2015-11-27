package com.tsp.se.inputOutput;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * This class is responsible of all communications with the files. It contains
 * two methods. In the first method <code>readFile</code> we read the content of
 * a specific file and put it in a string. While in the second one
 * <code>writeFile</code> we write the randomly generated string in new files.
 */
public class FileManager {

	/**
	 * Here the program takes the path of a file, reads its content and return
	 * it as a string of characters
	 *
	 * @param path
	 *            path of the file needed to be read into the string
	 * @return It returns the contents of the file as a string of characters
	 * @throws IOException
	 *             if an input or output exception occurred
	 */
	public static String readFile(String path) throws IOException {

		/** A string to put inside all the characters of the file */

		String allLines = "";
		File f = new File(path);
		while (!f.exists() || f.isDirectory()) {

			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));

			System.out
					.println("Please enter a valid path to an already existing file.");
			path = br.readLine();
			f = new File(path);
		}
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			/** A string to put inside the content of each line */
			String sCurrentLine = br.readLine();
			String sNextLine;
			int iteration = 0;
			/** Reads line by line and append it to <code>allLines</code> */
			while (sCurrentLine != null) {
				if (iteration != 0)
					allLines += "\n";
				sNextLine = br.readLine();
				allLines += sCurrentLine;
				sCurrentLine = sNextLine;
				iteration++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return allLines;

	}

	/**
	 * Here the program takes an integer <code>num</code> which determines the
	 * number of files to be created. The user will specify the paths of each
	 * file, if the path is:
	 * <ul>
	 * <li>Of an already existing file, it will ask the user to change the file
	 * name
	 * <li>Of a non-existing file, it will create it and write in it
	 * </ul>
	 *
	 * @param num
	 *            number of files to be created
	 *
	 * @throws IOException
	 *             if an input or output exception occurred
	 */

	public static void writeFile(int num) throws IOException {

		/**
		 * <code>@SuppressWarnings("resource")</code> to suppress warnings
		 * relative to usage of resources of type Closable
		 */
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		/**
		 * In each iteration, a new random text file will be generated in the
		 * user specified path.
		 */
		for (int i = 1; i <= num; i++) {

			/**
			 * A variable to store a random string of 500 characters by calling
			 * {@link randomString()}
			 */
			String content = RandomStringGeneration.randomString(500);
			/** A variable to store the file path that will be given by the user */
			String filePathString = null;

			/** A variable to store a new file */
			File f = null;
			/**
			 * A variable to verify the existence of a file in the specified
			 * directory
			 */
			int check = 1;

			/** Keeps asking the user for the path until he provides a valid one */
			do {
				System.out
						.println("Please enter full path of file number " + i);

				filePathString = scan.nextLine();

				f = new File(filePathString);

				/** If the file doesn't exists, then create it */
				if (f.exists() && !f.isDirectory()) {
					System.out
							.println("Please change the name of the file, this one already exists.");
					check = 1;
				} else if (!f.isAbsolute()) {
					System.out.println("Please enter a valid path.");
					check = 1;
				} else {
					f.createNewFile();
					check = 0;
				}

			} while (check == 1 || f.isDirectory());

			FileWriter fw = new FileWriter(f.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();

			System.out.println("Done creating file number " + i);
		}

	}
}