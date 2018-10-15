package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/sort-characters-by-frequency/description/ 
 */
public class SortCharactersByFrequency {
	public String frequencySort(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (Character c : s.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		Map<Integer, List<Character>> treeMap = new TreeMap<>(Collections.reverseOrder());
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (treeMap.containsKey(entry.getValue())) {
				treeMap.get(entry.getValue()).add(entry.getKey());
			} else {
				treeMap.put(entry.getValue(), new ArrayList<>(Arrays.asList(entry.getKey())));
			}
		}
		StringBuilder result = new StringBuilder();
		for (Map.Entry<Integer, List<Character>> entry : treeMap.entrySet()) {
			for (Character c : entry.getValue()) {
				if (entry.getKey() > 1) {
					result.append(appendCharacter(c, entry.getKey()));
				} else {
					result.append(c);
				}
			}
		}
		return result.toString();
	}

	public String appendCharacter(Character c, int numberOfTimes) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < numberOfTimes; i++) {
			s.append(c);
		}
		return s.toString();
	}
}
