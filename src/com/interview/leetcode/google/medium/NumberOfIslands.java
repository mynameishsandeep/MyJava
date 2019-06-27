package com.interview.leetcode.google.medium;

// Start from 0,0 mark as visited. Recurse in 4 direction.
// Point is how many time outer loop runs that is result and recursion just marks visited.
// BackTracking not needed.
// https://leetcode.com/problems/number-of-islands/
public class NumberOfIslands {
  public int numIslands(char[][] grid) {
    int island = 0;
    if (grid.length == 0) return 0;
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
    isVisited[r][c] = true;
    if (c + 1 < cMax && !isVisited[r][c + 1] && grid[r][c + 1] == '1') { // Move right
      recur(grid, isVisited, r, c + 1, rMax, cMax);
    }
    if (c - 1 >= 0 && !isVisited[r][c - 1] && grid[r][c - 1] == '1') { // Move left
      recur(grid, isVisited, r, c - 1, rMax, cMax);
    }
    if (r + 1 < rMax && !isVisited[r + 1][c] && grid[r + 1][c] == '1') { // Move top to bottom
      recur(grid, isVisited, r + 1, c, rMax, cMax);
    }
    if (r - 1 >= 0 && !isVisited[r - 1][c] && grid[r - 1][c] == '1') { // Move bottom to top
      recur(grid, isVisited, r - 1, c, rMax, cMax);
    }
  }

  private void recurSimple(char[][] grid, boolean[][] isVisited, int r, int c, int rMax, int cMax) {
    if (r < rMax && c < cMax && r >= 0 && c >= 0 && !isVisited[r][c] && grid[r][c] == '1') {
      isVisited[r][c] = true;
      recur(grid, isVisited, r, c + 1, rMax, cMax);
      recur(grid, isVisited, r, c - 1, rMax, cMax);
      recur(grid, isVisited, r + 1, c, rMax, cMax);
      recur(grid, isVisited, r - 1, c, rMax, cMax);
    }
  }
}
