/*
 * File: ProgramHierarchy.java
 * Name: 
 * Section Leader: 
 * ---------------------------
 * This file is the starter file for the ProgramHierarchy problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class ProgramHierarchy extends GraphicsProgram {	
	private double init_x = 200;
	private double init_y = 100;
	private double boxWidth = 140;
	private double boxHeight = 40;
	
	/** Set initial window width and height */
	public void init() {
	    setSize(500, 300);
	}
	
	public void run() {
		GRect rect = new GRect(init_x, init_y, boxWidth, boxHeight);
		add(rect);
		
		GLabel label = new GLabel("Program");
		label.setLocation(init_x + (boxWidth - label.getWidth()) / 2, init_y + (boxHeight + label.getAscent()) / 2);
		add(label);
		
		
	}
}

