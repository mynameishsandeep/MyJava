package com.interview.leetcode.ebay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Below code works only when search string doesn't have duplicates
 * 
 * 1) Put the search string in a Set.
 * 2) Iterate input String.
 * 3) If the input.char(i) present in SearchStringSet 
 * 4) Save the "input.char(i)" with "index" in a map
 * 5) if the "size of map" == "max length of search string" 1 result formed.
 * 6) Get the min index and max index from the map and do substring on input, Which gets 1 result 
 * 
 *  
 */
public class MinimumWindowSubsequence {

	public String minWindow(String s, String t) {
		if (t.length() > s.length()) {
			return "";
		}
		Set<Character> key = new LinkedHashSet<>();
		for (Character c : t.toCharArray()) {
			key.add(c);
		}
		return pangram(s, key);
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

		return finalResult == null ? "" : finalResult;
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

	public static void main(String[] args) {
		MinimumWindowSubsequence m = new MinimumWindowSubsequence();
		System.out.println(m.minWindow("aa", "aa"));
	}
}
