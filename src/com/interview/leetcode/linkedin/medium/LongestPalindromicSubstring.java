package com.interview.leetcode.linkedin.medium;

/*
 * 
 */
public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		if (s.length() == 0)
			return s;
		char[] c = s.toCharArray();
		String maxPalin = Character.toString(c[0]);
		for (int i = 0; i < c.length; i++) {
			//odd length palindrome
			int ii = i;
			int id = i;
			while (id >= 0 && ii < c.length) {
				if (c[ii] == c[id]) {
					if (maxPalin.length() < s.substring(id, ii + 1).length())
						maxPalin = s.substring(id, ii + 1);
					ii++;
					id--;
				} else
					break;
			}
			ii = i + 1;
			id = i;
			//even length palindrome
			while (id >= 0 && ii < c.length) {
				if (c[ii] == c[id]) {
					if (maxPalin.length() < s.substring(id, ii + 1).length())
						maxPalin = s.substring(id, ii + 1);
					ii++;
					id--;
				} else
					break;
			}
		}
		return maxPalin;
	}
}
