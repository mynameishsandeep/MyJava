package com.interview.leetcode.facebook.medium;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

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
============================Solution Approach===================
1) This code uses Map<Integer, PriorityQueue<Boolean>> map = new TreeMap<>();.
2) Time Complexity is so difficult to say. Because of Map insert/get/search and Priority Queue insert/get/delete
* ===================Ex: Without Duplicate startTime/endTime===================================
	Input = [[0, 30],[5, 10],[15, 20]]

	0  --> true   Answer = 1
	5  --> true   Answer = 2
	10 --> false  Answer = 1
	15 --> true   Answer = 2 ----------> final Max answer
	20 --> false  Answer = 1
	30 --> false  Answer = 0
===================Ex: With Duplicate startTime/endTime===================================
Input = [[0, 30],[5, 10],[15, 20],[5,8],[0,5]

	 0=[true, true],        ==>  Answer = 2
	 5=[false, true, true], ==>  2-1+1+1 ==> Answer = 3
	 8=[false],
	 10=[false],
	 15=[true],
	 20=[false],
	 30=[false]
==============================================================
*/
public class MeetingRoomsII {
  public int minMeetingRooms(int[][] intervals) {
    Map<Integer, PriorityQueue<Boolean>> map = new TreeMap<>();
    for (int i = 0; i < intervals.length; i++) {
      map.put(intervals[i][0], new PriorityQueue<>());
      map.put(intervals[i][1], new PriorityQueue<>());
    }
    for (int i = 0; i < intervals.length; i++) {
      map.get(intervals[i][0]).add(true);
      map.get(intervals[i][1]).add(false);
    }
    int count = 0, minMeetingRoom = 0;
    for (PriorityQueue<Boolean> q : map.values()) {
      while (!q.isEmpty()) {
        if (q.poll()) count++;
        else count--;
        minMeetingRoom = Math.max(count, minMeetingRoom);
      }
    }
    return minMeetingRoom;
  }
}
