package com.sample.tricky;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * http://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
 * 
 * For duplicates arrange the end time at top... Ex.. if you find 4 in start
 * time and 4 in end time... put end time 4 first and start time 4 after that.
 *
 */
public class MinimumMeetingRoomsWithDuplicate {
	public static int minMeetingRooms(Interval[] intervals) {
		// True is start, False is end
		Map<Integer, List<Boolean>> interval = new TreeMap<>();
		for (int i = 0; i < intervals.length; i++) {
			List<Boolean> list = null;
			if ((list = interval.get(intervals[i].start)) == null) {
				interval.put(intervals[i].start, new ArrayList<Boolean>(Arrays.asList(true)));
			} else {
				list.add(true);
				interval.put(intervals[i].start, list);
			}

			if ((list = interval.get(intervals[i].end)) == null) {
				interval.put(intervals[i].end, new ArrayList<Boolean>(Arrays.asList(false)));
			} else {
				list.add(false);
				interval.put(intervals[i].end, list);
			}

		}
		int count = 0;
		int max = 0;
		for (Map.Entry<Integer, List<Boolean>> i : interval.entrySet()) {
			List<Boolean> li = i.getValue();
			Collections.sort(li);
			for (Boolean v : li) {
				if (v) {
					count++;
				} else {
					count--;
				}
				if (count > max) {
					max = count;
				}
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
