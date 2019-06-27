package com.interview.leetcode.linkedin.medium;

/*
 * https://leetcode.com/problems/longest-palindromic-subsequence/description/
 *
 *  Look into picture "LongestPalindromicSubSubSequence.png" in US Problems(Ex: of input "ABCDEF") that depicts  same sub-problems
 *  (highlighted in same color) are getting computed again and again. We know that problems having optimal
 *  substructure and overlapping subproblems can be solved by dynamic programming,
 *  in which subproblem solutions are Memoized rather than computed again and again.

What is the time and space complexity of the above solution? Since  memoization array dp[st.length()][st.length()]
stores the results for all the subproblems, we can conclude that we will not have more than N*N subproblems
(where ‘N’ is the length of the input sequence). This means that our time complexity will be O(N^2).

The above algorithm will be using O(N^2) space for the memoization array.
Other than that we will use O(N) space for the recursion call-stack. So the total
space complexity will be O(N^2 + N) , which is asymptotically equivalent to O(N^2).
 *
 */
public class LongestPalindromicSubsequence_RecursionMemoization {

  public int longestPalindromeSubseq(String s) {
    return longestPalindromeSubseq(0, s.length() - 1, s, new Integer[s.length()][s.length()]);
  }

  int longestPalindromeSubseq(int left, int right, String s, Integer[][] cache) {
    if (left == right) return 1;
    else if (left > right) return 0;
    else if (cache[left][right] == null) {
      if (s.charAt(left) == s.charAt(right)) {
        cache[left][right] = 2 + longestPalindromeSubseq(left + 1, right - 1, s, cache);
      } else {
        int leftToRight = longestPalindromeSubseq(left + 1, right, s, cache);

        int rightToLeft = longestPalindromeSubseq(left, right - 1, s, cache);
        cache[left][right] = Math.max(leftToRight, rightToLeft);
      }
    }
    return cache[left][right];
  }
}
