package com.interview.leetcode.amazon.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * https://leetcode.com/problems/word-break/description/
 * 
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * 
 * 
 */

/*
Input: s = "bb", wordDict = ["a","b","bbb","bbbb"]
Expected: true

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false

Input: s = "cars", wordDict = ["car","ca","rs"]
Output: true
 */
public class WordBreak {

	public boolean wordBreak(String s, List<String> wordDict) {
		return word_Break(s, new HashSet<>(wordDict), 0);
	}

	public boolean word_Break(String s, Set<String> wordDict, int start) {
		if (start == s.length()) {
			return true;
		}
		for (int end = start + 1; end <= s.length(); end++) {
			if (wordDict.contains(s.substring(start, end))) {
				if (word_Break(s, wordDict, end)) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		WordBreak w = new WordBreak();
		String s = "catsandog";
		List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
		w.wordBreak(s, wordDict);
	}
}
