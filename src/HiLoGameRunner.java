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

		// input reader
		Scanner inputReader = new Scanner(System.in);

		// instance of the game
		HiLoGame game = new HiLoGame();

		// the user's response the play again question
		String playAgainResponse;

		// the result of the user's guess
		int guessResult = 0;

		// outer loop to play multiple times
		do {
			// reset the game state
			game.newGame();

			// container for the user's input
			int userInput = -1;

			// while they keep entering numbers and have not gotten the right one or quit
			while ((!game.getGuessedCorrectly()) && (userInput != 0)) {

				System.out.print("Guess the number (enter 0 quit): ");

				// if the user entered a number
				if (inputReader.hasNextInt()) {

					// get the input
					userInput = inputReader.nextInt();

					// if the user didn't say they want to quit
					if (userInput != 0) {

						// get the result from the game
						guessResult = game.makeGuess(userInput);

						// the game class returns 1 if the guess is high
						if (guessResult == 1) {
							System.out.print("High" + System.lineSeparator() + "Guess again: ");
							// the game class returns -1 if the guess is low
						} else if (guessResult == -1) {
							System.out.print("Low" + System.lineSeparator() + "Guess again: ");
							// the game class returns 0 if the guess is correct
						} else {
							//user guessed correctly
							System.out.println("Correct!");
							
							//pretty print the number of guesses
							if (game.getGuessCount() == 1) {
								System.out.println("You got it your first guess!");
							} else {
								System.out.println("You took " + game.getGuessCount() + " guesses.");
							}
						}
					} else {
						// otherwise, say sorry to see them go
						System.out.println("Sorry you don't want to continue this game. ");
					}

				} else {
					// user didn't enter a number, discard and try again
					inputReader.next();
					System.out.println("Please enter a number!");
				}
			}

			do {
				// prompt to play again and force a y/n response
				System.out.print("Play again? (Y/N): ");
				playAgainResponse = inputReader.next();

			} while (!playAgainResponse.equalsIgnoreCase("y") && (!playAgainResponse.equalsIgnoreCase("n")));

		// play again if user said yes
		} while (playAgainResponse.equalsIgnoreCase("y"));

		// close the input reader and thank the user for playing
		inputReader.close();
		System.out.println("Thanks for playing!");
	}
}