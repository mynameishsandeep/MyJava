package com.interview.leetcode.google.medium;
/*
	https://leetcode.com/problems/number-of-islands/

1) Start from 0,0 mark as visited. Recurse in 4 direction.
2) Point is how many time outer loop runs that is result and recursion just marks visited.
3) BackTracking not needed.

 */
public class NumberOfIslands {
  public int numIslands(char[][] grid) {
    int island = 0;
    boolean[][] isVisited = new boolean[grid.length][grid[0].length];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (!isVisited[i][j] && grid[i][j] == '1') {
          island++;
          recur(grid, isVisited, i, j, grid.length, grid[0].length);
        }
      }
    }
    return island;
  }

  private void recur(char[][] grid, boolean[][] isVisited, int r, int c, int rMax, int cMax) {
    if (r < rMax && c < cMax && r >= 0 && c >= 0 && !isVisited[r][c] && grid[r][c] == '1') {
      isVisited[r][c] = true;
      recur(grid, isVisited, r, c + 1, rMax, cMax);
      recur(grid, isVisited, r, c - 1, rMax, cMax);
      recur(grid, isVisited, r + 1, c, rMax, cMax);
      recur(grid, isVisited, r - 1, c, rMax, cMax);
    }
  }
}
