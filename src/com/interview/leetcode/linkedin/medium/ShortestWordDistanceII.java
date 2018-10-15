package com.interview.leetcode.linkedin.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.com/problems/shortest-word-distance-ii/description/
 * 
 * Design a class which receives a list of words in the constructor,
 * and implements a method that takes two words word1 and word2 and 
 * return the shortest distance between these two words in the list. 
 * Your method will be called repeatedly many times with different parameters. 
 */
public class ShortestWordDistanceII {
	Map<String, List<Integer>> map;

	public ShortestWordDistanceII(String[] words) {
		map = new HashMap<>();
		int i = 1;
		for (String word : words) {
			List<Integer> list = map.getOrDefault(word, new ArrayList<>());
			list.add(i++);
			map.put(word, list);
		}
	}

	public int shortest(String word1, String word2) {
		int minDistance = Integer.MAX_VALUE;
		List<Integer> word1Indexes = map.get(word1);
		List<Integer> word2Indexes = map.get(word2);
		for (int i = 0; i < word1Indexes.size(); i++) {
			for (int j = 0; j < word2Indexes.size(); j++) {
				minDistance = Math.min(minDistance, Math.abs(word2Indexes.get(j) - word1Indexes.get(i)));
			}
		}
		return minDistance;
	}
}
