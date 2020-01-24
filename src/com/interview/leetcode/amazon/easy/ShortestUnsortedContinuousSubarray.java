package com.interview.leetcode.amazon.easy;

/*
* https://leetcode.com/problems/shortest-unsorted-continuous-subarray/

input = [1,3,2,2,2] Output = 4
input = [1,2,3,3,3] Output = 0


*/
public class ShortestUnsortedContinuousSubarray {
  public int findUnsortedSubarray(int[] nums) {
    if (nums.length == 0) return 0;
    int n = nums.length;
    int min = nums[nums.length - 1];
    for (int i = nums.length - 2; i >= 0; i--) {
      if (min < nums[i]) n = i;
      min = Math.min(min, nums[i]);
    }
    int e = -1;
    int max = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (max > nums[i]) {
        e = i;
      }
      max = Math.max(max, nums[i]);
    }
    return Math.max(0, e - n + 1);
  }
}
