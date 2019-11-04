package com.walmart.string;

/*
* https://leetcode.com/problems/longest-common-subsequence/

* 				a || b
* 				======
* 				c || current
*
* current = a+1 if matches, else Math.max(b,c)

*/
public class LongestCommonSubsequence {

  /*
   * For Input : Input: text1 = "abcde", text2 = "ace"
   *
       0  a  b  c  d  e
  0 || 0  0  0  0  0  0
  a || 0  1  1  1  1  1
  c || 0  1  2  2  2  2
  e || 0  1  2  2  2  3

     */
  public int longestCommonSubsequence(String text1, String text2) {
    int[][] dp = new int[text1.length() + 1][text2.length() + 1];
    for (int i = 1; i <= text1.length(); i++) {
      for (int j = 1; j <= text2.length(); j++) {
        if (text1.charAt(i - 1) == text2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
        else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
      }
    }
    return dp[text1.length()][text2.length()];
  }
}
