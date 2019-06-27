package com.interview.leetcode.google.easy;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/description/
 * ======Requirements======
 * 1) Split the numbers into equal groups.
 * 2) a group should have same number.
 * ===============
 * ========Solution=====
 * 1) Put all the unique elements as "key" with its count "count" into map.
 * 2) We can ignore key.
 * 3) Take the values, which is count. 
 * 4) If GCD of count is greater than 1 then it is true. 
 */
public class XOfAKindInADeckOfCards_GCD {

	public boolean hasGroupsSizeX(int[] deck) {
		Map<Integer, Integer> count = new HashMap<>();
		int res = 0;
		for (int i : deck) {
			count.put(i, count.getOrDefault(i, 0) + 1);
		}
		for (int i : count.values()) {
			res = gcd(i, res);
		}
		return res > 1;
	}

	int gcd(int a, int b) {
		System.out.println("a: " + a + " b: " + b);
		if (a == 0) {
			return b;
		}
		return gcd(b % a, a);
	}

	public static void main(String[] args) {
		XOfAKindInADeckOfCards_GCD x = new XOfAKindInADeckOfCards_GCD();
		System.out.println(x.hasGroupsSizeX(new int[] { 1, 1, 1, 1, 1, 1, 0, 0, 0 }));

	}
}
