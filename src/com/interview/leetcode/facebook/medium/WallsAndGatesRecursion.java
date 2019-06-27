package com.interview.leetcode.facebook.medium;

/*
 * https://leetcode.com/problems/walls-and-gates/
 *
 *1) For a point, if the previous distance is less than current distance. 
 *Then skip entire recursion for that point. 
 */
public class WallsAndGatesRecursion {

  public void wallsAndGates(int[][] rooms) {
    int r = rooms.length;
    int c = r > 0 ? rooms[0].length : 0;
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (rooms[i][j] == 0) expand(rooms, i, j, 0);
      }
    }
  }

  public void expand(int[][] rooms, int row, int col, int dist) {
    if (row < 0
        || row >= rooms.length
        || col < 0
        || col >= rooms[0].length
        || rooms[row][col] == -1) {
      return;
    }

    if (dist <= rooms[row][col]) { // If current distance less than previous then only do operation
      rooms[row][col] = dist;
      expand(rooms, row + 1, col, dist + 1);
      expand(rooms, row - 1, col, dist + 1);
      expand(rooms, row, col - 1, dist + 1);
      expand(rooms, row, col + 1, dist + 1);
    }
  }
}
