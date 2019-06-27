package com.interview.leetcode.facebook.medium;

/*
 * https://leetcode.com/problems/find-peak-element/

A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Note:
 * 1) At left end and right end values are -INF.
 * 2) Because of above property, there will be a answer at all time.
 * Ex:
 * 10, 20, 30 Ans: 2
 * 30, 20, 10 Ans: 0
 * [-2147483648] Ans: 0
 * [-1] Ans: 0
 *
 * =========Very very corner cases. There will be more than 1 answer========
 * [10,1,30,40,50,60,70,80,90] 
 * 2 answer here : 0 or 8
 *=============
Solution Approach:

1) Binary Search, goes finding a element at mid. If element not found, it decides going left side or right side.
2) Similarly. Find a mid element. Compare it will left side number and right side number.
2a) If middle number is greater than both side. Then it is answer.
2b) If middle number is less than left Number. Go Left. Else Go Right.


  
Ex: 10 20 30 40 50 60 70 80... middle number is 40.
With respect to 40 left side condition passed. So right side.
 *
 */
public class FindPeakElement {

  public int findPeakElement(int[] nums) {
    return binSearch(nums, 0, nums.length - 1);
  }

  private int binSearch(int[] nums, int low, int high) {
    if (low <= high) {
      int mid = low + (high - low) / 2;
      int previousElement = mid == 0 ? Integer.MIN_VALUE : nums[mid - 1];
      int nextElement = mid == nums.length - 1 ? Integer.MIN_VALUE : nums[mid + 1];
      int centerElement = nums[mid];
      if (centerElement > previousElement && centerElement > nextElement) return mid;
      else if (centerElement < previousElement) {
        return binSearch(nums, low, mid - 1);
      } else {
        return binSearch(nums, mid + 1, high);
      }
    }
    return 0;
  }
}
