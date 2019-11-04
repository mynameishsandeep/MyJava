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
Elements are sorted all the way. So treat it as one long array.

 */
public class SearchA2DMatrix {

  public boolean searchMatrix(int[][] matrix, int target) {
    int rowMax = matrix.length;
    int colMax = matrix[0].length;
    if (rowMax == 0 || colMax == 0) return false;
    return binSearch(0, rowMax * colMax - 1, colMax, matrix, target);
  }

  public boolean binSearch(int low, int high, int colMax, int[][] matrix, int target) {
    if (low <= high) {
      int mid = low + (high - low) / 2;
      int midValue = matrix[mid / colMax][mid % colMax];
      if (midValue == target) {
        return true;
      } else if (midValue < target) {
        return binSearch(mid + 1, high, colMax, matrix, target);
      } else {
        return binSearch(low, mid - 1, colMax, matrix, target);
      }
    }
    return false;
  }
}
