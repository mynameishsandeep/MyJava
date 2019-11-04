package com.interview.leetcode.google.medium;

import java.util.Arrays;

/* https://leetcode.com/problems/3sum-closest/
 * Assumption: You may assume that each input would have exactly one solution.
 *
	 * Take a number. Do 2Sum for remaining number.
	 * Update closest every-time.
	 *
	 * Sorting takes O(log N)
	 * 2 loops in takes O(n^2)
	 * So we can say it takes O(n^2)
	 *
=============
	Since there will be 1 output all the time. we can assign initial result with nums[0] + nums[1] + nums[2];
=================Implementation================
1) Sort the number
2) Pick a number in outer loop. i.e firstNumber(num[0])
3) Pick the secondNumber(num[1]) after the firstNumber and lastNumber(num[n-1]).
4) secondNumber index is left and lastNumber index is right.
5) For each number(firstNumber) picked in outerLoop. pick Second and Third Number.
6) If a result is found. Increment left and decrement right.

 */
public class ThreeSumClosest {
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int closest = nums[0] + nums[1] + nums[2];
    for (int i = 0; i < nums.length - 2; i++) {
      int firstNumber = nums[i];
      if (i > 0 && nums[i] == nums[i - 1]) continue;
      int left = i + 1, right = nums.length - 1;
      while (left < right) {
        int secondNumber = nums[left];
        int lastNumber = nums[right];
        int threeSum = firstNumber + secondNumber + lastNumber;
        if (threeSum == target) {
          return target;
        } else if (threeSum > target) {
          right--;
        } else {
          left++;
        }
        if (Math.abs(target - threeSum) < Math.abs(target - closest)) {
          closest = threeSum;
        }
      }
    }
    return closest;
  }
}
