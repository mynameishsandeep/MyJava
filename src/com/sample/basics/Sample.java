package com.sample.basics;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 * 
 * Below is BruteForce algorithm based on "PalindromicSubstrings"
 * 
 * 1) Start from 0 th character.
 */
public class Sample {
	private int start, end;
	public class Pair {
		int left , right;
		public  Pair(int left, int right) {
			this.left = left; this.right = right;
		}
		@Override
		public boolean equals(Object p) {
			Pair p1 = (Pair) p;
			return this.left == p1.left && this.right == p1.right;
		}
	}
	private Map<Pair, Integer> map = new HashMap<>();
	public String longestPalindrome(String s) {
		if (s.length() < 2) {
			return s;
		}
		for (int i = 0; i < s.length(); i++) {
			palindrome(s, i, i); // Odd Length Palindrome
			palindrome(s, i, i + 1); // Even Length Palindrome
		}
		return s.substring(start, end);
	}

	public void palindrome(String s, int left, int right) {
		if (s.charAt(left) == s.charAt(right)) {
			Pair p = new Pair(left, right);
			if(map.containsKey(p) ) {
				
			}
			if (end - start < right - left) {
				start = left;
				end = right;
			}
			if (left - 1 >= 0 && right + 1 < s.length()) { // Check Palindrome for next length
				palindrome(s, left - 1, right + 1);
			}
		}
	}
}
