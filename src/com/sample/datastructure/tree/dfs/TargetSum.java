package com.sample.datastructure.tree.dfs;

/*
 * https://leetcode.com/problems/target-sum/description/
 *
 */
public class TargetSum {

  int count = 0;

  public int findTargetSumWays(int[] nums, int S) {
    int sum = 0;
    dfs(nums, 0, sum, S);
    return count;
  }

  public void dfs(int nums[], int start, int sum, int target) {
    if (start == nums.length) {
      if (sum == target) {
        count++;
      }
      return;
    }
    dfs(nums, start + 1, sum + nums[start], target);
    dfs(nums, start + 1, sum - nums[start], target);
  }
}
