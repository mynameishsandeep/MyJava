package com.interview.leetcode.linkedin.medium;

/*
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/#
 *
 * Key point is elements are sorted horizontally and vertically. So we can use binary search.
 *
 * https://www.educative.io/collection/page/5668639101419520/5671464854355968/4605334997958656
 *
 */
public class KthSmallestElementInASortedMatrixBestSolution {

  public int kthSmallest(int[][] matrix, int k) {
    int n = matrix.length;
    int start = matrix[0][0], end = matrix[n - 1][n - 1];
    while (start < end) {
      int mid = start + (end - start) / 2;
      // first number is the smallest and the second number is the largest
      int[] smallLargePair = {matrix[0][0], matrix[n - 1][n - 1]};
      int count = countLessEqual(matrix, mid, smallLargePair);
      if (count == k) return smallLargePair[0];
      if (count < k) start = smallLargePair[1]; // search higher
      else end = smallLargePair[0]; // search lower
    }

    return start;
  }
  
  /*
  [
    [2, 6, 7], 
    [3, 8, 10],
    [5, 9, 11]
  ]
  
  
   * Count logic starts from last row to 0. Because, we can skip that row, if start element of that row is bigger than mid.
   * Also at any point, if a column is small or equal to mid in that row, then all previous row till that col,
   * will be smaller or equal for sure.
   * So count += row + 1;
   * 
   * Ex: If mid element is 8.
   * Then for 5. count= 0+2+1 =3
   * Then for 9. reduce row. which will move to [1,1] i.e 8
   * Then for 8. count = 3+1+1 = 5;
   * Then for 10. reduce row. which will move to [0,2] i.e 7
   * Then for 8. count = 5+0+1 = 6;
   */
  private static int countLessEqual(int[][] matrix, int mid, int[] smallLargePair) {
    int count = 0;
    int n = matrix.length, row = n - 1, col = 0;
    while (row >= 0 && col < n) {
      if (matrix[row][col] > mid) {
        // as matrix[row][col] is bigger than the mid, let's keep track of the
        // smallest number greater than the mid
        smallLargePair[1] = Math.min(smallLargePair[1], matrix[row][col]);
        row--;
      } else {
        // as matrix[row][col] is greater than or equal to the mid, let's keep track of the
        // biggest number less than or equal to the mid
        smallLargePair[0] = Math.max(smallLargePair[0], matrix[row][col]);
        count += row + 1;
        col++;
      }
    }
    return count;
  }
}
