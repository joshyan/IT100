/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;

public class Hangman extends ConsoleProgram {
	String word = "";
	String guessresult = "";
	int length = 0;
	int chances = 8;
	
    public void run() {
		/* You fill this in */
    	println("Welcome to Hangman!");
	
    	HangmanLexicon HL = new HangmanLexicon();
    	int i = rgen.nextInt(HL.getWordCount());
    	word = HL.getWord(i);
    	length = word.length();
    	guessresult = this.getDashes(length);
    	
    	println("The word now looks like this: " + guessresult);
    	
    	String guess = "";
    	while(true) {
    		println("You have " + chances + " guesses left.");
    		chances--;
    		
    		guess = readLine("Your guess:");
    		boolean bingo = this.checkGuess(guess.charAt(0));
    		
    		if(bingo) {
    			println("That guess is correct.");
    		} else {
    			println("There are no " + guess + "\'s in the word.");
    		}
    		
    		if(word.equals(guessresult)) {
    			println("You guessed the word: " + word);
    			println("You win.");
    			break;
    		}
    		
    		if(chances > 0) {
	    		println("The word now looks like this: " + guessresult);
    		} else {
    			println("You're completely hung.");
    			println("The word was: " + word);
    			println("You lose");
    			break;		
    		}
    		
    	}
    }

    private String getDashes(int l) {
    	String r = ""; int i = 0;
    	while(i < l) {
    		i++;
    		r += "-";
    	}
    	return r;
    }

    private boolean checkGuess(char g) {
    	int i = 0;
    	String result = "";
    	boolean bingo = false;
    	
    	while(i < length) {
    		if(g == word.charAt(i)) {
    			bingo = true;
    			result += g;
    		} else {
    			result += guessresult.charAt(i);
    		}
    		i++;
    	}
    	
    	this.guessresult = result;
    	
    	return bingo;
    }
    
    private RandomGenerator rgen = RandomGenerator.getInstance();	
}
