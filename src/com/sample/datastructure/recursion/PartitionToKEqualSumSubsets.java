package com.sample.datastructure.recursion;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/
 * 
 * Like the groupsum, this sum doesn't need the right(sending current number alone without reducing by current number).
 * Because all input has to be in some group. 
 * 
 * 1) We use an array visited[] to record which element in nums[] is used for grouping sum. 
 * 2) Each time when we get a currentSum = target(sum/k), we start again from position 0 in nums[] for unvisited elements.
 * 3) 
 * 
There are 3 base condition at point 
1) currentSum==target
2) currentSum>target
3) currentSum < target.. in loop for unvisited element call partition.

Input:  4, 3, 2, 3, 5, 2, 1
4 match found [true, false, false, false, false, false, true] (4 @Index0 and 1 @Index5 )
3 match found [true, true, true, false, false, false, true] (3@Index1 and 2@Index2)
2 match found [true, true, true, true, false, true, true](3@Index3 and 2@Index4)

 */
public class PartitionToKEqualSumSubsets {
	public static void main(String[] args) {
		PartitionToKEqualSumSubsets p = new PartitionToKEqualSumSubsets();
		int input[] = new int[] { 4, 3, 2, 3, 5, 2, 1 };
		p.canPartitionKSubsets(input, 4);
	}

	public boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		if (k <= 0 || sum % k != 0) {
			return false;
		}
		boolean[] visited = new boolean[nums.length];
		return canPartition(nums, visited, 0, k, 0, sum / k);
	}

	public boolean canPartition(int[] nums, boolean[] visited, int startIndex, int k, int currentSum, int target) {
		if (k == 1) {// When k-1 combo, remaining 1 combo has to match. so checking for k==1 rather than k==0
			return true;
		} else if (currentSum == target) {
			System.out.println(k + " match found " + Arrays.toString(visited));
			return canPartition(nums, visited, 0, k - 1, 0, target);
		} else if (currentSum > target) {
			System.out.println(Arrays.toString(visited));
			return false;
		} else {// currentSum < target
			System.out.println(Arrays.toString(visited));
			for (int i = startIndex; i < nums.length; i++) { // if index reaches max array size return false.
				if (!visited[i]) {
					visited[i] = true;
					if (canPartition(nums, visited, i + 1, k, currentSum + nums[i], target)) {
						return true;
					} else {// this will roll back and set all visited to false. For making multiple combination
						visited[i] = false;
					}
				}
			}
			return false;
		}
	}
}
