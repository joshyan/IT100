/*
 * File: ProgramHierarchy.java
 * Name: ProgramHierarchy
 * Section Leader: Josh Yan
 * ---------------------------
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class ProgramHierarchy extends GraphicsProgram {	

	private double boxWidth = 140;
	private double boxHeight = 40;
	
	/** Set initial window width and height */
	public void init() {
	    setSize(700, 400);
	}
	
	public void run() {
		// define initial x and y and set space between boxes
		double init_x = getWidth() / 2 - boxWidth / 2;
		double init_y = 100;
		int horizon_span = 40;
		int vertical_span = 40;
		
		//add four boxes
		createBox(init_x, init_y, "Program");
		
		double boxBottomLeftX = init_x - boxWidth - horizon_span;
		double boxBottomLeftY = init_y + boxHeight + vertical_span;
		createBox(boxBottomLeftX, boxBottomLeftY, "GraphicsProgram");
		
		double boxBottomMiddleX = init_x;
		double boxBottomMiddleY = init_y + boxHeight + vertical_span;
		createBox(boxBottomMiddleX, boxBottomMiddleY, "ConsoleProgram");
		
		double boxBottomRightX = init_x + boxWidth + horizon_span;
		double boxBottomRightY = init_y + boxHeight + vertical_span;
		createBox(boxBottomRightX, boxBottomRightY, "DialogProgram");
		
		//add three lines
		GLine line_left = new GLine(init_x + boxWidth / 2, init_y + boxHeight, init_x - boxWidth - horizon_span + boxWidth / 2, init_y  + boxHeight + vertical_span);
		add(line_left);
		
		GLine line_middle = new GLine(init_x + boxWidth / 2, init_y + boxHeight, init_x + boxWidth / 2, init_y  + boxHeight + vertical_span);
		add(line_middle);
		
		GLine line_right = new GLine(init_x + boxWidth / 2, init_y + boxHeight, init_x + boxWidth + horizon_span + boxWidth / 2, init_y  + boxHeight + vertical_span);
		add(line_right);
	}
	
	private void createBox(double init_x, double init_y, String text) {
		GRect rect = new GRect(init_x, init_y, boxWidth, boxHeight);
		add(rect);
		
		GLabel label = new GLabel(text);
		label.setLocation(init_x + (boxWidth - label.getWidth()) / 2, init_y + (boxHeight + label.getAscent()) / 2);
		add(label);
	}
	

}

