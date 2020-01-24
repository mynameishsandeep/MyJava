package com.interview.leetcode.facebook.medium;

import java.util.Arrays;

/*
* https://leetcode.com/problems/meeting-rooms-ii/description/
*
* http://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
*
==Logical Answer =====================
1) Sort all the data by clubbing both startTime and endTime.
2) Iterate sorted data.
3) If data is startTime add +1.
4) If data is endTime add -1.
5) This will work without duplicate.
6) If there is duplicate in startTime/endTime. endTime has to appear before startTime.
===========Solution Approach ==============
0) Separate startTime and endTime in array.
1) Sort startTime and endTime
2) Compare startTime and endTime.
3) if startTime is lesser, increase count.
4) if endTime is lesser, decrease count.
5) if both are same, decrease count.
6) Max of count in step 3,4,5 would be minMeetingRequired.
===================Ex: With Duplicate startTime/endTime===================================
Input = [[0, 30],[5, 10],[15, 20],[5,8],[0,5]
  startTime      endTime
	0      			5
	0      			8
	5      			10
	5      			20
	15     			30

	0 -> 1
	0 -> 2
	5 -> 1 (picked from endTime)
	5 -> 2
	5 -> 3
	8 -> 2
	10 -> 1
	15 -> 2
	20 -> 1
	30 -> 0


==============================================================
*/
public class MeetingRoomsIIBestApproach {
  public int minMeetingRooms(int[][] intervals) {
    int n = intervals.length;
    int[] startTime = new int[n], endTime = new int[n];
    for (int i = 0; i < n; i++) {
      startTime[i] = intervals[i][0];
      endTime[i] = intervals[i][1];
    }
    Arrays.sort(startTime);
    Arrays.sort(endTime);
    int startIndex = 0, endIndex = 0;
    int count = 0, minMeetingRoom = 0;
    while (startIndex < n || endIndex < n) {
      if (startIndex < n && endIndex < n) {
        if (endTime[endIndex] <= startTime[startIndex]) {
          count--;
          endIndex++;
        } else {
          count++;
          startIndex++;
        }
      } else if (startIndex < n) {
        count++;
        startIndex++;
      } else {
        count--;
        endIndex++;
      }
      minMeetingRoom = Math.max(count, minMeetingRoom);
    }
    return minMeetingRoom;
  }
}
