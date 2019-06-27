package com.interview.leetcode.facebook.medium;

import java.util.HashSet;
import java.util.Set;

/*
 https://leetcode.com/problems/continuous-subarray-sum/description/

 1) Iterate through the input array exactly once,
 2) Keep track of the running sum mod k of the elements in the process.
 3) If we find "currentRunningMod" previously seen before then desired sum found.

[6,6,7] - k=6 - true
[6,7,6] - K=6 - false
[0,0] - K=0 - true
[23,2,6,4,7] - K=0 - false
[2,5,4,1] - k=6 - true
[2,5,4,2] - k=6 - true
 */
public class ContinuousSubarraySum {
  public boolean checkSubarraySum(int[] nums, int k) {
    Set<Integer> set = new HashSet<>();
    int previousRunningMod = 0;
    for (int num : nums) {
      int currentRunningMod = k == 0 ? (previousRunningMod + num) : (previousRunningMod + num) % k;
      if (set.contains(currentRunningMod)) {
        return true;
      }
      set.add(previousRunningMod);
      previousRunningMod = currentRunningMod;
    }
    return false;
  }

  public static void main(String[] args) {
    ContinuousSubarraySum c = new ContinuousSubarraySum();
    System.out.println(c.checkSubarraySum(new int[] {23, 2, 4, 6, 7}, 6));
    System.out.println(c.checkSubarraySum(new int[] {2, 4}, 6));
  }
}
