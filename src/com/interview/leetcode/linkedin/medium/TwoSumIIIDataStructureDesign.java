package com.interview.leetcode.linkedin.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum-iii-data-structure-design/description/
 * 
 * ===Note1:=====
 * catch here is to handle duplicate value. 
 * Ex: 5,6,6,6,10 --> target 12..
 * At anytime, I can ignore duplicate more than 2 times. Because for TwoSum, atmost I can use only 2 value.
 * Use the map and record duplicate by true.
 * ======If the interviewer says no duplicate, then set is enough=====
 * * ===Note2:=====
 * Ex: 5,6 --> target 12. At iteration 2... 12-6=6 which map already and used once. 
 * so check for num1!=num2
 * if num1==num2, then 6 should be present twice
 	
 * 	
 */
public class TwoSumIIIDataStructureDesign {

	Map<Integer, Boolean> map;

	public TwoSumIIIDataStructureDesign() {
		map = new HashMap<>();
	}

	/*
	 * Record duplicate by setting true in value
	 */
	public void add(int number) {
		if (map.containsKey(number)) {
			map.put(number, true);
		} else {
			map.put(number, false);
		}

	}

	public boolean find(int target) {
		if (map.size() == 1 && !map.entrySet().iterator().next().getValue()) {
			return false;
		}
		for (Map.Entry<Integer, Boolean> mapEntry : map.entrySet()) {
			int num1 = mapEntry.getKey();
			int num2 = target - num1;
			if (map.containsKey(num2)) {
				if (num2 != num1) { //[5,6] target=12... At iteration 2... 12-6=6 which map already and used once.
					return true;
				} else if (mapEntry.getValue()) { // If 6 occurred twice then true;
					return true;
				}
			}
		}
		return false;
	}
}
