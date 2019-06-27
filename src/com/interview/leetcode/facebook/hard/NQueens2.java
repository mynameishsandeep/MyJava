package com.interview.leetcode.facebook.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * https://leetcode.com/problems/n-queens/
 *
 * 1) A valid move is possible, if no queen present horizontally, vertically and diagonally
 *					a      d
 *					 b	 c
 *					   x
 *					 e   f
 *                  g     h
 *
 * Diagonal check is tricky. For the above, for the col value "x".
 * we can only check for diagonal point "a b" and "c d".
 * Because we are coming from top to bottom, so bottom check is not needed.i.e (efgh)
 *
 */
public class NQueens2 {

  List<Integer[]> result = new ArrayList<>();

  public List<List<String>> solveNQueens(int n) {
    recur(0, 0, n, new Integer[n], new boolean[n], new boolean[n], new boolean[n][n]);
    List<List<String>> finalResult = new ArrayList<>();
    for (Integer[] res : result) {
      List<String> r = new ArrayList<>();
      for (Integer rr : res) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
          if (i == rr) {
            sb.append("Q");
          } else {
            sb.append(".");
          }
        }
        r.add(sb.toString());
      }
      finalResult.add(r);
    }
    return finalResult;
  }

  private boolean recur(
      int row,
      int col,
      int n,
      Integer[] tempResult,
      boolean horizontalFlag[],
      boolean verticalFlag[],
      boolean diagonalFlag[][]) {
    if (row == n) {
      Integer copied[] = Arrays.copyOf(tempResult, n);
      result.add(copied);
      return false;
    }
    if (col == n) return false;
    if (isValidMove(row, col, horizontalFlag, verticalFlag, diagonalFlag)) {
      diagonalFlag[row][col] = true;
      horizontalFlag[row] = true;
      verticalFlag[col] = true;
      tempResult[row] = col;
      // increase row
      if (!recur(row + 1, 0, n, tempResult, horizontalFlag, verticalFlag, diagonalFlag)) {
        diagonalFlag[row][col] = false;
        horizontalFlag[row] = false;
        verticalFlag[col] = false;
      }
    }
    // increase col
    return recur(row, col + 1, n, tempResult, horizontalFlag, verticalFlag, diagonalFlag);
  }

  private boolean isValidMove(
      int row, int col, boolean horizontalFlag[], boolean verticalFlag[], boolean isVisited[][]) {
    if (horizontalFlag[row]) return false;
    if (verticalFlag[col]) return false;
    for (int i = row, j = col, k = col; i >= 0; i--, j--, k++) {
      if (j >= 0 && isVisited[i][j]) {
        return false;
      }
      if (k < isVisited.length && isVisited[i][k]) {
        return false;
      }
    }
    return true;
  }
}
