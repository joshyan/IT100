/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {

	// You fill in this part
	public void run() {
		fixColumn();
		while(frontIsClear()) {
			moveToNextColumn();
			fixColumn();
		}
	}
	
	public void fixColumn() {
		turnLeft();
		moveVerticalUp();
		turnAround();
		moveVerticalDown();
		turnLeft();
	}
	
	public void moveVerticalUp() {
		putBeeperIfEmpty();
		while(frontIsClear()) {
			move();
			putBeeperIfEmpty();
		}
	}
	
	public void moveVerticalDown() {
		while(frontIsClear()){
			move();
		}
	}
	
	public void moveToNextColumn() {
		move();
		move();
		move();
		move();
	}
	
	public void putBeeperIfEmpty() {
		if(!beepersPresent()){
			putBeeper();
		}
	}
}
