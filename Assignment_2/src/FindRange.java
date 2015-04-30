/*
 * File: FindRange.java
 * Name: FindRange
 * Section Leader: Josh Yan
 * --------------------
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {
	public void run() {
		println( "This program finds the largest and smallest numbers.");
		
		int largest = 0;
		int smallest = 0;
		int count = 0;
		while(true) {
			print("? ");
			int i = readInt();
			
			// handle first input situation
			if(count == 0) {
				//if first input is 0
				if(i == 0) {
					println("No value is collected.");
					break;
				} else {
					//assign initial smallest and largest
					smallest = largest = i;
				}
			} else {
				//break if input 0
				if(i == 0) {
					break;
				} else {
					//assign new smallest and largest
					if(i >= largest) {
						largest = i;
					}
					if(i <= smallest) {
						smallest = i;
					}
				}
			}
			
			count++;
		}
		
		if(count > 0) {
			println("smallest: " + smallest);
			println("largest: " + largest);				
		}
	}
	
}

