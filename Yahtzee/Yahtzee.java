/*
 * File: Yahtzee.java
 * ------------------
 * This program will eventually play the Yahtzee game.
 */

import acm.io.*;
import acm.program.*;
import acm.util.*;

public class Yahtzee extends GraphicsProgram implements YahtzeeConstants {
	
	public static void main(String[] args) {
		new Yahtzee().start(args);
	}
	
	public void run() {
		IODialog dialog = getDialog();
		nPlayers = dialog.readInt("Enter number of players");
		playerNames = new String[nPlayers];
		for (int i = 1; i <= nPlayers; i++) {
			playerNames[i - 1] = dialog.readLine("Enter name for player " + i);
		}
		display = new YahtzeeDisplay(getGCanvas(), playerNames);
		playGame();
	}

	private void playGame() {
		/* You fill this in */
		int result[][][][] = new int[N_SCORING_CATEGORIES][nPlayers][3][N_DICE];
		for (int i = 0; i < N_SCORING_CATEGORIES; i++) {
			for (int j = 1; j <= nPlayers; j++) {
				display.waitForPlayerToClickRoll(j);
				for(int m = 0; m < 3; m++) {
					if(m == 0) {
						for(int n = 0; n < N_DICE; n++) {
							result[i][j-1][m][n] = rgen.nextInt(1, 6);
						}
						display.displayDice(result[i][j-1][0]);
					} else {
						display.waitForPlayerToSelectDice();
						for(int n = 0; n < N_DICE; n++) {
							if(display.isDieSelected(n)) {
								result[i][j-1][m][n] = rgen.nextInt(1, 6);
							} else {
								result[i][j-1][m][n] = result[i][j-1][m-1][n];
							}
						}
						display.displayDice(result[i][j-1][m]);
					}
				}
				int category = display.waitForPlayerToSelectCategory();
				if(!categoryChosen(category)) {
					boolean p = YahtzeeMagicStub.checkCategory(result[i][j-1][2], category);					
					if(p) {
						display.updateScorecard(category, j, getScore(result[i][j-1][2], category));
					} else {
						display.updateScorecard(category, j, 0);
					}
				}
//				if(p) {
//					display.updateScorecard(category, j, getScore(result[i][j][2], category));
//				}
			}
		}
	}
	
//	private int getScore(int[] c, int category) {
//		
//	}

/* Private instance variables */
	private int nPlayers;
	private String[] playerNames;
	private YahtzeeDisplay display;
	private RandomGenerator rgen = new RandomGenerator();

}
