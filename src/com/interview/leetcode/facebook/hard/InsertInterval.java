package com.interview.leetcode.facebook.hard;

import java.util.ArrayList;
import java.util.List;

/*
*
* https://leetcode.com/problems/insert-interval/
*
*=====
*If the given list was not sorted, we could have simply appended the new interval to it and
* used the code "MergeIntervals.java". But since the given list is sorted, 
* we should try to come up with a solution better than O(N * logN)O(N∗logN)
* ===== Solution O(N)====
1) Skip all intervals which end before the start of the new interval, i.e., skip all intervals with the following condition:
    intervals[i].end < newInterval.start
Let’s call the last interval ‘b’ that does not satisfy the above condition. If ‘b’ overlaps with the new interval (a) (i.e. b.start <= a.end), we need to merge them into a new interval ‘c’:
    c.start = min(a.start, b.start)
    c.end = max(a.end, b.end)
    c.start = min(a.start, b.start)
    c.end = max(a.end, b.end)
*
*
 [10,20][30,40]
 [20,30]

 [10,20][30,40]
 [20,26]

 [10,20][30,40]
 [25,26]

 [[1,2],[3,5],[6,7],[8,10],[12,16]]
 [4,8]

*/
public class InsertInterval {

  public int[][] insert(int[][] intervals, int[] newInterval) {

    if (intervals.length == 0) {
      return new int[][] {{newInterval[0], newInterval[1]}};
    }
    List<int[]> result = new ArrayList<>();
    int newIntervalStart = newInterval[0];
    int newIntervalEnd = newInterval[1];

    int i = 0, start = 0, end = 0;
    while (i < intervals.length) {
      start = intervals[i][0];
      end = intervals[i][1];
      if (end < newIntervalStart) {
        result.add(intervals[i]);
        i++;
      } else {
        break;
      }
    }

    while (newIntervalStart >= start && newIntervalStart <= end
        || start >= newIntervalStart && start <= newIntervalEnd) {
      newIntervalStart = Math.min(start, newIntervalStart);
      newIntervalEnd = Math.max(end, newIntervalEnd);
      i++;
      if (i == intervals.length) {
        break;
      }
      start = intervals[i][0];
      end = intervals[i][1];
    }
    result.add(new int[] {newIntervalStart, newIntervalEnd});

    while (i < intervals.length) {
      result.add(intervals[i++]);
    }
    int[][] resultArray = new int[result.size()][2];

    for (int j = 0; j < result.size(); j++) {
      resultArray[j] = result.get(j);
    }
    return resultArray;
  }
}
