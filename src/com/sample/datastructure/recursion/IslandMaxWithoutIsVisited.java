package com.sample.datastructure.recursion;

/*
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land)
 * connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * Find biggest connected island i.e max 1s in a group (It is not about count of island)
 *
 * https://leetcode.com/problems/max-area-of-island/description/
 *
 * ====================Solution Approach==========
 * In this solution I am updating the source grid from 1 to 0 after it is visited.
 * So this solution doesn't need isVisited
 *
 */
public class IslandMaxWithoutIsVisited {

  int max = 0;

  public int maxAreaOfIsland(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int answer = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          recur(i, m, j, n, grid);
          answer = Math.max(max, answer);
          max = 0;
        }
      }
    }
    return answer;
  }

  public void recur(int row, int rowMax, int col, int colMax, int[][] grid) {
    if (row >= 0 && row < rowMax && col >= 0 && col < colMax && grid[row][col] == 1) {
      max++;
      grid[row][col] = 0;
      recur(row + 1, rowMax, col, colMax, grid);
      recur(row - 1, rowMax, col, colMax, grid);
      recur(row, rowMax, col + 1, colMax, grid);
      recur(row, rowMax, col - 1, colMax, grid);
    }
  }
}
