import java.util.HashMap;
import java.util.Set;

import acm.program.*;

public class NameCounts extends ConsoleProgram {
	
	public void run() {
		HashMap<String, Integer> hash = new HashMap<>();
		
		while(true) {
			String input = readLine("Enter name:");
			if(input.isEmpty()) {
				break;
			} else {
				int value;
				if(hash.get(input)  == null) {
					value = 1;
				} else {
					value = hash.get(input) + 1;
				}
				
				hash.put(input, value);
			}
		}
		
		Set<String> keys = hash.keySet();
		for (String key : keys) {
			println("Entry [" + key + "] has count " + hash.get(key));
		}
	}
	
}
