/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;



public class Target extends GraphicsProgram {	
	private double init_x = 200;
	private double init_y = 100;
	private double outerWidth = 72;
	private double outerHeight = 72;
	private double middleWidth = 46.8;
	private double middleHeight = 46.8;
	private double innerWidth = 21.6;
	private double innerHeight = 21.6;
	
	/** Set initial window width and height */
	public void init() {
	    setSize(460, 280);
	}
	
	public void run() {
		GOval outerCircle = new GOval(init_x, init_y, outerWidth, outerHeight);
		outerCircle.setFilled(true);
		outerCircle.setColor(Color.WHITE);
		outerCircle.setFillColor(Color.RED);
	    add(outerCircle);

		GOval middleCircle = new GOval(init_x + (outerWidth - middleWidth) / 2, init_y + (outerHeight - middleHeight) / 2, middleWidth, middleHeight);
		middleCircle.setFilled(true);
		middleCircle.setColor(Color.WHITE);
		middleCircle.setFillColor(Color.WHITE);
	    add(middleCircle);
	    
		GOval innerCircle = new GOval(init_x + (outerWidth - innerWidth) / 2, init_y + (outerHeight - innerHeight) / 2, innerWidth, innerHeight);
		innerCircle.setFilled(true);
		innerCircle.setColor(Color.WHITE);
		innerCircle.setFillColor(Color.RED);
	    add(innerCircle);
	}
}
