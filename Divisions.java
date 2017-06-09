/*
 * Divisions.java
 * Andrew Metz
 * CSC30
 * Start Date: Thursday, June 8th, 2017
 * Create a program that sorts students into track divisions using a comma-delimited file. All results will be exported into a divisions.txt file.
 */

import java.io.*;

/**
 * The Divisions class sorts students into track divisions using a comma-delimited file. All results will be exported into a divisions.txt file.
 */
 
public class Divisions
{

	public static void main(String[] args)
	{
		
		// Instantiate three variables of the string type to store the line of text and the last and first name.		
		String lineOfText;
		String lastName;
		String firstName;
		
		// Declare three variables of the integer type to store the birth year, birth month, and the position of the comma.
		int birthYear;
		int birthMonth;
		int comma;		
		
		File textFile = new File("Track_Division_Input_File.csv");
		
		FileReader in;
		
		BufferedReader readFile;

		System.out.println("\n\n\t*** THE TRACK DIVISIONS PROGRAM ***\n");
		
		try {
			
			in = new FileReader(textFile);
			
			readFile = new BufferedReader(in);
			
			while ((lineOfText = readFile.readLine()) != null) {
				
				// Begin parse string
				// Determine the last name of the student.
				comma = lineOfText.indexOf(",");		
				lastName = lineOfText.substring(0,comma);		
				lineOfText = lineOfText.substring(comma + 1);
	
				// Determine the first name of the student.
				comma = lineOfText.indexOf(",");		
				firstName = lineOfText.substring(0,comma);		
				lineOfText = lineOfText.substring(comma + 1);		
	
				// Determine the birth year of the student.
				comma = lineOfText.indexOf(",");		
				birthYear= Integer.parseInt(lineOfText.substring(0,comma));	
				lineOfText = lineOfText.substring(comma + 1);		
	
				// Determine the birth month of the student.
				comma = lineOfText.indexOf(",");		
				birthMonth = Integer.parseInt(lineOfText.substring(0,comma));		
	
				// Output the first name, last name, birth year, and birth month of the student.
				System.out.println("\n\tFirst name: " + firstName);
				System.out.println("\n\tLast name: " + lastName);
				System.out.println("\n\tBirth Year: " + birthYear);
				System.out.println("\n\tBirth Month: " + birthMonth);
				// End parse string.
				
				// Begin determine track division.
				
				
				
				// End determine track division.
			}
		
		} catch (FileNotFoundException e) {
		
			System.out.println("File does not exist or could not be found.");
			
			System.err.println("FileNotFoundException: " + e.getMessage());
		
		} catch (IOException e) {
			
			System.out.println("There was a problem reading the file.");
			
			System.err.println("IOException: " + e.getMessage());
			
		}
		
		System.out.println("\n");
			
	}
		
}




















