package com.interview.leetcode.linkedin.medium;

/*
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/
 *
 * 1) Fill the 0th row and 0th column with 0.
 * 2) if matches for a character... 1 + diagonal result.
 *
 *==============Coding Point ================
 *Note: if (A[i - 1] == B[j - 1]) and not A[i] == B[j]
 *=======================================
 */
public class MaximumLengthOfRepeatedSubarrayLongestCommonSubstring {

  /*
     0  1  2   3   2   1
  ======================
  0  0  0  0   0   0   0
  3||0  0  0   1   0   0
  2||0  0  1   0   2   0
  1||0  1  0   0   0   3
  4||0
  7||0
  */
  public int findLength(int[] A, int[] B) {
    int dp[][] = new int[A.length + 1][B.length + 1];
    int result = 0;
    for (int i = 1; i <= A.length; i++) {
      for (int j = 1; j <= B.length; j++) {
        if (A[i - 1] == B[j - 1]) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
          result = Math.max(result, dp[i][j]);
        }
      }
    }
    return result;
  }
}
