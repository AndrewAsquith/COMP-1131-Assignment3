//==============================================
// Andrew Asquith
// COMP 1131
// Assignment 3 
// Hi-Lo Game Class 
//
// This is the Hi-Lo game class.
// It chooses a random number, tracks if the user
// has guessed correctly and returns information
// to the caller based on the user's guess.
//
//==============================================

//import the Random class since we need bounds
import java.util.Random;

public class HiLoGame {

	// the secret number
	private int secretNumber;

	// the random number generator
	private Random rng;

	// public boolean indicating if it's been guessed correctly
	private boolean guessedCorrectly;

	// constructor creates the RNG instance
	public HiLoGame() {
		rng = new Random();
	}

	// method for making guesses
	// 1 is returned if the guess was high
	// -1 is returned if the guess was low
	// 0 is returned if the guess was correct
	public int makeGuess(int guess) {

		// if the user got the right number
		if (guess == secretNumber) {
			// set the guessed correctly flag to true and return 0
			guessedCorrectly = true;
			return 0;

		} else if (guess > secretNumber) {
			// return 1 if the guess was too high
			return 1;

		} else {
			// otherwise the guess was too low, return -1
			return -1;
		}
	}

	// public getter for the guessed correctly flag
	public boolean getGuessedCorrectly() {
		return guessedCorrectly;
	}

	// method to reset the game state
	public void newGame() {

		// reset the guessed correctly flag
		guessedCorrectly = false;

		// choose a new secret number from 1-99
		secretNumber = rng.nextInt(98) + 1;
	}
}