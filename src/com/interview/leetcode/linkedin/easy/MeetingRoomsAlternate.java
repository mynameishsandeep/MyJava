package com.interview.leetcode.linkedin.easy;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/meeting-rooms/description/
 *
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * determine if a person could attend all meetings.
 *
 * BruteForce:
 * The straight-forward solution is to compare every two meetings in the array,
 * and see if they conflict with each other (i.e. if they overlap).
 * Two meetings overlap if one of them starts while the other is still taking place.
 *
 * Optimum Approach:
 * 1) Sort intervals by start time.
 * 2) if, startTime of current is less than endTime of previous. Then false.
 *
 */
public class MeetingRoomsAlternate {
  /*
   * Time Complexity : O(N∗logN)
   */
  public boolean canAttendMeetings(int[][] intervals) {
    if (intervals.length == 0) return true;
    int[] start = new int[intervals.length];
    int[] end = new int[intervals.length];
    for (int i = 0; i < intervals.length; i++) {
      start[i] = intervals[i][0];
      end[i] = intervals[i][1];
    }
    Arrays.sort(start);
    Arrays.sort(end);
    for (int i = 1; i < intervals.length; i++) if (start[i] < end[i - 1]) return false;
    return true;
  }
}
