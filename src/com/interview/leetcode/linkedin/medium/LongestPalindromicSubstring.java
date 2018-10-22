package com.interview.leetcode.linkedin.medium;

/*
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 * 
 * Below is BruteForce algorithm based on "PalindromicSubstrings"
 * 
 * 1) Start from 0 th character. Do it for Odd Length Palindrome and then Even Length Palindrome
 * 2) Save the index of left and right.
 * 3) Code can be optimized using memoization. 
 */
public class LongestPalindromicSubstring {
	private int start, end;

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
