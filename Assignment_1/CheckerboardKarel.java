/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	// You fill in this part
	public void run(){
		putBeeper();
		while(!endOfWorld()){
			moveOneStep();
			if(!endOfWorld()){
				moveOneStep();
				putBeeper();
			}
		}
	}
	
	public boolean endOfWorld(){
		if(facingEast()) {
			if(!leftIsClear() && !frontIsClear()) {
				return true;
			} else {
				return false;
			}
		} else if(facingWest()){
			if(!rightIsClear()&& !frontIsClear()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public void moveOneStep(){
		if(facingEast()) {
			if(frontIsClear()) {
				move();
			} else {
				turnLeft();
				move();
				turnLeft();
			}
		} else if(facingWest()) {
			if(frontIsClear()) {
				move();
			} else {
				turnRight();
				move();
				turnRight();
			}
		}
	}
}
