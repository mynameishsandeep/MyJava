package com.interview.leetcode.amazon.easy;

/*
 * https://leetcode.com/problems/squares-of-a-sorted-array/
Given an array of integers A sorted in non-decreasing order, return an array of the
squares of each number, also in sorted non-decreasing order.

Example 1:
Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]
========== Solution using auxiliary array =======
1) Keep 2 pointers head and tail.
2) Multiply data at header and data at tail.
3) Whichever is bigger save in result.
4) If head data is bigger increase head. If tail data is bigger decrease tail.
============Solution without auxiliary array is not possible===========

 */
public class SquaresOfASortedArray {
  public int[] sortedSquares(int[] A) {
    int head = 0;
    int tail = A.length - 1;
    int[] result = new int[A.length];
    int resultIndex = tail;
    while (head <= tail) {
      int headSquare = A[head] * A[head];
      int tailSquare = A[tail] * A[tail];
      // System.out.println(headSquare + " " + tailSquare);
      if (headSquare > tailSquare) {
        result[resultIndex--] = headSquare;
        head++;
      } else {
        result[resultIndex--] = tailSquare;
        tail--;
      }
    }
    return result;
  }
}
