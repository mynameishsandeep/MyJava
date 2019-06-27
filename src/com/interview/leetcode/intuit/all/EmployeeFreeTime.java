package com.interview.leetcode.intuit.all;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.interview.leetcode.Interval;

/*
 * https://leetcode.com/problems/employee-free-time/description/
 */
public class EmployeeFreeTime {
	public List<Interval> employeeFreeTime(List<List<Interval>> avails) {
		List<Interval> result = new ArrayList<>();
		List<Interval> timeLine = new ArrayList<>();
		avails.forEach(listEntry -> timeLine.addAll(listEntry));
		Collections.sort(timeLine, ((interval1, interval2) -> interval1.start - interval2.start));

		Interval previous = timeLine.get(0);
		for (Interval current : timeLine) {
			System.out.println(current.start + " " + current.end);
			if (previous.end < current.start) {
				result.add(new Interval(previous.end, current.start));
				previous = current;
			} else {
				previous = previous.end < current.end ? current : previous;
			}
		}
		return result;

	}
}
