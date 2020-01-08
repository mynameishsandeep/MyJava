package com.interview.leetcode.facebook.easy;

import java.util.ArrayList;
import java.util.List;
/*
 * https://leetcode.com/problems/intersection-of-three-sorted-arrays/
Given three integer arrays arr1, arr2 and arr3 sorted in strictly increasing order,
return a sorted array of only the integers that appeared in all three arrays.
=========Example 1:================
Input: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
Output: [1,5]
Explanation: Only 1 and 5 appeared in the three arrays.

===========Solution Approach=================
	0) Keep 3 pointers.
    1) Check all for equal. if all are equal, move all pointer
    2) if all are not equal. move only lowest value pointer.
    3) Solution will work if "one pointer is moved" or "2 pointer is moved".
    Ex: a=9 b=9 c=10. both a and b can be moved. (method arraysIntersection)
    or "a" alone can be moved. then on next iteration "b" will be moved (method arraysIntersection2)
 */
public class IntersectionOfThreeSortedArrays {
  public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
    List<Integer> result = new ArrayList<>();
    for (int i = 0, j = 0, k = 0; i < arr1.length && j < arr2.length && k < arr3.length; ) {
      if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
        result.add(arr1[i]);
        i++;
        j++;
        k++;
      } else {
        int min = Math.min(Math.min(arr1[i], arr2[j]), arr3[k]);
        if (arr1[i] == min) i++;
        if (arr2[j] == min) j++;
        if (arr3[k] == min) k++;
      }
    }
    return result;
  }

  public List<Integer> arraysIntersection2(int[] arr1, int[] arr2, int[] arr3) {
    List<Integer> result = new ArrayList<>();
    for (int i = 0, j = 0, k = 0; i < arr1.length && j < arr2.length && k < arr3.length; ) {
      if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
        result.add(arr1[i]);
        i++;
        j++;
        k++;
      } else if (arr1[i] < arr2[j]) i++;
      else if (arr2[j] < arr3[k]) j++;
      else k++;
    }
    return result;
  }
}
