package com.interview.leetcode.amazon.medium;

/*
 * https://leetcode.com/problems/game-of-life/
 *
 * In an matrix, for a point, calculate 8 directions count.
 * If the point is 0 and count==3 and point changed to 1.
 * If the point is 1 and count==2 or 3 then point remains 1 else 0.
 *
 *
 */
public class GameOfLife {

  class Solution {
    public void gameOfLife(int[][] board) {
      int r = board.length;
      int c = board[0].length;
      int[][] tempBoard = new int[r][c];
      for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
          int count = 0;
          if (i + 1 < r && board[i + 1][j] == 1) {
            count++;
          }
          if (i - 1 >= 0 && board[i - 1][j] == 1) {
            count++;
          }
          if (j + 1 < c && board[i][j + 1] == 1) {
            count++;
          }
          if (j - 1 >= 0 && board[i][j - 1] == 1) {
            count++;
          }
          if (i + 1 < r && j + 1 < c && board[i + 1][j + 1] == 1) {
            count++;
          }
          if (i + 1 < r && j - 1 >= 0 && board[i + 1][j - 1] == 1) {
            count++;
          }
          if (i - 1 >= 0 && j + 1 < c && board[i - 1][j + 1] == 1) {
            count++;
          }
          if (i - 1 >= 0 && j - 1 >= 0 && board[i - 1][j - 1] == 1) {
            count++;
          }
          if (board[i][j] == 1) {
            if (count == 2 || count == 3) tempBoard[i][j] = 1;
          } else {
            if (count == 3) tempBoard[i][j] = 1;
          }
        }
      }
      for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
          board[i][j] = tempBoard[i][j];
        }
      }
    }
  }
}
