/*
 * Divisions.java
 * Andrew Metz and Jesse Maki
 * CSC30
 * Start Date: Thursday, June 8th, 2017
 * Finish Date: Monday, June 19th, 2017
 * Create a program that sorts students into track divisions using a comma-delimited file. All results will be exported into a divisions.txt file.
 * The input file is in the following order: lastName,firstName,birthYear,birthMonth.
 */

// Import the java package necessary to work with inputting and outputting files.
import java.io.*;

/**
 * The Divisions class sorts students into track divisions using a comma-delimited file. All results will be exported into a Track_Divisions.txt file.
 */
 
public class Divisions
{

	public static String determineDivision(int birthYear,int birthMonth)
	{
		
		// Instantiate a variable of the string type to store the result.
		String result = "";
		
		// Declare four variables of the integer type to store the SHSAA year, SHSAA month, the starting age, the divison, and the cut off age.
		int SHSAAYear = 2016;
		int SHSAAMonth = 8;
		int age = 10;
		int division = 0;
		int cutOffAge;
		
		// Determine the cut off year.
		cutOffAge = SHSAAYear - birthYear;
		
		// Using an if else decision structure, determine the division of the student.
		if (birthMonth <= SHSAAMonth) {
			do {
			
				// Increment the age by one.
				age++;
				
				// Set the division to the age.
				division = age;
				
			// Do this while age does not equal the cut off age.					
			} while (age != cutOffAge);
			
		} else {
			do {
				
				// Increment the age by one.
				age++;
				
				// Set the division to the age minus one.
				division = age - 1;
				
			// Do this while age does not equal the cut off age.						
			} while (age != cutOffAge);
			
		}		
		
		// Use a switch decision structure to determine the result and set it to a result variable.
		switch (division) {
		
			case 10:
			case 11: result = "Wee Pee"; break;
			case 12: result = "Pee Wee"; break;
			case 13: result = "Bantam"; break;
			case 14: result = "Midget"; break;
			case 15: result = "Junior"; break;
			case 16:
			case 17:
			case 18: result = "Senior"; break;
			
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
		
		// Create a new File and FileWriter to create and output the output file.
		File outputFile = new File("Track_Divisions.txt");
		FileWriter out;
		BufferedWriter writeFile;
		
		// Using a try decisions structure, determine the inputted student's division based on the input file and output it to an output file.
		try {
			
			// Instantiate the file objects needed to read an input file and then write to an output file.
			in = new FileReader(textFile);
			readFile = new BufferedReader(in);
			out = new FileWriter(outputFile);
			writeFile = new BufferedWriter(out);
			
			// Write a header to the file.
			writeFile.write("\n\t*** TRACK AND FIELD DIVISIONS FOR EHS STUDENTS IN THE 2016/2017 SCHOOL YEAR ***\n");
			
			while ((lineOfText = readFile.readLine()) != null) {
				
				// Increment the counter by one.
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
				
				// Output the frist and last name of a student and the division they are in. 
				writeFile.write("\n\t" + lastName + ", " + firstName + " is in the " + division + " division.\n");
				
			}
			
			// Close the write file.
			writeFile.close();
			
			// Output a message to the terminal telling the user that the file writing was a success.
			System.out.println("\n\tProcessing complete. " + counter + " results were written to the output file.\n");
		
		// Create an error trap for if the file does not exist or could not be found and output it to the terminal.
		} catch (FileNotFoundException e) {
		
			// Output the error message based on the file not found exception.
			System.out.println("File does not exist or could not be found.");
			System.err.println("FileNotFoundException: " + e.getMessage());
		
		// Create an error trap for if the file could not be read.
		} catch (IOException e) {
			
			// Output the error based on the IOException.
			System.out.println("There was a problem reading the file.");
			System.err.println("IOException: " + e.getMessage());
			
		}
			
	}
		
}




















