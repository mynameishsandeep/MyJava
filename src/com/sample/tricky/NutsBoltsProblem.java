package com.sample.tricky;

import java.util.Arrays;
import java.util.HashMap;

/*
 * https://www.geeksforgeeks.org/nuts-bolts-problem-lock-key-problem-set-2-hashmap/
 */
public class NutsBoltsProblem {
	public static void match(char[] nuts, char[] bolts) {
		//Create a HashMap for nuts, nut as key and its position as value
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < nuts.length; i++) {
			map.put(nuts[i], i);
		}

		//for each bolt , check for the nut in map
		for (int i = 0; i < bolts.length; i++) {
			char bolt = bolts[i];
			if (map.containsKey(bolt)) {
				nuts[i] = bolts[i];
			} else {
				System.out.println("for bolt " + bolt + " no nut is present.");
				return;
			}
		}
		System.out.println("(Hash Map) Matched nuts and bolts are: ");
		System.out.println(Arrays.toString(nuts));
		System.out.println(Arrays.toString(bolts));
	}

	public static void main(String[] args) {
		char[] nuts = { '$', '%', '&', 'x', '@' };
		char[] bolts = { '%', '@', 'x', '$', '&' };
		match(nuts, bolts);
	}

}
