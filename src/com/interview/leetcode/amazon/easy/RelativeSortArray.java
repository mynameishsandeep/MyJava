package com.interview.leetcode.amazon.easy;

/*
 * https://leetcode.com/problems/relative-sort-array/
 * 		0) datas can in arr1 can be from 0 to 1000.
        1) So cache the arr1 from 0 to 1000 in array with count
        2) from arr2 value, go index at cache and get index, add that many into result.
        Reduce the count.
        3) For the left-overs come from 0 to 1000 and add it to result.

*/
public class RelativeSortArray {
  public int[] relativeSortArray(int[] arr1, int[] arr2) {

    int[] result = new int[arr1.length];
    int[] cache = new int[1001];
    for (int data : arr1) cache[data] += 1;
    int resIndex = 0;
    for (int data : arr2) {
      int count = cache[data];
      while (count-- > 0) result[resIndex++] = data;
      cache[data] = 0;
    }
    for (int i = 0; i <= 1000; i++) {
      int count = cache[i];
      while (count-- > 0) result[resIndex++] = i;
    }
    return result;
  }
}
