package com.interview.leetcode.facebook.medium;

import java.util.ArrayList;
import java.util.List;

/*
 *

1) Wrong Understanding1: Always first set of data should be small and 2nd list is bigger. It is not true.
Refer Case1 and Case2 can come.
==========Case1============== startB >= startA && startB <= endA=======
Ex: A= [1,2]
	B= [2,3]

	A= [1,4]
	B= [2,3]
==========Case2============== startA >= startB && startA <= endB=========
Ex: A= [2,3]
	B= [1,2]

	A=[2,3]
	B=[1,4]
============

Ex: [[10,12],[18,19]]
	[[1,6],[8,11],[13,17],[19,20]]
Ans: [[10,11],[19,19]]

Time Complexity : O(N+M)
Space Complexity : O(1)
 *
 *
 */
public class IntervalListIntersections {

  public int[][] intervalIntersection(int[][] A, int[][] B) {

    List<Integer> result = new ArrayList<>();
    for (int i = 0, j = 0; i < A.length && j < B.length; ) {
      int startA = A[i][0];
      int endA = A[i][1];
      int startB = B[j][0];
      int endB = B[j][1];

      if (startA >= startB && startA <= endB || startB >= startA && startB <= endA) {
        int startAnswer = Math.max(startA, startB);
        int endAnswer = Math.min(endA, endB);
        result.add(startAnswer);
        result.add(endAnswer);
      }

      if (endA < endB) {
        i++;
      } else {
        j++;
      }
    }
    int resultArray[][] = new int[result.size() / 2][2];
    for (int i = 0, j = 0; i < result.size() / 2; i++) {
      resultArray[i][0] = result.get(j++);
      resultArray[i][1] = result.get(j++);
    }
    return resultArray;
  }
}
