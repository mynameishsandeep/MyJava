package com.interview.leetcode.linkedin.easy;

/*
 * https://leetcode.com/problems/shortest-word-distance/description/
 * 
 * 1) Iterate word by word, update the wordIndex with latest index.
 * 2) subtract the index and update shortest path
 */
public class ShortestWordDistance {

	public int shortestDistance(String[] words, String word1, String word2) {
		int word1Index = -1;
		int word2Index = -1;
		int shortestPath = Integer.MAX_VALUE;
		int currentWordIndex = 0;
		for (String word : words) {
			if (word.equals(word1)) {
				word1Index = currentWordIndex;
			} else if (word.equals(word2)) {
				word2Index = currentWordIndex;
			}
			if (word1Index != -1 && word2Index != -1) {
				shortestPath = Math.min(shortestPath, Math.abs(word1Index - word2Index));
			}
			currentWordIndex++;
		}
		return shortestPath;
	}
}
