package com.interview.leetcode.facebook.easy;

/*
 * https://leetcode.com/problems/range-sum-query-immutable/
 */
public class RangeSumQueryImmutable {
  private int dp[];

  public RangeSumQueryImmutable(int[] nums) {
    dp = new int[nums.length];
    for (int i = 1; i < nums.length; i++) {
      nums[i] = nums[i - 1] + nums[i];
    }
    dp = nums;
  }

  public int sumRange(int i, int j) {
    if (i == 0) return dp[j];
    return dp[j] - dp[i - 1];
  }
}
