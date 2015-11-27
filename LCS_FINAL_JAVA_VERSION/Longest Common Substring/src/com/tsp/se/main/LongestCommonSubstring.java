package com.tsp.se.main;

import java.io.IOException;
import java.util.Scanner;

import com.tsp.se.inputOutput.FileManager;
import com.tsp.se.lcs.LongestCommonSubstringFinder;

/**
 * This Program's main objective is to take two text files and print on the
 * standard output the longest common substring between them.
 * <p>
 * At the beginning of the program it gives the user a choice between:
 * <ul>
 * <li>Giving the path of 2 already existing files
 * <li>Asking the program to generate n random files
 * <li>Quitting the program
 * </ul>
 * <p>
 * If the user chooses the first option, giving the path of 2 already existing
 * files, the program will take both files and print the longest common
 * substring.
 * 
 * In this case the user has 2 choices either search for a string of no more
 * than 30 characters in another of length up to 4 Million character or search
 * between two equal files that contains no more than 20,000 character each or
 * something between these two extremes such as comparing a file with 30,000
 * character with another of 3,000 character. <b>Depending on the size of your
 * heap</b>
 * <p>
 * If the user chooses the second option the program will generate a user
 * specified number of files of a constant length of 500 alphanumeric characters
 * at the user specified paths.
 * <p>
 * After executing any of these 2 commands the program will return to the menu
 * so that the user chooses another option or quit.
 * 
 * The program is Case sensetive
 * 
 * @author Asma Berriri <asma.berriri@telecom-sudparis.eu>
 * @author Mostafa Fateen <mostafafateen@gmail.com>
 * @author Ramzi Sellami <ramzi_sellami@yahoo.com>
 * @author Rebeca Machado <rebeca.machado_garroz@telecom-sudparis.eu>
 * 
 * @version 1.1.0
 * @since 13/2/2015
 */

public class LongestCommonSubstring {

	/**
	 * This is the main of our program in which we do our operations and call
	 * other classes and functions.
	 *
	 * @throws IOException
	 *             if an input or output exception occurred
	 */
	public static void main(String[] args) throws IOException {

		/** A variable in which we put the choice of the user from the menu */
		String choice = null;
		/**
		 * <code>@SuppressWarnings("resource")</code> to suppress warnings
		 * relative to usage of resources of type Closable
		 */
		@SuppressWarnings("resource")
		/** A variable to read from the standard input */
		Scanner scan = new Scanner(System.in);

		do {
			/** Prints the main menu to the user */
			System.out.println("------------------------------------");
			System.out.println("What type of files are you going to use?");
			System.out.println("------------------------------------");
			System.out.println("1) I have already generated my files");
			System.out.println("2) I want to randomly generate my files now");
			System.out.println("3) Quit");
			System.out.println("------------------------------------");

			choice = scan.nextLine();
			switch (choice) {
			/**
			 * <b>The case of the already generated files</b>: Here the user
			 * specifies the path of each file, the program will open both of
			 * them and put them in two different strings <code>str1</code> and
			 * <code>str2</code> by invoking the function {@link getFile()} from
			 * the class <code>FilesReader</code>.
			 * <p>
			 * The program will then call the function {@link lcs()} from the
			 * class <code>LongestCommonSubstringFinder</code> to find the
			 * longest common substring and put it in the local variable
			 * <code>result</code>.
			 * <p>
			 * After that the program will display both files and then the
			 * longest common substring.
			 */
			case "1":
				try {

					System.out
							.println("Please enter the path of the first file: ");
					/** A variable to store the path of the first file */
					String path1 = scan.nextLine();
					/** A variable to store the content of the first file */
					String str1 = FileManager.readFile(path1);

					System.out
							.println("Please enter the path of the second file: ");
					/** A variable to store the path of the second file */
					String path2 = scan.nextLine();

					/** A variable to store the content of the second file */
					String str2 = FileManager.readFile(path2);

					/**
					 * A variable to store the longest common substring between
					 * the 2 files
					 */
					String result = LongestCommonSubstringFinder.findLCS(str1,
							str2);

					System.out.println(str1);
					System.out
							.println("*************************************************");
					System.out.println(str2);
					System.out.println("\nLongest Common Substring : \""
							+ result + "\"");
				} catch (OutOfMemoryError e) {
					System.out
							.println("Out of memory, please extend your heap size or enter smaller files.");
				}
				break;

			/**
			 * <b>The case of generating random files</b>: Here the program
			 * takes from the user the number of files to be generated and calls
			 * the function {@link setFile()} from the class
			 * <code>FilesWriter</code> to do so.
			 */
			case "2":
				System.out.println("How many files do you want to generate?");

				/** A variable to store the number of files to be generated */
				int nbr = 0;
				while (nbr == 0) {
					try {
						nbr = Integer.parseInt(scan.nextLine());
					} catch (NumberFormatException e) {
						System.out.println("Introduce a number bigger than 0.");
					}
				}
				FileManager.writeFile(nbr);
				break;

			/**
			 * <b>The case of Quitting<b>: Here we exit the loop and in turn
			 * exit the program.
			 */
			case "3":
				System.out.println("See you next time!");
				break;

			/**
			 * <b>The default case<b>: in this case we just discard what was
			 * inputted and re-loop to get the correct input.
			 */
			default:
				System.out.println("Error, type 1, 2 or 3!");
				break;

			} // end of the switch case
		} while (!choice.equals("3")); // end of the do..while loop

	}

}