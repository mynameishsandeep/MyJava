package com.interview.leetcode.facebook.easy;

/*
* https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/3011/
    1,2,3
    0,0,1
 =======Note===================
	Comparism happens on nums[right]and nums[right-1]
 ==============================
 1) Start from 1st value.
 2) if 1st value is not equal to 2nd value. Swap i and j. increment i.
 3) So for 1,2,3,4,5... Number of swap is 4
 4) For 0,0,1.... 1 swap
*/
public class RemoveDuplicatesFromSortedArray {

  public int removeDuplicates(int[] nums) {
    int left = 1;
    int right = 1;
    while (right < nums.length) {
      if (nums[right] == nums[right - 1]) {
        right++;
      } else {
        nums[left] = nums[right];
        left++;
        right++;
      }
    }
    return left;
  }
}
