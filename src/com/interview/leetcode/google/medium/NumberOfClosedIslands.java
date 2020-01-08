package com.interview.leetcode.google.medium;

/*
 * https://leetcode.com/problems/number-of-closed-islands/
 *
 * Find 0 surrounded by 1s (left, top, right, bottom).
 * =========Solution Approach==================================
 * 1) Do DFS only for 0's
 * 2) Inside the DFS.
 * 2a) If the row or column exceeds min/max limit return false.
 * 2b) DFS is called only for 0's from for loop.
 * But recursion itself may calls for 1. So to avoid infinite loop, return true if a point is 1.
 * 2c) Change 0 to 1 to mark it as "visited".
 * 2d) If all the direction returns true, then return true.
 */
public class NumberOfClosedIslands {
  public int closedIsland(int[][] grid) {
    int res = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 0) {
          if (dfs(i, j, grid)) res++;
        }
      }
    }

    return res;
  }

  public boolean dfs(int row, int col, int[][] grid) {
    if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) return false;
    if (grid[row][col] == 1) return true; // Tricky: This is to avoid recursion to go infinite.
    grid[row][col] = 1; // mark 0 as visited by changing it to 1.
    boolean up = dfs(row - 1, col, grid);
    boolean down = dfs(row + 1, col, grid);
    boolean left = dfs(row, col - 1, grid);
    boolean right = dfs(row, col + 1, grid);
    return up && down && left && right;
  }

  /*
   * If someone asks for don't change the source. Then change 0 to 2.
   * At the end again change 2 to 0.
   */
  public boolean dfs1(int x, int y, int[][] grid) {
    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return false;
    if (grid[x][y] == 1 || grid[x][y] == 2) return true; // Tricky: To avoid recursion infinite.
    grid[x][y] = 2; // mark 0 as visited by changing it to 2.
    boolean up = dfs(x - 1, y, grid);
    boolean down = dfs(x + 1, y, grid);
    boolean left = dfs(x, y - 1, grid);
    boolean right = dfs(x, y + 1, grid);
    return up && down && left && right;
  }
}
