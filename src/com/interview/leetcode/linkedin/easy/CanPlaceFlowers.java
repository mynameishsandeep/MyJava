package com.interview.leetcode.linkedin.easy;

/*
 * https://leetcode.com/problems/can-place-flowers/solution/
 */
public class CanPlaceFlowers {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		boolean found0 = false;
		for (int i = 0; i < flowerbed.length; i++) {
			if (i == 0 && flowerbed[i] == 0) {
				found0 = true;
			}
			if (flowerbed[i] == 1) {
				found0 = false;
				continue;
			} else if (flowerbed[i] == 0) {
				if (found0) {
					if (flowerbed.length > (i + 1)) {
						if (flowerbed[i + 1] == 0) {
							n--;
							found0 = false;
						}
					} else {
						found0 = false;
						n--;
					}
				} else {
					found0 = true;
				}
			}
		}
		return n <= 0;
	}
}
