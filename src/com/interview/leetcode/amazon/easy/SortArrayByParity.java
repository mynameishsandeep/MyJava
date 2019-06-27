package com.interview.leetcode.amazon.easy;

/*
 * https://leetcode.com/problems/sort-array-by-parity/submissions/
 * 	The problem is about not using 2nd variable for result to save memory.     
	=== Solution====
	Compare by even pointer and odd pointer.
	if even pointer data is even, swap even and odd. increment eP and oP
	if even pointer data is odd. increment eP alone.
	if even reaches end. loop ends
 
 */
public class SortArrayByParity {

	public int[] sortArrayByParity(int[] A) {

		for (int eP = 0, oP = 0; eP < A.length; eP++) {
			if (0 == A[eP] % 2) {
				swap(A, eP, oP++);
			}
		}
		return A;
	}

	private void swap(int[] A, int a, int b) {
		if (A[a] != A[b]) {
			A[a] = A[a] ^ A[b];
			A[b] = A[a] ^ A[b];
			A[a] = A[a] ^ A[b];
		}
	}

}
