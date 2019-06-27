package com.interview.leetcode.amazon.easy;

/*
 * https://leetcode.com/problems/missing-number/
 */
public class MissingNumber {
  public int missingNumber(int[] nums) { // xor
    int xor = 0, i = 0;
    for (i = 0; i < nums.length; i++) {
      xor = xor ^ i ^ nums[i]; // Note: xor for 3 variable and not xor = xor ^ nums[i]
    }
    return xor ^ i;
  }

  public int missingNumber1(int[] nums) { // sum
    int len = nums.length;
    int sum = len * (len + 1) / 2;
    for (int i = 0; i < len; i++) sum -= nums[i];
    return sum;
  }
}
