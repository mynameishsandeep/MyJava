package com.interview.leetcode.ebay;

import java.util.ArrayList;
import java.util.List;

/*
 *
 * https://leetcode.com/problems/spiral-matrix/
 *
 * The above problem can be solved using four for loops which prints all the elements.
 * Every for loop defines a single direction movement along with the matrix.
 * The first for loop represents the movement from left to right, whereas the
 * second crawl represents the movement from top to bottom, the third represents
 * the movement from the right to left, and the fourth represents the movement from bottom to up.
 */
public class SpiralMatrix {
  public List<Integer> spiralOrder(int[][] matrix) {

    List<Integer> res = new ArrayList<>();

    if (matrix.length == 0) {
      return res;
    }

    int rowBegin = 0;
    int rowEnd = matrix.length - 1;
    int colBegin = 0;
    int colEnd = matrix[0].length - 1;

    while (rowBegin <= rowEnd && colBegin <= colEnd) {
      // Traverse Right
      for (int j = colBegin; j <= colEnd; j++) {
        res.add(matrix[rowBegin][j]);
      }
      rowBegin++;

      // Traverse Down
      for (int j = rowBegin; j <= rowEnd; j++) {
        res.add(matrix[j][colEnd]);
      }
      colEnd--;

      if (rowBegin <= rowEnd) {
        // Traverse Left
        for (int j = colEnd; j >= colBegin; j--) {
          res.add(matrix[rowEnd][j]);
        }
      }
      rowEnd--;

      if (colBegin <= colEnd) {
        // Traverse Up
        for (int j = rowEnd; j >= rowBegin; j--) {
          res.add(matrix[j][colBegin]);
        }
      }
      colBegin++;
    }

    return res;
  }
}
