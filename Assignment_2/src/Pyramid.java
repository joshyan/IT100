/*
 * File: Pyramid.java
 * Name: 
 * Section Leader: 
 * ------------------
 * This file is the starter file for the Pyramid problem.
 * It includes definitions of the constants that match the
 * sample run in the assignment, but you should make sure
 * that changing these values causes the generated display
 * to change accordingly.
 */

import acm.graphics.*;
import acm.program.*;

public class Pyramid extends GraphicsProgram {

/** Width of each brick in pixels */
	private static final int BRICK_WIDTH = 30;

/** Width of each brick in pixels */
	private static final int BRICK_HEIGHT = 12;

/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 14;
	
/** The start position of the bottom line */
	private int init_x;
	private int init_y;
	
	/** Set initial window width and height */
	public void init() {
	    setSize(500, 300);
	}
	
	public void run() {
		//set initial x and y point for the bottom line
		this.init_x = getWidth() / 2 - BRICKS_IN_BASE * BRICK_WIDTH / 2;
		this.init_y = getHeight() - BRICK_HEIGHT - 1;
		
		for(int i = 0; i < BRICKS_IN_BASE; i++) {
			drawLineBrick(i);
		}
	}
	
	/**  Draw brick by each line */
	private void drawLineBrick(int i) {
		int begin_x = this.init_x + i * (BRICK_WIDTH / 2);
		int begin_y = this.init_y - i * BRICK_HEIGHT;
		for(int j = 0; j < BRICKS_IN_BASE - i; j++) {
			int x = begin_x + j * BRICK_WIDTH;
			int y = begin_y;
			GRect rect = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
			add(rect);
		}
		
	}
	
}

