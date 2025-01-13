package english;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Hangman {

	public static void main(String[] args) {
		String[] words = { "PYTHON", "JAVA", "JAVASCRIPT", "HANGMAN", "COMPUTER", "HELLO" };
		Random random = new Random();
		String wordToGuess = words[random.nextInt(words.length)];
		int wordLength = wordToGuess.length();
		char[] wordDisplay = new char[wordLength];
		for (int i = 0; i < wordLength; i++) {
			wordDisplay[i] = '_';
		}

		int attemptsRemaining = 6; // Number of incorrect attempts allowed
		boolean wordGuessed = false;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to Hangman!");
		System.out.println("Guess the word:");

		while (attemptsRemaining > 0 && !wordGuessed) {
			System.out.println("Current word: " + String.valueOf(wordDisplay));
			System.out.println("Attempts remaining: " + attemptsRemaining);
			System.out.print("Guess a letter: ");
			char guess = scanner.next().toUpperCase().charAt(0);

			// Check if the guessed letter is valid
			if (Character.isLetter(guess)) {
				boolean correctGuess = false;

				// Check if the letter is in the word
				for (int i = 0; i < wordLength; i++) {
					if (wordToGuess.charAt(i) == guess) {
						wordDisplay[i] = guess; // Reveal the letter in the display
						correctGuess = true;
					}
				}

				if (correctGuess) {
					System.out.println("Good guess! '" + guess + "' is in the word.");
				} else {
					attemptsRemaining--; // Reduce attempts for incorrect guess
					System.out.println("Sorry, '" + guess + "' is not in the word.");
				}

				// Check if the word has been completely guessed
				wordGuessed = true;
				for (char c : wordDisplay) {
					if (c == '_') {
						wordGuessed = false;
						
					}
				}
			} else {
				System.out.println("Please enter a valid letter.");
			}
		}

		if (wordGuessed) {
			System.out.println("Congratulations! You've guessed the word: " + wordToGuess);
		} else {
			System.out.println("Game over! The word was: " + wordToGuess);
		}

		scanner.close();
	}
}
