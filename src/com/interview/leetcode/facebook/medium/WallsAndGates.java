package com.interview.leetcode.facebook.medium;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://leetcode.com/problems/walls-and-gates/
 * 
 * Question: Fill the matrix from 0.
 * 
 * 1) -1 is obstacle, 0 is source, INF is walk-through
 * 2) better readable solution is use queue. push each direction to queue, if able to pass through
 * 3) Iterate till queue empty.
 */
public class WallsAndGates {

  public void wallsAndGates(int[][] rooms) {
    if (rooms.length == 0) return;
    int mR = rooms.length;
    int mC = rooms[0].length;
    for (int i = 0; i < mR; i++) {
      for (int j = 0; j < mC; j++) {
        if (rooms[i][j] == 0) {
          recur(rooms, i, j, mR, mC, new boolean[mR][mC]);
        }
      }
    }
  }

  private void recur(int[][] rooms, int row, int col, int mR, int mC, boolean[][] isVisited) {

    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[] {row, col});
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        int[] rowCol = q.poll();
        row = rowCol[0];
        col = rowCol[1];
        int current = rooms[row][col] + 1;
        if (!isVisited[row][col]) {
          isVisited[row][col] = true;

          // leftToRight
          if (col + 1 < mC && rooms[row][col + 1] != -1 && rooms[row][col + 1] != 0) {
            if (rooms[row][col + 1] == Integer.MAX_VALUE) {
              rooms[row][col + 1] = current;
            } else {
              rooms[row][col + 1] = Math.min(rooms[row][col + 1], current);
            }
            q.offer(new int[] {row, col + 1});
          }
          // rightToLeft
          if (col - 1 >= 0 && rooms[row][col - 1] != -1 && rooms[row][col - 1] != 0) {
            if (rooms[row][col - 1] == Integer.MAX_VALUE) {
              rooms[row][col - 1] = current;
            } else {
              rooms[row][col - 1] = Math.min(rooms[row][col - 1], current);
            }
            q.offer(new int[] {row, col - 1});
          }
          // TopToBottom
          if (row + 1 < mR && rooms[row + 1][col] != -1 && rooms[row + 1][col] != 0) {
            if (rooms[row + 1][col] == Integer.MAX_VALUE) {
              rooms[row + 1][col] = current;
            } else {
              rooms[row + 1][col] = Math.min(rooms[row + 1][col], current);
            }
            q.offer(new int[] {row + 1, col});
          }
          // BottomToTop
          if (row - 1 >= 0 && rooms[row - 1][col] != -1 && rooms[row - 1][col] != 0) {
            if (rooms[row - 1][col] == Integer.MAX_VALUE) {
              rooms[row - 1][col] = current;
            } else {
              // System.out.println("row " + row + " col " + col+  " " +current);
              rooms[row - 1][col] = Math.min(rooms[row - 1][col], current);
            }
            q.offer(new int[] {row - 1, col});
          }
        }
      }
    }
  }
}
