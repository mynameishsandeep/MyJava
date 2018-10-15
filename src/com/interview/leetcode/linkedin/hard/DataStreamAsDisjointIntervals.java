package com.interview.leetcode.linkedin.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.interview.leetcode.Interval;
/*
 * https://leetcode.com/problems/data-stream-as-disjoint-intervals/description/
 * 
 * HighLevel Logic
 * 1) Save the value(input data) as key and Interval as value in map
 * 2) When the value exists already, just skip it.
 * 3) When the values lower or higher Interval is not null. 
 *   Do Logic to merge "currentValue to high", "high to currentValue"
 *   If the value lies between low and high skip it.
 *   If the value not exist in map, create a entry.
 *   
 * 
 * 1) a) If data lies between lowerKey and higherKey, 
 * 	  update lowerKey Interval.end with higherKey Interval.end. Note it is not higherKey itself. 
 *    Because Ex: Map has 2(2,5), 7(7,10) now input is 6. Result should be 2(2,10)
 *    b) Then remove higherKey 7(7,10)
 *    
 * 2) a) If data merges with lowerKey Ex:3(3,10) and val=5 or 3(3,10) and val=11
 * 	  b) If data lies between Interval.start and Interval.end then no change needed. 
 *    Else update Interval.end with current data
 * 
 * 3) a) If data merges with higheKey Ex: 3(3,10) and val=2. 
 * 	  Remove map entry 3 and create map entry 2(2,10)
 *  		
 * 4) If above 3 steps skips then create a new entry in map.
 * 
 *    =========When a merging point occurs we merge the data and keep lowest value as key===========
 */
public class DataStreamAsDisjointIntervals {
 
	TreeMap<Integer, Interval> tree;

	public DataStreamAsDisjointIntervals() {
		tree = new TreeMap<>();
	}

	public void addNum(int val) {
		if (tree.containsKey(val))
			return;
		Integer lowerKey = tree.lowerKey(val);
		Integer higherKey = tree.higherKey(val);
		Interval lowerInterval = null != lowerKey ? tree.get(lowerKey) : null;
		Interval higherInterval = null != higherKey ? tree.get(higherKey) : null;
		// Since lowerInterval holds group, lowerKey should higher of lower interval
		lowerKey = lowerInterval != null ? lowerInterval.end : null;

		// Data lies between lowerKey and higherKey Ex: lower =3(3,10) higher =12(12,20) and val =11
		if (lowerKey != null && higherKey != null && lowerKey + 1 == val && higherKey == val + 1) {
			lowerInterval.end = higherInterval.end;
			tree.remove(higherKey);
		} else if (lowerKey != null && lowerKey + 1 >= val) {//Ex: (3,3-10) and val=5...So need to compare >=
			if (val >= lowerInterval.start && val <= lowerInterval.end) {
				// don't do anything. Data lies between start and end
			} else { // (lowerKey + 1 == val) 
				lowerInterval.end = val;
			}
		} else if (higherKey != null && higherKey == val + 1) {
			tree.put(val, new Interval(val, higherInterval.end));
			tree.remove(higherKey);
		} else {// this works only during the first time when no data present in the map
			tree.put(val, new Interval(val, val));
		}
	}

	public List<Interval> getIntervals() {
		return new ArrayList<>(tree.values());
	}
}
