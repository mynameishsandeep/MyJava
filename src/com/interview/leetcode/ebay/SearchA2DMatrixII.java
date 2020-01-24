package com.interview.leetcode.ebay;

/*
https://leetcode.com/problems/search-a-2d-matrix/


Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.

Input:
matrix = [
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
target = 3
Output: true

============Note================
1) We are not doing any binary search. It is a simple move about any direction
=======Note on Solution1=====
1) Start search from top right corner.
2) If mid > target decrement col. Ex:15>10
3) Else increment row.

=======Note on Solution2=====
1) Start search from bottom left corner.
2) If mid > target decrement row. Ex:15>10
3) Else increment col.

 */
public class SearchA2DMatrixII {

  public boolean searchMatrixSolution1(int[][] matrix, int target) {
    if (matrix.length == 0 || matrix[0].length == 0) return false;
    return search(0, matrix[0].length - 1, matrix, target);
  }

  public boolean search(int row, int col, int[][] matrix, int target) {
    if (row < 0 || row == matrix.length || col < 0 || col == matrix[0].length) return false;
    int mid = matrix[row][col];
    if (mid == target) return true;
    if (mid > target) return search(row, col - 1, matrix, target);
    return search(row + 1, col, matrix, target);
  }

  public boolean searchMatrixSolution2(int[][] matrix, int target) {
    if (matrix.length == 0 || matrix[0].length == 0) return false;
    return search1(matrix.length - 1, 0, matrix, target);
  }

  public boolean search1(int row, int col, int[][] matrix, int target) {
    if (row < 0 || row == matrix.length || col < 0 || col == matrix[0].length) return false;
    int mid = matrix[row][col];
    if (mid == target) return true;
    if (mid > target) return search1(row - 1, col, matrix, target);
    return search1(row, col + 1, matrix, target);
  }
}
