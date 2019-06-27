package com.interview.leetcode.linkedin.medium;

/*
 * https://leetcode.com/problems/longest-palindromic-subsequence/description/
 *
 *  Look into picture "LongestPalindromicSubSubSequence.png" in US Problems(Ex: of input "ABCDEF") that depicts  same sub-problems
 *  (highlighted in same color) are getting computed again and again. We know that problems having optimal
 *  substructure and overlapping subproblems can be solved by dynamic programming,
 *  in which subproblem solutions are Memoized rather than computed again and again.
 */
public class LongestPalindromicSubsequence_Recursion {

  public int longestPalindromeSubseq(String s) {
    return longestPalindromeSubseq(0, s.length() - 1, s);
  }

  int longestPalindromeSubseq(int left, int right, String s) {
    if (left == right) return 1;
    else if (left > right) return 0;
    else if (s.charAt(left) == s.charAt(right)) {
      return 2 + longestPalindromeSubseq(left + 1, right - 1, s);
    } else {
      int leftToRight = longestPalindromeSubseq(left + 1, right, s);
      int rightToLeft = longestPalindromeSubseq(left, right - 1, s);
      return Math.max(leftToRight, rightToLeft);
    }
  }
}
