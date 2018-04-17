package com.interview.leetcode.ebay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MinimumWindowSubsequence {

	public String minWindow(String S, String T) {
		return null;
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
