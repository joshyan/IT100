/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Breakout extends GraphicsProgram {

/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 0;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	private static final int BALL_Y_OFFSET = 20;
	
/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 3;

	/** Animation delay or pause time between ball moves */  
	private static final int DELAY = 20;
	
	/* private instance variable */  
	private int LIFE = NTURNS;
	private double DX;
	private double DY;
	
	public void init() {
		setSize(WIDTH, HEIGHT);
		addMouseListeners(); 
	}
	
	/* Method: run() */
	/** Runs the Breakout program. */
	public void run() {
		//gameInit();
		// initial the game
		while(true) {
			gameInit();
			gameOn();
			if(LIFE == 0) {
				break;
			}
		}

		gameOver();
	}
	
	private void gameOn() {
		while(true){
			ball.move(DX, DY);
			checkCollisionBorder();
			checkCollisionElement();
			pause(DELAY); 
			if(checkDead()) {
				LIFE -= 1;
				clearBoard();
				break;
			}
		}
	}
	
	private void gameInit() {
		// prepare the environment
		drawBricks();
		drawPaddle();
		drawBall();
		DX = rgen.nextInt(BALL_RADIUS) + 1;
		DY = rgen.nextInt(BALL_RADIUS) + 1;		
		// how to set wait?
//		try {
//			wait();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
//	public void mouseClicked(MouseEvent e) { 
//		if(STATUS == 1) {
//			// set random direction to ball
//			INC_X = rgen.nextInt(BALL_RADIUS);
//			INC_Y = rgen.nextInt(BALL_RADIUS);
//		}
//	}
	 
	private void drawBricks() {
		int init_x = 0;
		int init_y = BALL_Y_OFFSET;
		for(int i = 0; i < NBRICK_ROWS; i++) {
			int y = init_y + i * BRICK_HEIGHT;
			for(int j = 0; j < NBRICKS_PER_ROW; j++) {
				int x = init_x + j * (BRICK_WIDTH + BRICK_SEP);
				GRect rect = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
				addColor(rect, i);
				add(rect);
			}
		}
	}
	
	private void addColor(GRect r, int i) {
		switch(i) {
			case 0:
				r.setFilled(true);
				r.setFillColor(Color.green);
				break;
			case 1:
				r.setFilled(true);
				r.setFillColor(Color.red);
				break;
			case 2:
				r.setFilled(true);
				r.setFillColor(Color.yellow);
				break;
			case 3:
				r.setFilled(true);
				r.setFillColor(Color.blue);	
				break;
			default:
				break;
		}
	}
	
	private void drawPaddle() {
		int x = (WIDTH - PADDLE_WIDTH) / 2;
		int y = HEIGHT - PADDLE_Y_OFFSET;
		paddle = new GRect(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
		add(paddle);
	}
	
	private void drawBall() {
		int X_START = WIDTH / 2;
		int Y_START = BRICK_Y_OFFSET + BRICK_HEIGHT * NBRICK_ROWS + BALL_Y_OFFSET + BALL_RADIUS;
		ball = getFilledCircle(X_START, Y_START, BALL_RADIUS, Color.BLACK);   
		add(ball); 
	}
	
	private void gameOver() {
		
	}
	
	private GOval getFilledCircle(double x, double y, double r, Color color) {
		GOval GCircle = new GOval(x - r, y - r, 2 * r, 2 * r);
		GCircle.setFilled(true);
		GCircle.setFillColor(color);
		GCircle.setColor(Color.WHITE);
		return GCircle;
	}
	
	private void checkCollisionBorder() {
		if(ball.getX() < 0 || ball.getX() > WIDTH - 2 * BALL_RADIUS) {
			DX = -DX;
		}
		if(ball.getY() < 0) {
			DY = -DY;
		}
	}
	
	private GObject getCollidingObject() {
	    double x = ball.getX(), y = ball.getY();
	    if (getElementAt(x, y) != null) { return getElementAt(x, y); }
	    else if (getElementAt(x, y + BALL_RADIUS * 2) != null) { 
	        return getElementAt(x, y + BALL_RADIUS * 2); }
	    else if (getElementAt(x + BALL_RADIUS * 2, y + BALL_RADIUS * 2) != null) {
	        return getElementAt(x + BALL_RADIUS * 2, y + BALL_RADIUS * 2); }
	    else if (getElementAt(x + BALL_RADIUS * 2, y) != null) {
	        return getElementAt(x + BALL_RADIUS * 2, y); }
	        else { return null; }
	}
	
	private void checkCollisionElement() {
		GObject collider = getCollidingObject();
	     if (collider == paddle) { 
	    	 DY = -DY; 
	     }
	     else if (collider != null) { 
	         remove(collider); 
	         DY = -DY;
	     }
	}
//	private void checkCollisionElement() {
//		GObject element_left = getElementAt(ball.getX() - 1, ball.getY() + BALL_RADIUS);
//		GObject element_right = getElementAt(ball.getX() + 2 * BALL_RADIUS + 1, ball.getY() + BALL_RADIUS);
//		GObject element_top = getElementAt(ball.getX() + BALL_RADIUS, ball.getY() - 1);
//		GObject element_bottom = getElementAt(ball.getX() + BALL_RADIUS, ball.getY() + 2 * BALL_RADIUS + 1);
//		if(element_bottom == paddle) {
//			DY = -DY;
//		} else {
//			if(element_left != null) {
//				remove(element_left);
//				DX = -DX;
//			}
//			if(element_right != null) {
//				remove(element_right);
//				DX = -DX;
//			}
//			if(element_top != null) {
//				remove(element_top);
//				DY = -DY;
//			}
//			if(element_bottom != null) {
//				remove(element_bottom);
//				DY = -DY;
//			}
//		}
//		
//	}

	private boolean checkDead() {
		double ball_middle_x = ball.getX() + BALL_RADIUS;
		double ball_bottom_y = ball.getY() + 2 * BALL_RADIUS;
		if(ball_bottom_y > (HEIGHT - PADDLE_Y_OFFSET)) {
			if(ball_middle_x < paddle.getX() || ball_middle_x > (paddle.getX() + PADDLE_WIDTH)) {
				return true;
			}
		}
		return false;
	}
	
	public void mouseMoved(MouseEvent e) {
		paddle.move(e.getX() - paddle.getX(), 0);
	} 
	
	private void clearBoard() {
		remove(ball);
		remove(paddle);
//		for(GRect brick: bricks) {
//			remove(brick);
//		}
	}
	
	private RandomGenerator rgen = RandomGenerator.getInstance();	
	private GOval ball;
	private GRect paddle;
	//private ArrayList<GRect> bricks;
	
}
