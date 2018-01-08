package com.sample.tricky;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//https://leetcode.com/problems/merge-intervals/discuss/
/**
 * 1) Sort the intervals by start time.
 * 2) Compare overlaps with current and next. If no overlap add to result.
 * 3) Else do overlap logic. 
 */
public class MergeIntervals {

	public List<Interval> merge(List<Interval> intervals) {
		Collections.sort(intervals, new IntervalComparator());
		List<Interval> result = new ArrayList<>();
		Interval temp = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			if (isOverlap(temp, intervals.get(i))) {
			} else {
				result.add(temp);
				temp = intervals.get(i);
			}
		}
		result.add(temp);
		return result;
	}

	private boolean isOverlap(Interval a, Interval b) {
		if (a.end>b.start) {
			if (b.end > a.end) {
				a.end = b.end;
			}
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		//[[1,3],[2,6],[8,10],[15,18]]

		Interval i1 = new Interval(1,3);
		Interval i4 = new Interval(15,18);
		Interval i2 = new Interval(2,6);
		Interval i3 = new Interval(8,10);
		List<Interval> l = new ArrayList<>(Arrays.asList(i1,i2,i3,i4));
		List<Interval> result = new MergeIntervals().merge(l);
		for(Interval i : result) {
			System.out.println(i.start + " " + i.end);
		}
	}

}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}


class IntervalComparator implements Comparator<Interval> {
	@Override
	public int compare(Interval a, Interval b) {
		return a.start - b.start;
	}
}