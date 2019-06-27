package com.interview.leetcode.uber.medium;

import java.util.Random;

/*
 * https://leetcode.com/problems/random-pick-index/description/
 * 
 * =====Solution 1=========================
 * Ex: 1,2,4,4,4
 * If a number exists 3 times then probability of picking is:  1st time is 1. 2nd time is 1/2, 3rd time is 1/3
 * 
 * EveryTime code looks 0, but set result as current index. 
 *   
 * 1st time Random can generate only 0. So 1st time possibility of 0 coming is 1 probability. 
 * 2nd time Random can generate 0 or 1. So 2nd time possibility of 0 coming is 1/2 probability. 
 * 3rd time Random can generate 0,1 or 2. So 3rd time possibility of 0 coming is 1/3 probability.
 * 
 * Note: Random generates number for 0. So for 1. it will be 0 always. for 2 ->0,1. for 3-> 0,1,2 
========Solution 2=======UnComment line at 46 and 48==============
 * 
 * EveryTime code looks for count, but set result as current index.
 * 
 * 1st time Random can generate only 1. So 1st time possibility of 1 coming is 1 probability. 
 * 2nd time Random can generate 1 or 2. So 2nd time possibility of 2 coming is 1/2 probability. 
 * 3rd time Random can generate 1,2 or 3. So 3rd time possibility of 3 coming is 1/3 probability.
 * 
 * 
 * ===================================
 * Similar to the problem "LinkedListRandomNode"
 * This is also called "Reservoir Sampling solution"
 */
public class RandomPickIndex {
	int[] nums;
	Random random;

	public RandomPickIndex(int[] nums) {
		this.nums = nums;
		this.random = new Random();
	}

	public int pick(int target) {
		int result = -1;
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				int randomPick = random.nextInt(++count); // random.nextInt(++count) + 1;
				System.out.println(randomPick);
				if (randomPick == 0) { // randomPick == count
					result = i;
				}
			}

		}
		return result;
	}
}
