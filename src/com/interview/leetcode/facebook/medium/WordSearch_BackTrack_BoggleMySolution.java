package com.interview.leetcode.facebook.medium;

/*

https://leetcode.com/problems/word-search/description/

1) For each character search recursively in all 4 directions
===========isVisited does 2 tricks========
2) to avoid forming circle in search.
3) BackTracking
===================Key DP point=====
don't reset isVisited in loop. Ex:, from left to right... if a node isVisited is true and result not found. 
Then revisiting in loop again, is still false.  
=============

=======Note: IsVisited will be set to true before and set to false after...==========
[["C","A","A"],
 ["A","A","A"],
 ["B","C","D"]]
"AAB":  True
 *
 */
public class WordSearch_BackTrack_BoggleMySolution {
  public boolean exist(char[][] board, String word) {
    boolean[][] isVisited = new boolean[board.length][board[0].length];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (word.charAt(0) == board[i][j]
            && recur(board, board.length, board[0].length, i, j, word, 0, isVisited)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean recur(
      char[][] board,
      int maxRow,
      int maxCol,
      int row,
      int col,
      String word,
      int index,
      boolean[][] isVisited) {

    if (index == word.length() - 1) {
      return true;
    }
    isVisited[row][col] = true;
    if (col + 1 < maxCol
        && word.charAt(index + 1) == board[row][col + 1]
        && !isVisited[row][col + 1]) { // able to Move Right
      if (recur(board, maxRow, maxCol, row, col + 1, word, index + 1, isVisited)) {
        return true;
      }
    }
    if (row + 1 < maxRow
        && word.charAt(index + 1) == board[row + 1][col]
        && !isVisited[row + 1][col]) { // able to Move Bottom
      if (recur(board, maxRow, maxCol, row + 1, col, word, index + 1, isVisited)) {
        return true;
      }
    }
    if (col - 1 >= 0
        && word.charAt(index + 1) == board[row][col - 1]
        && !isVisited[row][col - 1]) { // able to Move Left
      if (recur(board, maxRow, maxCol, row, col - 1, word, index + 1, isVisited)) {
        return true;
      }
    }
    if (row - 1 >= 0
        && word.charAt(index + 1) == board[row - 1][col]
        && !isVisited[row - 1][col]) { // able to Move Top
      if (recur(board, maxRow, maxCol, row - 1, col, word, index + 1, isVisited)) {
        return true;
      }
    }
    isVisited[row][col] = false;

    return false;
  }
}
