package com.interview.leetcode.google.medium;
/*
	https://leetcode.com/problems/number-of-islands/

1) Start from 0,0 mark as visited. Recurse in 4 direction.
2) Point is how many time outer loop runs that is result and recursion updates the source from 1 to 0.
3) BackTracking not needed.
4) We can update the source grid to 0 after each visit, so no need of isVisited

 */
public class NumberOfIslandsWithoutIsVisited {
  // Start from 0,0 mark as visited. Recurse in 4 direction.
  // Point is how many time outer loop runs that is result and recursion marks visited.
  // BackTracking not needed.
  public int numIslands(char[][] grid) {
    int island = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          island++;
          recur(grid, i, j, grid.length, grid[0].length);
        }
      }
    }
    return island;
  }

  private void recur(char[][] grid, int r, int c, int rMax, int cMax) {
    if (r < rMax && c < cMax && r >= 0 && c >= 0 && grid[r][c] == '1') {
      grid[r][c] = '0';
      recur(grid, r, c + 1, rMax, cMax);
      recur(grid, r, c - 1, rMax, cMax);
      recur(grid, r + 1, c, rMax, cMax);
      recur(grid, r - 1, c, rMax, cMax);
    }
  }
}
