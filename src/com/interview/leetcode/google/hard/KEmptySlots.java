package com.interview.leetcode.google.hard;

import java.util.TreeSet;

/*
 * https://leetcode.com/problems/k-empty-slots/description/
 * 
 * To understand the problem description read below
 * https://stackoverflow.com/questions/46393470/find-earliest-time-for-k-empty-group
 *  see picture "resources/K-Empty-Slots.png" and "resources/K-Empty-Slots1.png"
 * 
 * 
 * Solution: Insert Into Sorted Structure
 * 1) Whenever adding a new value, I need to a) get value higher than the current value
 * 											 b) get value lower than the current value.
 * 2) If the difference of higher-current or current-lower is equal to K. Then result found return the current day. 
 */
public class KEmptySlots {
	public int kEmptySlots(int[] flowers, int k) {
		TreeSet<Integer> flowerSlot = new TreeSet<>();
		int day = 0;
		for (int flowerAtCurrentIndex : flowers) {
			day++;
			flowerSlot.add(flowerAtCurrentIndex);
			Integer flowerAtLowerIndex = flowerSlot.lower(flowerAtCurrentIndex);
			Integer flowerAtHigherIndex = flowerSlot.higher(flowerAtCurrentIndex);
			if (flowerAtLowerIndex != null && flowerAtCurrentIndex - flowerAtLowerIndex - 1 == k
					|| flowerAtHigherIndex != null && flowerAtHigherIndex - flowerAtCurrentIndex - 1 == k)
				return day;
		}
		return -1;
	}

	public static void main(String[] args) {
		KEmptySlots k = new KEmptySlots();
		System.out.println(k.kEmptySlots(new int[] { 5, 3, 2 }, 1));
		/*
		 * 0 0 0 0 1 ---> higher = null and lower = null
		 * 0 0 1 0 1 ---> higher = 5 and lower = null (5-3-1=1) // Result Found
		 * 			  	  Result Found for Day2 (Right To Left), no need to traverse 3rd day
		 */
		System.out.println(k.kEmptySlots(new int[] { 2, 5, 1, 4, 3 }, 2));
		/*
		 * 0 1 0 0 0 ---> higher = null and lower = null
		 * 0 1 0 0 1 ---> higher = null and lower = 2 (5-2-1 = 2) // Result Found
		 * 				  Result Found for Day2 ( Left To Right), no need to traverse 3rd day
		 */
		System.out.println(k.kEmptySlots(new int[] { 1, 4, 3, 5, 2 }, 1));
		/*
		 * 1 0 0 0 0 ---> higher = null and lower = null
		 * 1 0 0 1 0 ---> higher = null and lower = 1 (4-1-1 = 2) // Result Not Found. Because 1!=2
		 * 1 0 1 1 0 ---> higher = 4 and lower = 1 --> 3-1-1=1. Result Found. Or Condition will not execute(Left to Right is 4-3-1=0) 
		 *  --- Result Found for Day2 (Right To Left), no need to traverse 4th day
		 */

	}
}
