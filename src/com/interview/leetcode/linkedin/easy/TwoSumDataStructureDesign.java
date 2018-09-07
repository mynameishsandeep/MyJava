package com.interview.leetcode.linkedin.easy;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/two-sum-iii-data-structure-design/description/
 * 
 * Note: 
 * 1) To Save the duplicate using Map with value as boolean. Because 1 duplicate or more duplicate all are same.
 * 2)  (value - mapKey), might result in mapKey itself, so watch out on if and else...
 */
public class TwoSumDataStructureDesign {

	Map<Integer, Boolean> map;

	/** Initialize your data structure here. */
	public TwoSumDataStructureDesign() {
		map = new HashMap<>();
	}

	/** Add the number to an internal data structure.. */
	public void add(int number) {
		if (map.containsKey(number)) {
			map.put(number, true);
		} else {
			map.put(number, false);
		}
	}

	/** Find if there exists any pair of numbers which sum is equal to the value. */
	public boolean find(int value) {
		for (Map.Entry<Integer, Boolean> mapEntry : map.entrySet()) {
			Integer mapKey = mapEntry.getKey();
			if ((value - mapKey != mapKey) && map.containsKey(value - mapKey)) {
				return true;
			} else if (mapKey == (value - mapKey)) {
				if (mapEntry.getValue()) {
					return true;
				}
			}
		}
		return false;
	}

}
