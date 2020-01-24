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
* 0) Separate startTime and endTime in array.  
* 1) Sort startTime and endTime 
* 2) Iterate. Skip the first startTime, because there is no condition for it.
* 2) if, startTime of current is less than endTime of previous. Then false.

	Input: [[0,30],[5,10],[15,20]] Output: false
		startTime 	endTime
			0		   10
			5		   20
			15         30


*/
public class MeetingRooms {

  /*
   * Time Complexity : O(N∗logN)
   */
  public boolean canAttendMeetings(int[][] intervals) {
    int n = intervals.length;
    int[] startTime = new int[n], endTime = new int[n];
    for (int i = 0; i < n; i++) {
      startTime[i] = intervals[i][0];
      endTime[i] = intervals[i][1];
    }
    Arrays.sort(startTime);
    Arrays.sort(endTime);
    for (int i = 1; i < n; i++) if (startTime[i] < endTime[i - 1]) return false;
    return true;
  }
}
