/**
 * TrackDivisions.java
 * Andrew Metz 
 * CSC30
 * START DATE: Friday, June 2nd, 2017
 * COMPLETION DATE:
 * Create a program that determines the track and field division that a student athlete should be competing in.
 */

//Import the class needed to acquire input
import java.util.Scanner;
 
public class TrackDivisions
{

	public static void main(String[] args)
	{		

		final int SHSAA_MONTH = 8;
		
		int SHSAAYear = 2016;
		int birthYear;
		int birthMonth;
		int age = 10;
		int division = 0;
		int cutOffAge;
				
		Scanner input = new Scanner(System.in);
				
		System.out.println("\n\n\t***THE TRACK DIVISIONS PROGRAM ***");
		
		/*System.out.print("\n\tPlease enter the current SHSAA Year: ");
		SHSAAYear = input.nextInt();*/
		
		do {
		
			System.out.print("\n\tPlease enter the year that you were born: ");
			birthYear = input.nextInt();
		
			System.out.print("\n\tPlease enter the month that you were born (as a number): ");
			birthMonth = input.nextInt();
		
			cutOffAge = SHSAAYear - birthYear;
		
			if (cutOffAge > 17) {
				System.out.println("\n\tYou are too old to compete!");
				
			} else if (cutOffAge < 11) {
				System.out.println("\n\tYou are too young to compete!");
				
			}
		
		} while (cutOffAge < 11 || cutOffAge > 17);
		
		System.out.println("\n\tIn the " + SHSAAYear + "/" + (SHSAAYear + 1) + " school year, the student athlete turned " + cutOffAge + " years old.");
				
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
		
			case 10: System.out.println("\n\tYour division is Wee Pee."); break;
			case 11: System.out.println("\n\tYour division is Wee Pee."); break;
			case 12: System.out.println("\n\tYour division is Pee Wee."); break;
			case 13: System.out.println("\n\tYour division is Bantam."); break;
			case 14: System.out.println("\n\tYour division is Midget."); break;
			case 15: System.out.println("\n\tYour division is Junior."); break;
			case 16: System.out.println("\n\tYour division is Senior."); break;
			case 17: System.out.println("\n\tYour division is Senior."); break;
			
		}	

		System.out.println("\n");
	
	}
	
}





















