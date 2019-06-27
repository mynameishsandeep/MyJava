package com.interview.leetcode.uber.medium;

import java.util.Random;
import java.util.TreeMap;

/*
 * https://leetcode.com/problems/random-pick-with-weight/description/
 * 
[1,2,3]->{1:0, 3:1, 6:2}

Say if rnd=4, it should return 2, because ceiling(4)=6 in our map, whose corresponding index is 2.

Random Number Generated is 1 higher order key is 3 and result is 1
Random Number Generated is 4 higher order key is 6 and result is 2
Random Number Generated is 0 higher order key is 1 and result is 0
 * 
 */
public class RandomPickWithWeight {
	int cnt = 0;
	TreeMap<Integer, Integer> map = new TreeMap<>();
	Random rnd = new Random();

	public RandomPickWithWeight(int[] w) {
		for (int idx = 0; idx < w.length; idx++) {
			cnt += w[idx];
			map.put(cnt, idx);
		}
	}

	public int pickIndex() {
		int random = rnd.nextInt(cnt);
		int key = map.higherKey(random);
		System.out.println("Random Number Generated is " + random + " higher order key is " + key + " and result is "
				+ map.get(key));
		return map.get(key);
	}
}
