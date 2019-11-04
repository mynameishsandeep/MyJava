package com.interview.leetcode.ebay;

/*

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
Example:

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.
===============Solution Note=========
Look into the picture "SearchA2DMatrixII_BinSearch.jpg" in US Problems.

View the matrix as Tree from Top Right Corner. Thats it.
1) Start from Top Right Corner.
2) If midValue == target found answer.
3) If midValue > target.. Reduce column.
4) If midValue < target.. Increase row.
=============Time Complexity O(m+n)=======
1) Time Complexity might look like O(log n).
2) But in worst case Ex: [[1,2,3,4]]. Searching for 1 will take O(m+n)
====================


 */
public class SearchA2DMatrixII {
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix.length == 0 || matrix[0].length == 0) return false;
    return binSearch(0, matrix[0].length - 1, matrix, target);
  }

  public boolean binSearch(int row, int col, int[][] matrix, int target) {
    if (row < 0 || row == matrix.length || col < 0 || col == matrix[0].length) return false;
    int midValue = matrix[row][col];
    if (midValue == target) return true;
    else if (midValue > target) return binSearch(row, col - 1, matrix, target);
    else return binSearch(row + 1, col, matrix, target);
  }
}
