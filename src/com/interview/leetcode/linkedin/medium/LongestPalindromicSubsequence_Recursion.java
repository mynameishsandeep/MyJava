package com.interview.leetcode.linkedin.medium;

/*
 * https://leetcode.com/problems/longest-palindromic-subsequence/description/
 * 
 * Add memoization for the target to make it efficient
 * https://leetcode.com/problems/longest-palindromic-subsequence/discuss/99111/Evolve-from-brute-force-to-dp
 */
public class LongestPalindromicSubsequence_Recursion {

	public int longestPalindromeSubseq(String s) {
		return longestPalindromeSubseq(0, s.length() - 1, s);
	}

	int longestPalindromeSubseq(int l, int r, String s) {
		if (l == r)
			return 1;
		if (l > r)
			return 0;  
		if (s.charAt(l) == s.charAt(r)) {
			return 2 + longestPalindromeSubseq(l + 1, r - 1, s);
		} else {
			int leftToRight = longestPalindromeSubseq(l + 1, r, s);
			int rightToLeft = longestPalindromeSubseq(l, r - 1, s);
			return Math.max(leftToRight, rightToLeft);
		}
	}

}
