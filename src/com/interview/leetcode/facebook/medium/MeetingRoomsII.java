package com.interview.leetcode.facebook.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
* https://leetcode.com/problems/meeting-rooms-ii/description/
*
* http://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
*
* 1) Push the startTime and EndTime into map.
* 2) Identify startTime by true and endTime by false.
* 3) Conflict can occur, so use list as value and key as interval
* 4) If there is conflict , endTime should be at top.Ex.. if you find 4 in start
* time and 4 in end time... put end time 4 first and start time 4 after that.
* So sort during collection of answer.

*/
public class MeetingRoomsII {
  public int minMeetingRooms(int[][] intervals) {
    Map<Integer, List<Boolean>> map = new TreeMap<>();
    for (int i = 0; i < intervals.length; i++) {
      map.put(intervals[i][0], new ArrayList<>());
      map.put(intervals[i][1], new ArrayList<>());
    }
    for (int i = 0; i < intervals.length; i++) {
      map.get(intervals[i][0]).add(true);
      map.get(intervals[i][1]).add(false);
    }
    int result = 0;
    int minMeetingRoom = 0;
    for (Map.Entry<Integer, List<Boolean>> entry : map.entrySet()) {
      List<Boolean> values = entry.getValue();
      Collections.sort(values);
      for (Boolean value : values) {
        if (value) {
          result++;
        } else {
          result--;
        }
        minMeetingRoom = Math.max(result, minMeetingRoom);
      }
    }
    return minMeetingRoom;
  }
}
