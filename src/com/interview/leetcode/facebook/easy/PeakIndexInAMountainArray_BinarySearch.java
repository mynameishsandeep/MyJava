package com.interview.leetcode.facebook.easy;

/*
1) Result is not a number. It is index
2) Question is Peak index at any point. There can be many Peak index in actual mountain.
But the problem strictly says only one peak with no duplicate. So below case is not possible.
Ex:[0,1,2,3,0,3,4,6,0] For below one result can be 3(index) or 7.
Solution1: go by comparing current and next number.
Solution2: Binary Search. Instead of target==A[mid]..... check for A[mid]<A[mid+2]
============Data constraints=========See peakIndexInMountainArrayForLoop========
1) There will be answer all the time, so need of low<=high
2) Duplicate data is not possible.
========
Example:
Input: [24,69,100,99,79,78,67,36,26,19]
Output: 2

*/

public class PeakIndexInAMountainArray_BinarySearch {

  public int peakIndexInMountainArray(int[] A) {
    return binSearch(0, A.length - 1, A);
  }

  private int binSearch(final int low, final int high, final int[] arr) {
    int mid = low + (high - low) / 2;
    if (arr[mid - 1] < arr[mid] && arr[mid + 1] < arr[mid]) {
      return mid;
    } else if (arr[mid + 1] > arr[mid]) {
      return binSearch(mid + 1, high, arr);
    } else {
      return binSearch(low, mid - 1, arr);
    }
  }

  public int peakIndexInMountainArrayForLoop(int[] A) {
    for (int i = 0; i < A.length; i++) if (A[i + 1] < A[i]) return i;
    return 0;
  }
}
