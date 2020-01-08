package com.interview.leetcode.ebay;

/*
 * https://leetcode.com/problems/partition-equal-subset-sum/description/
 *
 * Recursion approach will take more than 5 minutes if the input has 50+ elements
 *
 * ==========================Solution Note================================
 * Recursion Approach : Verify whether array can be split into 2 equal parts.
 * Simple approach using groupSum is...
 * If we able to get a result of sum/2 using groupsum. Then remaining number is remaining half of array.
 */
public class PartitionEqualSubsetSumRecursion {

  public boolean canPartition(int[] nums) {
    Integer sum = getSum(nums);
    if (sum % 2 == 1) return false;
    return groupSum(0, nums, sum / 2);
  }

  private int getSum(int[] nums) {
    int result = 0;
    for (int i = 0; i < nums.length; i++) result += nums[i];

    return result;
  }

  private boolean groupSum(Integer start, int[] nums, Integer target) {
    if (start == nums.length) return false;
    if (target == 0) return true;
    boolean left = groupSum(start + 1, nums, target - nums[start]);
    boolean right = groupSum(start + 1, nums, target);
    return left || right;
  }
}
