package com.interview.leetcode.facebook.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.com/problems/3sum
 *
=== Corner Cases=======
Negative cases are important: It can occur at 2 places.
1) Outer loop Ex: [-1 -1 0 1]
	first output formed with -1 0 1. Then again -1 0 1

2) Inner Loop Ex: [-2,0,0,2,2]
	first output formed with -2 0 2. from index 0 1 and 4 then from index 0 2 and 3.
Fix for the Inner Loop is complicated, it should be in while loop and should happen after 1 time successful processing

=================
 input: [-2,0,0,2,2] --> result:[[-2,0,2]]

 */
public class ThreeSum {

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      int firstNumber = nums[i];
      if (i > 0 && nums[i] == nums[i - 1]) continue;
      for (int j = i + 1, k = nums.length - 1; j < k; ) {
        int secondNumber = nums[j];
        int lastNumber = nums[k];
        if (firstNumber + secondNumber + lastNumber == 0) {
          result.add(Arrays.asList(firstNumber, secondNumber, lastNumber));
          j++;
          k--;
          while (j < k && nums[j] == nums[j - 1] && nums[k] == nums[k + 1]) {
            j++;
            k--;
          }

        } else if (firstNumber + secondNumber + lastNumber > 0) {
          k--;
        } else {
          j++;
        }
      }
    }
    return result;
  }
}
