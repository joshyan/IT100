/*
 * File: Target.java
 * Name: Target
 * Section Leader: Josh Yan
 * -----------------
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;



public class Target extends GraphicsProgram {	
	private double init_x = 100;
	private double init_y = 100;
	private double outerWidth = 72 / 2;
	private double middleWidth = 46.8 / 2;
	private double innerWidth = 21.6 / 2;
	
	public void run() {
		GOval outerCircle = getFilledCircle(init_x, init_y, outerWidth, Color.RED);
		add(outerCircle);
		
		GOval middleCircle = getFilledCircle(init_x, init_y, middleWidth, Color.WHITE);
		add(middleCircle);
		
		GOval innerCircle = getFilledCircle(init_x, init_y, innerWidth, Color.RED);
		add(innerCircle);
	}
	
	private GOval getFilledCircle(double x, double y, double r, Color color) {
		GOval GCircle = new GOval(x - r, y - r, 2 * r, 2 * r);
		GCircle.setFilled(true);
		GCircle.setFillColor(color);
		GCircle.setColor(Color.WHITE);
		return GCircle;
	}
}
