package com.interview.leetcode.linkedin.easy;

import java.util.Arrays;
import java.util.Comparator;

import com.leetcode.Interval;

/*
 * https://leetcode.com/problems/meeting-rooms/description/
 * 
 * BruteForce: 
 * The straight-forward solution is to compare every two meetings in the array, 
 * and see if they conflict with each other (i.e. if they overlap). 
 * Two meetings overlap if one of them starts while the other is still taking place.
 * 
 * Optimum Approach: Sort by start time.
 */
public class MeetingRooms {

	public boolean canAttendMeetings(Interval[] intervals) {
		Arrays.sort(intervals, new IntervalComparator());
		for (int i = 0; i < intervals.length - 1; i++) {
			if (overlap(intervals[i], intervals[i + 1])) {
				return false;
			}
		}
		return true;
	}

	private boolean overlap(Interval i1, Interval i2) {
		return i2.start < i1.end;
	}

	public class IntervalComparator implements Comparator<Interval> {
		public int compare(Interval i1, Interval i2) {
			return i1.start - i2.start;
		}
	}
}
