//==============================================
// Andrew Asquith
// COMP 1131
// Assignment 3 
// Vowel Counter Application 
//
// This is the main entry point for the vowel counter.
// It prompts for any input string, passes it to the 
// vowel counter class for parsing and prints the result.
// 
//==============================================

//import the Scanner class
import java.util.Scanner;

//main entry point for the vowel counter application
public class VowelCounterRunner {

	public static void main(String[] args) {

		//input Scanner
		Scanner inputReader = new Scanner(System.in);
		
		//container for user input
		String userInput;
		
		do {
			//quit will be the exit value, we'll print the results for it as well though
			System.out.print("Enter one or more words (\"quit\" to exit after): ");
			
			//take the whole line the user enters and trim extra whitespace
			userInput = inputReader.nextLine().trim();

			//pass the user input to the vowel counter for examination
			VowelCounter vowelCounter = new VowelCounter(userInput);
			
			//print the results of the vowel counter
			System.out.println(vowelCounter);
			//print a blank line for spacing
			System.out.println();

		//if the user entered quit, exit
		} while (!userInput.equalsIgnoreCase("quit"));
		
		//close the input reader and say goodbye
		inputReader.close();
		System.out.println("Goodbye!");
	}
}