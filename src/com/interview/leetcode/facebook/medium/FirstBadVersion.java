package com.interview.leetcode.facebook.medium;

/*
 * https://leetcode.com/problems/first-bad-version/
 *
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
 * which causes all the following ones to be bad.
 *
 * ============Solution===============
 * In a binary search find first duplicate.
 * ========================
 */
public class FirstBadVersion {
  public int firstBadVersion(int n) {
    return binSearch(1, n);
  }

  private int binSearch(int low, int high) {
    if (low <= high) {
      int mid = low + (high - low) / 2;
      boolean bad = isBadVersion(mid);
      if (bad) return binSearch(low, mid - 1);
      return binSearch(mid + 1, high);
    }
    return low;
  }

  boolean isBadVersion(int version) {
    return true;
  }
}
