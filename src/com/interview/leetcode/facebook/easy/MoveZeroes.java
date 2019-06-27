package com.interview.leetcode.facebook.easy;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/move-zeroes/
 *
Input: [0,1,0,3,12]
Output: [1,3,12,0,0]

 * 1) Traverse the given array from left to right.
 * 2) While traversing, maintain count of non-zero elements in array.
 * 3) Let the count be ‘i’. For every "non-zero" element arr[j],
 * overwrite the element with ‘arr[i]’ and increment ‘i’.
 * 4) After complete traversal, all non-zero elements have already been shifted to front.
 * 5) ‘count’ will be at index of first 0.  Now run a loop from ‘count’ till end of the array and set values to 0.
 */
public class MoveZeroes {
  public static void moveZeroes(int[] nums) {
    int i = 0;
    for (int j = 0; j < nums.length; j++) {
      if (0 != nums[j]) {
        nums[i++] = nums[j];
      }
    }
    System.out.println(Arrays.toString(nums));
    for (int k = i; k < nums.length; k++) {
      nums[k] = 0;
    }
  }

  public static void main(String[] args) {
    int input[] = {0, 1, 0, 3, 12};
    moveZeroes(input);
    System.out.println(Arrays.toString(input));
  }
}
