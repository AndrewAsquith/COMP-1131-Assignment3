//==============================================
// Andrew Asquith
// COMP 1131
// Assignment 3 
// Hi-Lo Game Application 
//
// This is the main entry point for the Hi-Lo game.
// It creates an instance of the Hi-Lo game class
// and controls the prompting for input and program flow
//
//==============================================

//import the scanner class
import java.util.Scanner;

public class HiLoGameRunner {

	public static void main(String[] args) {

		//input reader
		Scanner inputReader = new Scanner(System.in);

		//instance of the game 
		HiLoGame game = new HiLoGame();
		
		//the result of the user's guess
		int guessResult = 0;
		
		//indicator if they want to keep playing
		boolean keepPlaying = true;

		do {
			//reset the game state
			game.newGame();

			System.out.print("Guess the number (or enter non-numeric input to quit): ");

			//while they keep entering numbers and have not gotten the right one
			while ((!game.getGuessedCorrectly()) && (inputReader.hasNextInt())) {

				//get the result from the game
				guessResult = game.makeGuess(inputReader.nextInt());

				//the game class returns 1 if the guess is high
				if (guessResult == 1) {
					System.out.print("High" + System.lineSeparator() + "Guess Again: ");
				//the game class returns -1 if the guess is low
				} else if (guessResult == -1) {
					System.out.print("Low" + System.lineSeparator() + "Guess Again: ");
				//the game class returns 0 if the guess is correct
				} else {
					System.out.println("Correct!");
				}
			}

			// clear the input reader
			inputReader.nextLine();

			//ask if the user wants to play again
			System.out.print("Type \"yes\" to play again, anything else to quit: ");
			keepPlaying = inputReader.nextLine().equalsIgnoreCase("yes");
			
		} while (keepPlaying);
		
		//close the input reader and thank the user for playing
		inputReader.close();
		System.out.println("Thanks for playing!");
	}
}