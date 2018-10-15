package com.interview.leetcode.linkedin.easy;

/*
 * https://leetcode.com/problems/can-place-flowers/solution/
 * 
Suppose you have a long flowerbed in which some of the plots are planted and some are not. 
However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.
Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), 
and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.

===Note:  I can plant only if current column is 0, previous column is 0 and next column is 0.=========

 */
public class CanPlaceFlowers {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		for (int i = 0; i < flowerbed.length; i++) {
			if (flowerbed[i] == 1) {
				continue;
			} else if (flowerbed[i] == 0) {
				// I can plant only if current column is 0, previous column is 0 and next column is 0.
				if (isPreviousColumnOfFlowerBedIsZero(flowerbed, i) && isNextColumnOfFlowerBedIsZero(flowerbed, i)) {
					flowerbed[i] = 1; // Plant on the flowerbed
					n--; // Reduce the count of plant to be flowerbed
				}
			}
		}
		return n <= 0;
	}

	private boolean isPreviousColumnOfFlowerBedIsZero(int[] flowerbed, int currentColumn) {
		if (currentColumn == 0) { // For 0th column, nothing to check before
			return true;
		}
		return flowerbed[currentColumn - 1] == 0;

	}

	private boolean isNextColumnOfFlowerBedIsZero(int[] flowerbed, int currentColumn) {
		if (currentColumn == flowerbed.length - 1) { // For n-th column, nothing to check after 
			return true;
		}
		return flowerbed[currentColumn + 1] == 0;
	}

}
