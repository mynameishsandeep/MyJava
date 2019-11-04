package com.interview.leetcode.linkedin.hard;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/paint-house-ii/description/
 *
 * In PaintHouse, number of row(color) is fixed and number of house is not fixed. Here m color and n houses both are not fixed.

Read PaintHouse.java.

 The brute-force way of doing above logic is
 For a single column, iterate all previous column (skipping current column) and get min.
 This will make nSquare operation for each column of row. To avoid that min1 and min2 is calculated by iterating once for each row.

1) Only different logic from PaintHouse is,
 Need to get minimum from previous row, skipping current column of previous row.
 To do that Keeping min1 and min2 so that it covers minimum of all the column.
  Ex :
  1 2 3
  4 5 6 -->  from previous row, min1 is 1 and min2 is 2

  So when doing calculation,
  1 is skipped for 4 and 2 is used
  2 is skipped for 5 and 1 is used
  1 is again used for 6 because index not matched.

Ex: for a 2 row data.
1) Fill first row with priorityQueue. Take top2 which is min1 and min2
2) For Each column in row2. Do Below
3) if min1 index is currentIndex, then min is min2 else min is min1.
 *
 */
public class PaintHouseII {
  int[] min1, min2 = null;

  public int minCostII(int[][] costs) {
    if (costs.length == 0) return 0;
    for (int i = 1; i < costs.length; i++) {
      fillMin1Min2FromPreviousRow(costs[i - 1]);
      for (int j = 0; j < costs[0].length; j++) {
        costs[i][j] += min1[1] == j ? min2[0] : min1[0];
      }
    }
    return Arrays.stream(costs[costs.length - 1]).min().getAsInt();
  }

  private void fillMin1Min2FromPreviousRow(int[] cost) {
    PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    for (int i = 0; i < cost.length; i++) pQ.offer(new int[] {cost[i], i});
    min1 = pQ.poll();
    min2 = pQ.poll();
  }
}
