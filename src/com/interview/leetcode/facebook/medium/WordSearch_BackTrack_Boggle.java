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
public class WordSearch_BackTrack_Boggle {
  public boolean exist(char[][] board, String word) {
    boolean[][] isVisited = new boolean[board.length][board[0].length];
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[0].length; col++) {
        if (backTrack(board, row, col, word, 0, isVisited)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean backTrack(
      char[][] board, int row, int col, String word, int index, boolean[][] isVisited) {
    if (index == word.length()) {
      return true;
    }
    if (row < board.length
        && row >= 0
        && col < board[0].length
        && col >= 0
        && !isVisited[row][col]
        && board[row][col] == word.charAt(index)) {
      isVisited[row][col] = true;
      if (backTrack(board, row + 1, col, word, index + 1, isVisited)
          || backTrack(board, row - 1, col, word, index + 1, isVisited)
          || backTrack(board, row, col + 1, word, index + 1, isVisited)
          || backTrack(board, row, col - 1, word, index + 1, isVisited)) {
        return true;
      }
      isVisited[row][col] = false;
    }
    return false;
  }

  public static void main(String[] args) {
    WordSearch_BackTrack_Boggle w = new WordSearch_BackTrack_Boggle();
    char input[][] = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
    System.out.println(w.exist(input, "ABCCED"));
    System.out.println(w.exist(input, "ABCB"));
    System.out.println(w.exist(input, "SEE"));
  }
}
