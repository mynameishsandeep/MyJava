package com.interview.leetcode.linkedin.hard;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/shortest-completing-word/description/
 * 
 */
public class ShortestCompletingWord {

	public String shortestCompletingWord(String licensePlate, String[] words) {
		Map<Character, Integer> map = new HashMap<>();
		for (Character c : licensePlate.toCharArray()) {
			Character lowerC = Character.toLowerCase(c);
			if (Character.isAlphabetic(c)) {
				if (map.containsKey(lowerC)) {
					map.put(lowerC, map.get(lowerC) + 1);
				} else {
					map.put(lowerC, 1);
				}
			}
		}
		String successString = "";
		for (String word : words) {
			if (word.length() == successString.length()) { // optimization to skip same size of next result
				continue;
			}
			boolean success = true;
			String currentSuccessString = word;
			for (Map.Entry<Character, Integer> entry : map.entrySet()) {
				for (int i = 0; i < entry.getValue(); i++) {
					int index = word.indexOf(entry.getKey());
					if (index != -1) {
						word = word.substring(0, index) + word.substring(index + 1);
					} else {
						success = false;
						break;
					}
				}
			}
			if (success) {
				if ("".equals(successString)) {
					successString = currentSuccessString;
				} else {
					if (currentSuccessString.length() < successString.length()) {
						successString = currentSuccessString;
					}
				}
			}

		}
		return successString;
	}

}
