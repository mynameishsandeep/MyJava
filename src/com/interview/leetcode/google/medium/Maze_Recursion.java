package com.interview.leetcode.google.medium;

/*
* https://leetcode.com/problems/the-maze/description/

* 1) Navigate from start position.
* 2) From that point traverse left to right till blocked or cannot move further.
* 3) From that point traverse right to left till blocked or cannot move further.
* 4) From that point traverse top to bottom till blocked or cannot move further.
* 5) From that point traverse bottom to top till blocked or cannot move further.
* 6) Mark Visited node to true whenever navigation is finished for a position.
*
*/
public class Maze_Recursion {
  private boolean found = false;

  public boolean hasPath(int[][] maze, int[] start, int[] destination) {
    boolean visited[][] = new boolean[maze.length][maze[0].length];
    hasPath(maze, start, destination, visited);
    return found;
  }

  public void hasPath(int[][] maze, int[] start, int[] destination, boolean visited[][]) {
    int row = start[0];
    int col = start[1];
    if (destination[0] == row && destination[1] == col) {
      found = true;
      return;
    }
    if (!visited[row][col]) {
      visited[row][col] = true;

      int maxMoveLeftToRight = moveLeftToRight(maze, row, col);
      hasPath(maze, new int[] {row, maxMoveLeftToRight}, destination, visited);

      int maxMovableRightToLeft = moveRightToLeft(maze, row, col);
      hasPath(maze, new int[] {row, maxMovableRightToLeft}, destination, visited);

      int maxMovableTopToBottom = moveTopToBottom(maze, row, col);
      hasPath(maze, new int[] {maxMovableTopToBottom, col}, destination, visited);

      int maxMovableBottomToTop = moveBottomToTop(maze, row, col);
      hasPath(maze, new int[] {maxMovableBottomToTop, col}, destination, visited);
    }
  }

  private int moveLeftToRight(int[][] maze, int i, int j) {
    if (j + 1 > (maze[0].length - 1)) { // Verify the Boundary on Left To Right
      return j;
    }
    if (maze[i][j + 1] == 0) {
      return moveLeftToRight(maze, i, j + 1);
    }
    return j;
  }

  private int moveRightToLeft(int[][] maze, int i, int j) {
    if (j - 1 < 0) { // Verify the Boundary on Right To Left
      return j;
    }
    if (maze[i][j - 1] == 0) {
      return moveRightToLeft(maze, i, j - 1);
    }
    return j;
  }

  private int moveTopToBottom(int[][] maze, int i, int j) {
    if (i + 1 > maze.length - 1) { // Verify the Boundary on Top To Bottom
      return i;
    }
    if (maze[i + 1][j] == 0) {
      return moveTopToBottom(maze, i + 1, j);
    }
    return i;
  }

  private int moveBottomToTop(int[][] maze, int i, int j) {
    if (i - 1 < 0) { // Verify the Boundary on Bottom To Top
      return i;
    }
    if (maze[i - 1][j] == 0) {
      return moveBottomToTop(maze, i - 1, j);
    }
    return i;
  }
}
