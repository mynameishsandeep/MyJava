package com.interview.leetcode.linkedin.easy;

/*
https://leetcode.com/problems/search-a-2d-matrix/

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true

=======Note on Solution=====
1) Elements are sorted all the way. So treat it as one long array.
2) For 28 elements mid will be 14. Lets say 4 column in a row.
So we need to point 3rd row 2nd column which is done by [mid / colMax][mid % colMax]
14/4 = 3, 14%4=2


 */
public class SearchA2DMatrix {

  private int colMax;
  private int[][] matrix;

  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix.length == 0 || matrix[0].length == 0) return false;
    colMax = matrix[0].length;
    this.matrix = matrix;
    return binSearch(0, matrix.length * matrix[0].length - 1, target);
  }

  public boolean binSearch(int low, int high, int target) {
    if (low <= high) {
      int mid = low + (high - low) / 2;
      int midValue = matrix[mid / colMax][mid % colMax];
      if (midValue == target) return true;
      else if (midValue < target) return binSearch(mid + 1, high, target);
      else return binSearch(low, mid - 1, target);
    }
    return false;
  }
}
