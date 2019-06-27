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

Input: s = "cars", wordDict = ["ca","cars"]
Output: true


Solution approach:
1) start from 0th character as "prefixString", check if it is available in dictionary.
		a) If available, then then do step1 for remaining characters of word.
		b) Else increase the size of "prefixString".
2)  
 */
public class WordBreak {

	public boolean wordBreak(String s, List<String> wordDict) {
		return word_Break(s, new HashSet<>(wordDict), 0);
	}

	public boolean word_Break(String inputString, Set<String> wordDict, int startIndex) {
		if (startIndex == inputString.length()) {
			return true;
		}
		for (int end = startIndex + 1; end <= inputString.length(); end++) {
			String prefixString = inputString.substring(startIndex, end);
			if (wordDict.contains(prefixString)) {
				if (word_Break(inputString, wordDict, end)) {
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
