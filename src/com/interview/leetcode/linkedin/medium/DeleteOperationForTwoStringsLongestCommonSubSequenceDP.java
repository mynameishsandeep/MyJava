package com.interview.leetcode.linkedin.medium;

/*
 * https://leetcode.com/problems/delete-operation-for-two-strings/description/
 *
 * https://www.youtube.com/watch?v=NnD96abizww&t=37s
 *
 * To make word1, word2 identical, just find the longest common subsequence, count.
The rest of the characters have to be deleted from the both the strings,
which does not belong to longest common subsequence.
 *
 * ========corner cases========
For "ab" and "cd". result is 4.
But logic lcs return 0.
So return word1.length() - longestCommonSubSequence + word2.length() - longestCommonSubSequence;

===========Solution is based on Lowest Common subsequence===================
 * 1) The first row and first column entries, says for 0 "search string" for "input string" output is 0.
 * 2) If character matches then pick value diagonally and add1.
 * 3) Else Pick previous value.
 *
 * 				a || b
 * 				======
 * 				c || current
 *
 * current = a+1 if matches, else Math.max(b,c)

	For Input : Input: text1 = "abcde", text2 = "ace"
		     0  a  b  c  d  e
		0 || 0  0  0  0  0  0
		a || 0  1  1  1  1  1
		c || 0  1  2  2  2  2
		e || 0  1  2  2  2  3

 */
public class DeleteOperationForTwoStringsLongestCommonSubSequenceDP {
  public int minDistance(String word1, String word2) {
    int[][] dp = new int[word1.length() + 1][word2.length() + 1];
    for (int i = 0; i <= word1.length(); i++) {
      for (int j = 0; j <= word2.length(); j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    int lcs = dp[word1.length()][word2.length()];
    return word1.length() - lcs + word2.length() - lcs;
  }
}
