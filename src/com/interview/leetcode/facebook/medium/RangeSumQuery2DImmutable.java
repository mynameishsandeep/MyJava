package com.interview.leetcode.facebook.medium;

/*
 * we accumulate the sum in the region row by row.
 */
public class RangeSumQuery2DImmutable {
  private int dp[][];

  public RangeSumQuery2DImmutable(int[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0) return;
    dp = new int[matrix.length][matrix[0].length];
    for (int r = 0; r < matrix.length; r++) {
      dp[r][0] = matrix[r][0];
    }
    for (int r = 0; r < matrix.length; r++) {
      for (int c = 1; c < matrix[0].length; c++) {
        dp[r][c] = dp[r][c - 1] + matrix[r][c];
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    int sum = 0;
    for (int r = row1; r <= row2; r++) {
      int previousSum = 0;
      if (col1 != 0) {
        previousSum = dp[r][col1 - 1];
      }
      sum += dp[r][col2] - previousSum;
    }
    return sum;
  }
}
