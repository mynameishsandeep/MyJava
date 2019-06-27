package com.interview.leetcode.facebook.easy;

/*
 * https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/3011/
     1,2,3
     0,0,1
     
  1) Start from 1st value.
  2) if 1st value is not equal to 2nd value. Swap i and j. increment i.      
  3) So for 1,2,3,4,5... Number of swap is 4
  4) For 0,0,1.... 1 swap
 */
public class RemoveDuplicatesFromSortedArray {

  public int removeDuplicates(int[] nums) {
    int i = 1;
    for (int j = 1; j < nums.length; j++) {
      if (nums[j] != nums[j - 1]) {
        nums[i++] = nums[j];
      }
    }
    return i;
  }
}
