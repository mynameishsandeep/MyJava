package com.sample.tricky;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/merge-intervals/discuss/

/*
 * 0) Separate startTime and endTime in array.
 * 1) Sort startTime and endTime
 * 2) Iterate. Skip the first startTime, because there is no condition for it.
 * 3) if, startTime of current is greater than endTime of previous. Then both are disjoint i.e 2 different or no joint needed.
 * ==================================
 */
public class MergeIntervalsBestApproach {

  /*
   * Time Complexity : O(NlogN) --> Because of sorting. It should be N+O(NlogN)
   * Space Complexity : O(N)
   */
  public int[][] merge(int[][] intervals) {
    int n = intervals.length;
    if (n == 0) return new int[][] {};
    int[] startT = new int[n];
    int[] endT = new int[n];
    for (int i = 0; i < n; i++) {
      startT[i] = intervals[i][0];
      endT[i] = intervals[i][1];
    }
    Arrays.sort(startT);
    Arrays.sort(endT);
    List<int[]> temp = new ArrayList<>();
    int start = 0;
    for (int i = 1; i < startT.length; i++) {
      if (startT[i] > endT[i - 1]) {
        // disjoint intervals
        temp.add(new int[] {startT[start], endT[i - 1]});
        start = i;
      }
    }
    // for the last row of data
    temp.add(new int[] {startT[start], endT[startT.length - 1]});
    int[][] result = new int[temp.size()][2];
    for (int i = 0; i < result.length; i++) {
      result[i] = temp.get(i);
    }

    return result;
  }
}
