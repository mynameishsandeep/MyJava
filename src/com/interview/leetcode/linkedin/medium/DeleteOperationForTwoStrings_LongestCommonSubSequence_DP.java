package com.interview.leetcode.linkedin.medium;

/*
 * https://leetcode.com/problems/delete-operation-for-two-strings/description/
 * 
 * https://www.youtube.com/watch?v=NnD96abizww&t=37s
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
					dp[i][j] = 0;
				} else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return word1.length() + word2.length() - 2 * dp[word1.length()][word2.length()];
	}
}
