package com.interview.leetcode.amazon.easy;

import java.util.Arrays;
import java.util.TreeSet;
/*
 *  https://leetcode.com/problems/two-sum-less-than-k/
 *  k is target
 *  =============Solution 1============
 *  1) Sort the Array.
 *  2) Take 2 pointers left and right.
 *  3) if A[left] + A[right] >= K decrease left.
 *  4) Else found a answer.
 *  =============Solution 2=============
 *  1) Similar to map approach of Two sum problem.
 *  2) In case of 2 sum problem, in un-sorted array we look for "target-currentNumber" in HashMap,
 *  3) Here we look for lower than target - currentNumber in TreeSet.
	Input : [34,23,1,24,75,33,54,8]
	target : 60
				Set Values			    ||  Calculations
========================================||======================
			[] 							||	null   60-34===set empty. So no closest
			[34] 						||	34     60-23=47 --> First closest.
			[23, 34] 					||	34     60-1=59 --> Not closest
			[1, 23, 34] 				||	34     Found closest 60-24=36...Number lower than 36 is 34 which is there in set already.
			[1, 23, 24, 34] 			||	null
			[1, 23, 24, 34, 75] 		||	24
			[1, 23, 24, 33, 34, 75] 	||	1
			[1, 23, 24, 33, 34, 54, 75] ||	34

 */
public class TwoSumLessThanK {
  public int twoSumLessThanK(int[] arr, int target) {
    Arrays.sort(arr);
    int nearestSum = -1;
    for (int left = 0, right = arr.length - 1; left < right; ) {
      if (arr[left] + arr[right] >= target) right--;
      else nearestSum = Math.max(nearestSum, arr[left++] + arr[right]);
    }
    return nearestSum;
  }

  public int twoSumLessThanK1(int[] arr, int target) {
    TreeSet<Integer> set = new TreeSet<>();
    int res = -1;
    for (int currentNumber : arr) {
      Integer pre = set.lower(target - currentNumber);
      if (pre != null) res = Math.max(res, currentNumber + pre);
      set.add(currentNumber);
    }
    return res;
  }
}
