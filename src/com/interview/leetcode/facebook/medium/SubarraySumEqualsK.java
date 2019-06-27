package com.interview.leetcode.facebook.medium;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

	public int subarraySum_BruteForce(int[] nums, int k) {
		int totalResultCount = 0;
		for (int i = 0; i < nums.length; i++) {
			int sum = nums[i];
			if (sum == k) {
				totalResultCount++;
			}
			for (int j = i + 1; j < nums.length; j++) {
				sum += nums[j];
				if (sum == k) {
					totalResultCount++;
				}
			}
		}
		return totalResultCount;
	}

	public int subarraySum(int[] nums, int k) {
		int count = 0, sum = 0;
		Map<Integer, Integer> preSumFreq = new HashMap<>();
		preSumFreq.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			count += preSumFreq.getOrDefault(sum - k, 0);
			preSumFreq.put(sum, preSumFreq.getOrDefault(sum, 0) + 1);
		}
		return count;
	}
}
