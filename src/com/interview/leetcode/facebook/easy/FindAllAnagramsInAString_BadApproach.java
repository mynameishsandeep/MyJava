package com.interview.leetcode.facebook.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 * 
 * Below is BruteForce:
 * 
 * 1) For each character. If a match found, Run Inner loop for "p" times. 
 * 2) Time Limit Exceeded

 */
public class FindAllAnagramsInAString_BadApproach {
	public List<Integer> findAnagrams(String s, String p) {
		Map<Character, Integer> map = new HashMap<>();
		for (Character c : p.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		List<Integer> result = new ArrayList<>();
		int startIndex = -1;
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				startIndex = i;
				Map<Character, Integer> tempMap = new HashMap<>();
				tempMap.putAll(map);
				for (int j = i; !tempMap.isEmpty() && j < s.length(); j++) {
					if (tempMap.containsKey(s.charAt(j))) {
						Integer value = tempMap.get(s.charAt(j));
						if (value > 1) {
							tempMap.put(s.charAt(j), value - 1);
						} else {
							tempMap.remove(s.charAt(j));
						}
					} else {
						break;
					}
				}
				if (tempMap.isEmpty()) {
					result.add(startIndex);
				}
			}
		}
		return result;
	}
}
