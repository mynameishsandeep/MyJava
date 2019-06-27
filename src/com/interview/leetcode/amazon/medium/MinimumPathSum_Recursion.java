package com.interview.leetcode.amazon.medium;

/*
* https://leetcode.com/problems/minimum-path-sum/
*
Given a m x n grid filled with non-negative numbers, find a path from top left to
bottom right which minimizes the sum of all numbers along its path.

*/
public class MinimumPathSum_Recursion {

  private int min = Integer.MAX_VALUE;

  public int minPathSum(int[][] grid) {
    minPathSum(grid, 0, 0, 0);
    return min;
  }

  public void minPathSum(int[][] grid, int row, int col, int total) {
    if (row == grid.length - 1 && col == grid[0].length) {
      // System.out.println("Min" + min);
      min = Math.min(min, total);
    } else if (row < grid.length && col < grid[0].length) {
      // System.out.println(total);
      minPathSum(grid, row, col + 1, total + grid[row][col]);
      // System.out.println(total);
      minPathSum(grid, row + 1, col, total + grid[row][col]);
    }
  }
}
