package com.interview.leetcode.facebook.hard;

public class WildcardMatching_Recursion_Memo {
	private int[][] memo;

	public boolean isMatch(String s, String p) {
		memo = new int[s.length() + 1][p.length() + 1];
		return isMatch(s, p, 0, 0);
	}

	private boolean isMatch(String s, String p, int sIndex, int pIndex) {
		// We have run out of pattern but there are still unmatched characters
		if (pIndex == p.length() && sIndex < s.length()) {
			return false;
			// All characters have been matched.
		} else if (pIndex == p.length() && sIndex == s.length()) {
			return true;
		}

		char sChar;
		char pChar = p.charAt(pIndex);
		if (memo[sIndex][pIndex] != 0) {
			return memo[sIndex][pIndex] == 1;
		}
		if (pChar == '*') {
			boolean match = isMatch(s, p, sIndex, pIndex + 1);
			// Only advance index for s if it is within its length. Moving beyond it is useless
			// recursion since there is no chance of that returning true.
			if (sIndex < s.length()) {
				match = match || isMatch(s, p, sIndex + 1, pIndex) || isMatch(s, p, sIndex + 1, pIndex + 1);
			}
			memo[sIndex][pIndex] = (match) ? 1 : -1;
			return match;
		} else {
			if (sIndex == s.length()) {
				return false;
			}
			sChar = s.charAt(sIndex);
			boolean match = (sChar == pChar) || (pChar == '?');
			match = match && isMatch(s, p, sIndex + 1, pIndex + 1);
			memo[sIndex][pIndex] = (match) ? 1 : -1;
			return match;
		}
	}
}
