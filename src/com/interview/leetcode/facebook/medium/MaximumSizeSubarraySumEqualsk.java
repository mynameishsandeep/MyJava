package com.interview.leetcode.facebook.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
/*

https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/

The core idea is, as you go on calculating sum by adding each value to global sum,
check whether sum-k is already present. And in order to keep track of sum-k, I have simply maintained a HashMap.

Few tricks:

If sum-k is already present in the hashmap then don't modify it. This is because we want longest subarray.
Since array starts from 0 hence I have put (0, -1) before starting the calculation.
For example if I find sum = k at index 3, then sum-k = 0 which is already present
in the hashmap with entry (0, -1). Then the answer would be current
index(which is 3) - index of sum-k(which is -1) = 3 - (-1) = 4.
So the base entry is just because arrays starts from 0.
 */
public class MaximumSizeSubarraySumEqualsk {
  public int maxSubArrayLen(int[] nums, int k) {
    Map<Integer, Integer> map =
        new LinkedHashMap<>(); // store prefix sum -> its corresponding index

    map.put(0, -1);

    int sum = 0, max = 0;
    for (int i = 0; i < nums.length; ++i) {
      sum += nums[i];
      if (map.containsKey(sum - k)) {
        max = Math.max(max, i - map.get(sum - k));
      }
      if (!map.containsKey(sum)) {
        map.put(sum, i);
      }
      System.out.println(map);
    }
    return max;
  }

  /* There are two cases that sub-array sum equals to k.
   * 1) sum[J] - sum[I] = k, len = J - I.
   * 2) sum[J] = k, len = J + 1 */

  public int maxSubArrayLenSolution2(int[] nums, int k) {
    int[] sum = new int[nums.length];
    Map<Integer, Integer> targetToIndex = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      if (i == 0) sum[i] = nums[i];
      else sum[i] = nums[i] + sum[i - 1];
      int target = sum[i] + k;
      if (!targetToIndex.containsKey(target)) targetToIndex.put(target, i);
    }
    System.out.println(Arrays.toString(sum));
    System.out.println(Arrays.toString(nums));
    int len = 0;

    for (int i = 0; i < nums.length; i++) {
      if (sum[i] == k) {
        len = Math.max(len, i + 1);
      } else if (targetToIndex.containsKey(sum[i])) {
        len = Math.max(len, i - targetToIndex.get(sum[i]));
      }
    }
    return len;
  }
}
