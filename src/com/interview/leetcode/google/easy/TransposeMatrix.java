package com.interview.leetcode.google.easy;

/*
 * https://leetcode.com/problems/transpose-matrix/
 *
=====================================================================
If the number of rows and columns is same then solution can be formed without additional space.
Ex:
[1,2,3],
[4,5,6],
[7,8,9]]
==============loop1==============
0,1 --> 1,0   1,0 --> 0,1
0,2 --> 2,0   2,0 --> 0,2
==============loop2==============
1,2 --> 2,1   2,1 --> 1,2

[1,4,7],
[2,5,8],
[3,6,9]]

So for 9 elements swap happens 3 times
i.e 6 elements are arranged. 3(i==j) elements don't need swap
=====================================================================

 */
public class TransposeMatrix {

  public int[][] transpose(int[][] A) {
    if (A.length == A[0].length) {
      inPlace(A);
      return A;
    }
    return solutionWithAdditionalAttribute(A);
  }

  private int[][] solutionWithAdditionalAttribute(int[][] A) {
    int[][] B = new int[A[0].length][A.length];
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < A[0].length; j++) {
        B[j][i] = A[i][j];
      }
    }
    return B;
  }

  private void inPlace(int[][] A) {
    for (int i = 0; i < A.length - 1; i++) {
      for (int j = i + 1; j < A[0].length; j++) {
        if (i != j) {
          int temp = A[i][j];
          A[i][j] = A[j][i];
          A[j][i] = temp;
        }
      }
    }
  }
}
