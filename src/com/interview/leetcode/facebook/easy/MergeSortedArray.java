package com.interview.leetcode.facebook.easy;

/*
 * https://leetcode.com/problems/merge-sorted-array/
 *
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n)
 * to hold additional elements from nums2.
 *====================================================
 * 1) Key to the solution in compare and fill element from last. Thats it.
 * =================================
 */
public class MergeSortedArray {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int last = m + n - 1; // To access last index of nums1 directly.
    m = m - 1; // To access index directly. Reduce by 1
    n = n - 1; // To access index directly. Reduce by 1
    while (m != -1 && n != -1) {
      if (nums1[m] > nums2[n]) nums1[last--] = nums1[m--];
      else nums1[last--] = nums2[n--];
    }
    while (n > -1) {
      nums1[last--] = nums2[n--];
    }
  }
}
