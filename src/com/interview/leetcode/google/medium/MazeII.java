package com.interview.leetcode.google.medium;
/*
 * Upgraded from maze_recursion. but it is passing only 50% test cases
 */
public class MazeII {
  private int shortDistance = Integer.MAX_VALUE;

  public int shortestDistance(int[][] maze, int[] start, int[] destination) {
    boolean visited[][] = new boolean[maze.length][maze[0].length];
    hasPath(maze, start, destination, visited, 0, false, false, false, false, 0);
    return shortDistance == Integer.MAX_VALUE ? -1 : shortDistance;
  }

  public void hasPath(
      int[][] maze,
      int[] start,
      int[] destination,
      boolean visited[][],
      int count,
      boolean isLToR,
      boolean isRToL,
      boolean isTToB,
      boolean isBToT,
      int prev) {
    int row = start[0];
    int col = start[1];
    if (destination[0] == row && destination[1] == col) {
      shortDistance = Math.min(count, shortDistance);
      return;
    }
    if (!visited[row][col]) {
      visited[row][col] = true;
      if (isLToR) {
        count = count + col - prev;
      } else if (isRToL) {
        count = count + prev - col;
      } else if (isTToB) {
        count = count + row - prev;
      } else {
        count = count + prev - row;
      }
      int maxMoveLeftToRight = moveLeftToRight(maze, row, col);

      hasPath(
          maze,
          new int[] {row, maxMoveLeftToRight},
          destination,
          visited,
          count,
          true,
          false,
          false,
          false,
          col);

      int maxMovableRightToLeft = moveRightToLeft(maze, row, col);

      hasPath(
          maze,
          new int[] {row, maxMovableRightToLeft},
          destination,
          visited,
          count,
          false,
          true,
          false,
          false,
          col);

      int maxMovableTopToBottom = moveTopToBottom(maze, row, col);

      hasPath(
          maze,
          new int[] {maxMovableTopToBottom, col},
          destination,
          visited,
          count,
          false,
          false,
          true,
          false,
          row);

      int maxMovableBottomToTop = moveBottomToTop(maze, row, col);

      hasPath(
          maze,
          new int[] {maxMovableBottomToTop, col},
          destination,
          visited,
          count,
          false,
          false,
          false,
          true,
          row);
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
