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

	public static String determineDivision(int birthYear,int birthMonth)
	{
		
		// Instantiate a variable of the string type to store the result
		String result = "";
		
		// Declare four variables of the integer type to store the age, divison, and cut off age.
		int SHSAAYear = 2016;
		int age = 10;
		int division = 0;
		int cutOffAge;
		
		// Determine the cut off year
		cutOffAge = SHSAAYear - birthYear;
		
		// Using an if else decision structure, determine the division of the student
		if (birthMonth <= 8) {
			do {

				age++;
				division = age;
										
			} while (age != cutOffAge);
			
		} else {
			do {
		
				age++;
				division = age - 1;
										
			} while (age != cutOffAge);
			
		}		
			
		switch (division) {
		
			case 10: result = "Wee Pee"; break;
			case 11: result = "Wee Pee"; break;
			case 12: result = "Pee Wee"; break;
			case 13: result = "Bantam"; break;
			case 14: result = "Midget"; break;
			case 15: result = "Junior"; break;
			case 16: result = "Senior"; break;
			case 17: result = "Senior"; break;
			
		}
		
		return(result);
	
	}

	public static void main(String[] args)
	{
		
		// Instantiate four variables of the string type to store the line of text, the division of the student,
		//		and the student's first and last name.		
		String lineOfText;
		String division;
		String firstName;
		String lastName;
		
		
		
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
				
				// Parse the input string into the last name, first name, birth year, and birth month.
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
				
				// Determine track division.				
				division = determineDivision(birthYear,birthMonth);
				
				System.out.println(firstName + " " + lastName + " is in the " + division + " division.\n");

			}
		
		} catch (FileNotFoundException e) {
		
			System.out.println("File does not exist or could not be found.");
			
			System.err.println("FileNotFoundException: " + e.getMessage());
		
		} catch (IOException e) {
			
			System.out.println("There was a problem reading the file.");
			
			System.err.println("IOException: " + e.getMessage());
			
		}
		
		System.out.println();
			
	}
		
}




















