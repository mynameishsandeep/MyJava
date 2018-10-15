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
		TreeSet<Integer> active = new TreeSet<>();
		int day = 0;
		for (int flower : flowers) {
			day++;
			active.add(flower);
			Integer lower = active.lower(flower);
			Integer higher = active.higher(flower);
			if (lower != null && flower - lower - 1 == k || higher != null && higher - flower - 1 == k)
				return day;
		}
		return -1;
	}

	public static void main(String[] args) {
		KEmptySlots k = new KEmptySlots();
		System.out.println(k.kEmptySlots(new int[] { 5, 3, 2 }, 1));
		/*
		 * 0 0 0 0 1
		 * 0 0 1 0 1 ---> Result Found for Day2 (Right To Left), no need to traverse 3rd day
		 */
		System.out.println(k.kEmptySlots(new int[] { 2, 5, 1, 4, 3 }, 2));
		/*
		 * 0 1 0 0 0
		 * 0 1 0 0 1 --- Result Found for Day2 ( Left To Right), no need to traverse 3rd day
		 */
		System.out.println(k.kEmptySlots(new int[] { 1, 4, 3, 5, 2 }, 1));
		/*
		 * 1 0 0 0 0
		 * 1 0 0 1 0 
		 * 1 0 1 1 0 --- Result Found for Day2 (Right To Left), no need to traverse 3rd day
		 */

	}
}
