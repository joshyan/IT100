/*
 * File: Hailstone.java
 * Name: Hailstone
 * Section Leader: Josh Yan
 * --------------------
 */

import acm.program.*;

public class Hailstone extends ConsoleProgram {
	public void run() {
		println("Enter a number: ");
		int n = readInt();
		int steps = 0;
		while(true) {
			//if n is even
			if(n % 2 == 0) {
				println(n + " is even so I take half: " + n /2);
				n = n / 2;
			} else {
				println(n + " is odd, so I make 3n + 1: " + (3 * n + 1));
				n = 3 * n + 1;
			}
			
			steps++;
			if(n == 1) break;
		}
		
		println("The process took " + steps + " steps to reach 1");
	}

}

