package com.sample.tricky;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/merge-intervals/discuss/

/*
 * 1) Sort the intervals by start time.
 * 2) Cache previousStart and previousEnd.
 * 3) Verify if overlap occurs. If overlap, update previousEnd.
 * 								Else save previous to result. and update current to previous
 * ========================Note:===========
 * 1) in the overlap method, u don't need to compare the previous start...
 * Because it will be always equal or greater than current start, since intervals
 * are sorted. So u can directly compare previous end with current start.
 *
 * 2) finally add the last previous after the loop.
 * 3) We dont know the number of result, so save result in arraylist and convert to int[] and send back
 *==================================
 * [1,4] [2,3] ==> Ans: 1,4
 * [1,2] [2 3] ==> Ans: 1,3
 * ==================================
 */
public class MergeIntervals {

  /*
   * Time Complexity : O(NlogN) --> Because of sorting. It should be N+O(NlogN)
   * Spae Complexity : O(N)
   */
  public int[][] merge(int[][] intervals) {
    if (intervals == null || intervals.length <= 1) return intervals;
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    int previousStart = intervals[0][0];
    int previousEnd = intervals[0][1];
    List<int[]> tempResult = new ArrayList<>();
    for (int i = 1; i < intervals.length; i++) {
      int currentStart = intervals[i][0];
      int currentEnd = intervals[i][1];
      if (previousEnd >= currentStart) previousEnd = Math.max(previousEnd, currentEnd); // Merge
      else { // Update Result
        tempResult.add(new int[] {previousStart, previousEnd});
        previousStart = currentStart;
        previousEnd = currentEnd;
      }
    }
    tempResult.add(new int[] {previousStart, previousEnd});
    int[][] result = new int[tempResult.size()][2];
    for (int i = 0; i < tempResult.size(); i++) {
      result[i] = tempResult.get(i);
    }
    return result;
  }
}
