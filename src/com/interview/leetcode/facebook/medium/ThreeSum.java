package com.interview.leetcode.facebook.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.com/problems/3sum

	 * Take a number. Do 2Sum for remaining number.
	 *
	 * Sorting takes O(log N)
	 * 2 loops in takes O(n^2)
	 * So we can say it takes O(n^2)
	 *
=================Implementation================
1) Sort the number
2) Pick a number in outer loop. i.e firstNumber(num[0])
3) Pick the secondNumber(num[1]) after the firstNumber and lastNumber(num[n-1]).
4) secondNumber index is left and lastNumber index is right.
5) For each number(firstNumber) picked in outerLoop. pick Second and Third Number.
6) If a result is found. Increment left and decrement right.
================How to Avoid Duplicate in 3 cases==========================
1) Avoid Outer Loop Duplicate ---> if (i > 0 && nums[i] == nums[i - 1]) continue;
Ex: [-1 -1 0 1]
	first output formed with -1 0 1. Then again -1 0 1

2) Avoid Left Duplicate ---> while (left < right && nums[left] == nums[left - 1]) left++;
Ex: [-2,0,0,2,2] --> result:[[-2,0,2]]
	first output formed with -2 0 2. from index 0 1 and 3 then avoid result from index 0 2 and 3.

3) Avoid Right Duplicate ---> while (left < right && nums[right] == nums[right + 1]) right--;
Ex: [-2,0,0,2,2] --> result:[[-2,0,2]]
	first output formed with -2 0 2. from index 0 1 and 3 then avoid result from index 0 2 and 3.
===================Advanced Thinking=======
As per data, avoiding either left or right duplicate is enough to pass all test case.
But adding both will reduce number of iteration.
==============
 */
public class ThreeSum {

  public List<List<Integer>> threeSumSimple(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      int firstNumber = nums[i];
      int left = i + 1, right = nums.length - 1;
      while (left < right) {
        int secondNumber = nums[left];
        int lastNumber = nums[right];
        if (firstNumber + secondNumber + lastNumber == 0) {
          result.add(Arrays.asList(firstNumber, secondNumber, lastNumber));
          left++;
          right--;
        } else if (firstNumber + secondNumber + lastNumber > 0) right--;
        else left++;
      }
    }
    return result;
  }
  // Code with Handling duplicate -- Outer duplicate /Left duplicate /Right duplicate
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      int firstNumber = nums[i];
      if (i > 0 && nums[i] == nums[i - 1]) continue;
      int left = i + 1, right = nums.length - 1;
      while (left < right) {
        int secondNumber = nums[left];
        int lastNumber = nums[right];
        if (firstNumber + secondNumber + lastNumber == 0) {
          result.add(Arrays.asList(firstNumber, secondNumber, lastNumber));
          left++;
          right--;
          while (left < right && nums[left] == nums[left - 1]) left++;

          while (left < right && nums[right] == nums[right + 1]) right--;

        } else if (firstNumber + secondNumber + lastNumber > 0) right--;
        else left++;
      }
    }
    return result;
  }
}
