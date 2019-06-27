package com.interview.leetcode.linkedin.medium;

/*
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * =========Note the corner cases==========
 * 1) If the element is not found. Still there will be some index returned.
 * Ex: [5,7,7,8,8,10] target=6  --> index returned. [1,0]
 * So check for element at index == target.
 * 2) Low can cross the array size.
 * Ex: [2,2] target=3 --> index returned. [2,1]
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
  public int[] searchRange(int[] nums, int target) {
    if (nums.length > 0) {
      int lowIndex = binarySearchGetLower(0, nums.length - 1, nums, target);
      int highIndex = binarySearchGetHigher(0, nums.length - 1, nums, target);
      if (lowIndex < nums.length && nums[lowIndex] == target)
        return new int[] {lowIndex, highIndex};
    }
    return new int[] {-1, -1};
  }

  public int binarySearchGetLower(int low, int high, int[] nums, int target) {
    if (low <= high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] == target) {
        return binarySearchGetLower(low, mid - 1, nums, target);
      } else if (nums[mid] > target) {
        return binarySearchGetLower(low, mid - 1, nums, target);
      } else {
        return binarySearchGetLower(mid + 1, high, nums, target);
      }
    }
    return low;
  }

  public int binarySearchGetHigher(int low, int high, int[] nums, int target) {
    if (low <= high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] == target) {
        return binarySearchGetHigher(mid + 1, high, nums, target);
      } else if (nums[mid] > target) {
        return binarySearchGetHigher(low, mid - 1, nums, target);
      } else {
        return binarySearchGetHigher(mid + 1, high, nums, target);
      }
    }
    return high;
  }
}
