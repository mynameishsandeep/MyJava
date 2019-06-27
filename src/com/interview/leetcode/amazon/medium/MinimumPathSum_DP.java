package com.interview.leetcode.amazon.medium;

/*
* https://leetcode.com/problems/minimum-path-sum/
* 
Given a m x n grid filled with non-negative numbers, find a path from top left to 
bottom right which minimizes the sum of all numbers along its path.

        1) fill first row by adding prev
        2) fill first col by adding top
        3) Rest Math.min(previous, top) + current

       0 1 2
       =======
  0 || 1 3 1
  1 || 2 7 6
  2 || 6 8 7

*/
public class MinimumPathSum_DP {

  public int minPathSum(int[][] grid) {

    int[][] dp = new int[grid.length][grid[0].length];
    dp[0][0] = grid[0][0];
    for (int i = 1; i < grid[0].length; i++) {
      dp[0][i] = dp[0][i - 1] + grid[0][i];
    }
    for (int i = 1; i < grid.length; i++) {
      dp[i][0] = dp[i - 1][0] + grid[i][0];
    }
    for (int i = 1; i < grid.length; i++) {
      for (int j = 1; j < grid[0].length; j++) {
        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
      }
    }
    return dp[grid.length - 1][grid[0].length - 1];
  }
}
