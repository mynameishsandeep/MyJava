package com.interview.leetcode.linkedin.medium;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/#
 *
 *=== Point to Note======
 *1) On each row, where to start the comparism is the problem.
 *2) To solve that keep a map and store row, column in that...
 *3) If the column max reached for that row, remove that entry in map...So that, the row will not be processed.
 *
 */
public class KthSmallestElementInASortedMatrix_Simple {

  public int kthSmallest(int[][] matrix, int k) {
    int maxCol = matrix[0].length;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < matrix.length; i++) {
      map.put(i, 0);
    }
    int colToIncrement = -1;
    int rowToIncrement = -1;
    for (int i = 0; i < k; i++) {
      int min = Integer.MAX_VALUE;
      for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        int currentVal = matrix[entry.getKey()][entry.getValue()];
        if (min > currentVal) {
          min = currentVal;
          rowToIncrement = entry.getKey();
          colToIncrement = entry.getValue();
        }
      }
      if (i == k - 1) {
        return matrix[rowToIncrement][colToIncrement];
      } else if (colToIncrement == maxCol - 1) { // Row reached max column
        map.remove(rowToIncrement);
      } else {
        map.put(rowToIncrement, colToIncrement + 1);
      }
    }
    return 0;
  }
}
