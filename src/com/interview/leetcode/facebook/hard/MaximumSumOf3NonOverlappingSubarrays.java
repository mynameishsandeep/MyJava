package com.interview.leetcode.facebook.hard;

/*
 * https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/discuss/108231/C++Java-DP-with-explanation-O(n)?page=2
 */
public class MaximumSumOf3NonOverlappingSubarrays {
	public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
		int n = nums.length;
		int m = n - k + 1;
		int[] sum = new int[m];
		for (int i = 0; i < k; i++) {
			sum[0] += nums[i];
		}
		for (int i = 1; i < m; i++) {
			sum[i] = sum[i - 1] + nums[i + k - 1] - nums[i - 1];
		}
		int[] res = new int[] { 0, k, 2 * k - 1 };
		int[] temp = new int[] { 0, k, 2 * k - 1 };
		int max = Integer.MIN_VALUE;
		for (int middle = k; middle <= n - 2 * k; middle++) {
			temp[1] = middle;
			//update the left index (temp[0]) when the new left index.
			if (sum[temp[0]] < sum[middle - k])
				temp[0] = middle - k;
			//update the right index(temp[1]) when previous max index is not in the range.
			if (temp[2] < middle + k) {
				int tempR = Integer.MIN_VALUE;
				for (int right = middle + k; right < m; right++) {
					if (tempR < sum[right]) {
						tempR = sum[right];
						temp[2] = right;
					}
				}
			}
			if (max < sum[temp[0]] + sum[temp[1]] + sum[temp[2]]) {
				max = sum[temp[0]] + sum[temp[1]] + sum[temp[2]];
				res[0] = temp[0];
				res[1] = temp[1];
				res[2] = temp[2];
			}
		}
		return res;
	}
}
