package com.threetier.executerService;

import java.util.Collections;
import java.util.HashMap;

public class CollectionsDemo {

	public static void main(String[] args) {
		
		
		HashMap<String, String> names = new  HashMap<String, String>();
		
		Collections.synchronizedMap(names);
	}
}
