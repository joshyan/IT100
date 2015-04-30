/*
 * File: PythagoreanTheorem.java
 * Name: PythagoreanTheorem
 * Section Leader: Josh yan
 * -----------------------------
 */

import acm.program.*;

public class PythagoreanTheorem extends ConsoleProgram {
	public void run() {
		   println( "Enter values to compute Pythagorean Theorem.");
		   
		   while(true) {
			   print("a: ");
			   int a = readInt();
			   print("b: ");
			   int b = readInt();
			   
			   double c = Math.sqrt(a*a + b*b);
			   println("c: " + c);
		   }
		  
	}
}
