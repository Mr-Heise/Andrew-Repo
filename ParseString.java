/*
 * ParseString.java
 * Andrew Metz
 * CSC30
 * Start Date: Wednesday 7 June 2017
 * This program simulates processing a line of text from a text file.
 */

/**
 * The ParseString class simulates processing a line of text from a text file.
 */


public class ParseString
{

	public static void main(String[] args)
	{
		// Instantiate three variables of the string type to store the line of text, the last name, and the first name.
		String lineOfText = "Metz,Andrew,1999,7,July";		
		String lastName;
		String firstName;
		
		// Declare three variables of the integer type to store the birth year, birth month, and the position of the comma.
		int birthYear;
		int birthMonth;
		int comma;
		
		// Output a header onto the shell.
		System.out.println("\n\n\t*** THE PARSE STRING SIMULATION PROGRAM ***");
		
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
		
		// Output the first name, last name, birth year, and birth month of the student	
		System.out.println("\n\tFirst name: " + firstName);
		System.out.println("\n\tLast name: " + lastName);
		System.out.println("\n\tBirth Year: " + birthYear);
		System.out.println("\n\tBirth Month: " + birthMonth);
		System.out.println("\n");
	
	}
	
}









