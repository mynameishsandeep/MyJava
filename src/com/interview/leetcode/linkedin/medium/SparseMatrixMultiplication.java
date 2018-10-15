package com.interview.leetcode.linkedin.medium;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/sparse-matrix-multiplication/description/
 * 
 * https://www.programcreek.com/2014/10/leetcode-sparse-matrix-multiplication-java/
 * === Array might contains 0... So skip 0....
 * 
 * See the image "SparseMatrix.jpg" us problems
 * 
 * [[1,2,3],
 * [4,5,6]]
		*
	[[1,2,3],
	[4,5,6],
	[7,8,9]]
		=
	[[20,26,32],
	[44,59,74]]
 */
public class SparseMatrixMultiplication {
	public int[][] multiply(int[][] A, int[][] B) {
		int[][] C = new int[A.length][B[0].length];

		for (int i = 0; i < C.length; i++) {
			for (int k = 0; k < A[0].length; k++) {
				if (A[i][k] != 0) {
					for (int j = 0; j < C[0].length; j++) {
						C[i][j] += A[i][k] * B[k][j];
					}
				}
			}
		}

		return C;
	}

	public static void main(String[] args) {
		SparseMatrixMultiplication s = new SparseMatrixMultiplication();
		int[][] c = s.multiply(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } },
				new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });
		for (int[] cc : c) {
			System.out.println(Arrays.toString(cc));
		}
	}
}
