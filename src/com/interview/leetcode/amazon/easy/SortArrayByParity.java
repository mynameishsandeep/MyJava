package com.interview.leetcode.amazon.easy;

/*
* https://leetcode.com/problems/sort-array-by-parity/submissions/
=== Solution====
1) Keep 2 pointer head and tail. Head points first data and tail points last data
2) if head data is even. increment head alone.
3) if head data is odd, swap head and tail. decrement tail.


*/
public class SortArrayByParity {

  public int[] sortArrayByParity(int[] A) {

    int head = 0;
    int tail = A.length - 1;
    while (head < tail) {
      if (A[head] % 2 == 0) {
        head++;
      } else {
        int temp = A[head];
        A[head] = A[tail];
        A[tail] = temp;
        tail--;
      }
    }
    return A;
  }
}
