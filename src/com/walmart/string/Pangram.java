package com.walmart.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Find the smallest window in a string containing all characters of another
 * string
 * http://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
 * 
 * 1) Iterate input by Character. 
 * 2) If a character matches key, put it on subStringMap with index.
 * 3) If the map size == key length... Then 1 output formed. Put it on result array
 * 4) For Each subsequent matching character key. Form the output and put in on result array
 * 5) The smallest of array is the result.
 * 
 *  Note: This solution will not work for keys with duplicate. 
 *  Example. Find 'tist' on "this is a test string". It will look only tis
 */
public class Pangram {
	public static void main(String[] args) {
		Set<Character> set = new HashSet<>();
		set.add('o');set.add('r');set.add('k');
		System.out.println(new Pangram().pangram("geeksforgeeks", set));
		System.out.println(new Pangram().pangram("geeksforgeeksork", set));
		set.clear();
		set.add('t');set.add('i');set.add('s');set.add('t');
		System.out.println(new Pangram().pangram("this is a test string", set));
	}

	public String pangram(final String input, final Set<Character> key) {
		List<String> allResult = new ArrayList<>();
		String finalResult = null;
		Map<Character, Integer> subStringMap = new HashMap<>();
		for (int i = 0; i < input.length(); i++) {
			if (key.contains(input.charAt(i))) {
				subStringMap.put(input.charAt(i), i);
				if (verifySubStringFilled(subStringMap, key.size())) {
					String result = getTheSubString(subStringMap, input);
					if (finalResult == null || finalResult.length() > result.length()) {
						finalResult = result;
					}
					allResult.add(result);
				}
			}
		}
		System.out.println(allResult.toString());
		return finalResult;
	}

	private String getTheSubString(final Map<Character, Integer> subStringMap, String input) {
		int min = Integer.MAX_VALUE;
		int max = 0;
		for (Map.Entry<Character, Integer> map : subStringMap.entrySet()) {
			if (map.getValue() < min) {
				min = map.getValue();
			}
			if (map.getValue() > max) {
				max = map.getValue();
			}
		}
		return input.substring(min, max + 1);
	}

	private Boolean verifySubStringFilled(final Map<Character, Integer> subStringMap, Integer keyLength) {
		return subStringMap.size() == keyLength;

	}
}