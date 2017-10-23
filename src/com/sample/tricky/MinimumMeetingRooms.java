package com.sample.tricky;

import java.util.Map;
import java.util.TreeMap;
/*
 * This solution will work only if there is no duplicate in date
 * 
 * http://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
 */
public class MinimumMeetingRooms {

	public static int minMeetingRooms(Interval[] intervals) {
		// True is start, False is end
		Map<Integer, Boolean> interval = new TreeMap<>();
		for (int i = 0; i < intervals.length; i++) {
			interval.put(intervals[i].start, true);
			interval.put(intervals[i].end, false);
		}
		int count = 0;
		int max = 0;
		for (Map.Entry<Integer, Boolean> i : interval.entrySet()) {
			if (i.getValue()) {
				count++;
			} else {
				count--;
			}
			if (count > max) {
				max = count;
			}
		}
		return max;
	}

	public static void main(String[] args) {

		Interval i1 = new Interval(7, 10);
		Interval i2 = new Interval(2, 4);
		Interval i[] = new Interval[] { i1, i2 };
		System.out.println(minMeetingRooms(i));
	}

}
