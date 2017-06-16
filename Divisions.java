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
			
				// Increment the age
				age++;
				
				// Set the division to the age.
				division = age;
				
			// Do this while age does not equal the cut off age.					
			} while (age != cutOffAge);
			
		} else {
			do {
				
				// Increment the age
				age++;
				
				// Set the division to the age minus one.
				division = age - 1;
				
			// Do this while age does not equal the cut off age.						
			} while (age != cutOffAge);
			
		}		
		
		// Use a switch decision structure to determine the result.
		switch (division) {
		
			case 10: result = "Wee Pee"; break;
			case 11: result = "Wee Pee"; break;
			case 12: result = "Pee Wee"; break;
			case 13: result = "Bantam"; break;
			case 14: result = "Midget"; break;
			case 15: result = "Junior"; break;
			default: result = "Senior"; break;
			
		}
		
		// Return the result.
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
		
		// Declare a variable of the integer type to store a counter.
		int counter = 0;
		
		// Create a new File and FileReader to acquire the input file.
		File textFile = new File("Track_Division_Input_File.csv");
		FileReader in;
		BufferedReader readFile;
		
		// Create a new File and FileWriter to otuput the output file.
		File outputFile = new File("Track_Divisions.txt");
		FileWriter out;
		BufferedWriter writeFile;
		
		try {
			
			in = new FileReader(textFile);
			
			readFile = new BufferedReader(in);
			
			out = new FileWriter(outputFile);
			
			writeFile = new BufferedWriter(out);
			
			writeFile.write("\n\t*** TRACK AND FIELD DIVISIONS FOR EHS STUDENTS IN THE 2016/2017 SCHOOL YEAR ***\n");
			
			while ((lineOfText = readFile.readLine()) != null) {
				
				// Increment the counter
				counter++;
				
				// Parse the input string into the last name, first name, birth year, and birth month variables.
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
				
				writeFile.write("\n\t" + lastName + ", " + firstName + " is in the " + division + " division.\n");
				
			}
			
			writeFile.close();
			
			System.out.println("\n\tProcessing complete. " + counter + " results were written to the output file.\n");
		
		} catch (FileNotFoundException e) {
		
			System.out.println("File does not exist or could not be found.");
			
			System.err.println("FileNotFoundException: " + e.getMessage());
		
		} catch (IOException e) {
			
			System.out.println("There was a problem reading the file.");
			
			System.err.println("IOException: " + e.getMessage());
			
		}
			
	}
		
}




















