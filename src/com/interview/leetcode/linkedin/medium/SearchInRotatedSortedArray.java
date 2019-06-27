package com.interview.leetcode.linkedin.medium;

/*
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 *
 *https://www.educative.io/collection/page/5668639101419520/5671464854355968/5141325911425024
 *
 * 1) Find which side (Left or right side) is sorted.
 * 2) Then check target lies between the sorted side. If yes go towards that side or go opposite.
 *
 * ============
 * all the comparism should be <= and not <...... >= and not >. Otherwise result is not right
 */
public class SearchInRotatedSortedArray {
  public int search(int[] nums, int target) {
    return searchBinary(nums, target, 0, nums.length - 1);
  }

  public int searchBinary(int[] nums, int target, int low, int high) {
    if (low <= high) {
      int mid = low + ((high - low) / 2);
      if (nums[mid] == target) {
        return mid;
      } else if (nums[low] <= nums[mid]) { // Left Side Sorted.
        if (target >= nums[low] && target <= nums[mid]) { // Check target lies in left side
          return searchBinary(nums, target, low, mid - 1); // Yes target lies in left side. Go Left
        }
        return searchBinary(nums, target, mid + 1, high); // No target lies in right side. Go Right

      } else { // Right Side Sorted
        if (target >= nums[mid] && target <= nums[high]) { // Check target lies in right side
          return searchBinary(nums, target, mid + 1, high);
        }
        return searchBinary(nums, target, low, mid - 1);
      }
    }
    return -1;
  }
}
