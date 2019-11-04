package com.sample.datastructure.recursion;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/
 *
 * 1) We use an array isVisited[] to record which element in nums[] is used for grouping the sum.
 * 2) Each time when we get a currentSum = target, we start again from position 0 in nums[] for unvisited elements.
 *
There are 3 base condition at point
1) currentSum==target ---> result found.
2) currentSum>target ---> return
3) currentSum < target ---> in loop for unvisited element call partition.

Input:  [4, 3, 2, 3, 5, 2, 1], k = 4, sum=20, target=5
4th match found --> isVisisted = [true, false, false, false, false, false, true]
3rd match found --> isVisisted = [true, true, true, false, false, false, true]
2nd match found --> isVisisted = [true, true, true, true, false, true, true]

 */
public class PartitionToKEqualSumSubsetsBackTrack {
  public boolean canPartitionKSubsets(int[] nums, int k) {
    int sum = Arrays.stream(nums).sum();
    if (k <= 0 || sum % k != 0) return false;
    canPartition(nums, new boolean[nums.length], 0, k, 0, sum / k);
    return result;
  }

  private boolean result = false;

  private void canPartition(
      int[] nums, boolean[] isVisited, int startIndex, int k, int currentSum, int target) {
    if (result || currentSum > target) return;
    // When k-1 combo, remaining 1 combo has to match. so checking for k==1 rather than k==0
    if (k == 1) result = true;
    else if (currentSum == target) canPartition(nums, isVisited, 0, k - 1, 0, target);
    else { // if (currentSum < target) {
      for (int i = startIndex; i < nums.length; i++) {
        if (!isVisited[i]) {
          isVisited[i] = true;
          canPartition(nums, isVisited, i + 1, k, currentSum + nums[i], target);
          isVisited[i] = false;
        }
      }
    }
  }

  public static void main(String[] args) {
    PartitionToKEqualSumSubsetsBackTrack p = new PartitionToKEqualSumSubsetsBackTrack();
    int[] input = new int[] {4, 3, 2, 3, 5, 2, 1};
    p.canPartitionKSubsets(input, 4);
  }
}
