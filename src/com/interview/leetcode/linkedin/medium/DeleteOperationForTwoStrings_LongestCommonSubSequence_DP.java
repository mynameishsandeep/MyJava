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
==============================
 *
 * Solution is based on Lowest Common subsequence
 *
 * 1) The first row and first column entries, says for 0 "search string" for "input string" output is 0.
 * 2) If character matches then pick value diagonally and add1.
 * 3) Pick previous value.
 *
 *
 * 				a || b
 * 				======
 * 				c || current
 *
 * current = a+1 if matches, else Math.max(b,c)
 *
 */
public class DeleteOperationForTwoStrings_LongestCommonSubSequence_DP {
  public int minDistance(String word1, String word2) {
    int dp[][] = new int[word1.length() + 1][word2.length() + 1];
    for (int i = 0; i <= word1.length(); i++) {
      for (int j = 0; j <= word2.length(); j++) {
        if (i == 0 || j == 0) { // Fill 0th row and 0th column
          continue;
        } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    int longestCommonSubSequence = dp[word1.length()][word2.length()];
    return word1.length() - longestCommonSubSequence + word2.length() - longestCommonSubSequence;
  }
}
