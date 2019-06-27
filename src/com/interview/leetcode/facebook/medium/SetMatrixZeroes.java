package com.interview.leetcode.facebook.medium;

/*
 * https://leetcode.com/problems/set-matrix-zeroes/description/
 * 
 * 1) Use first row and first column as a memory to keep track of all the 0's in the entire matrix.
 * 2) To track first row and first column itself. Use a separate variable.
 * 
 */
public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		boolean firstRowZero = false;
		boolean firstColumnZero = false;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					if (i == 0)
						firstRowZero = true;
					if (j == 0)
						firstColumnZero = true;
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		if (firstRowZero) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[0][j] = 0;
			}
		}
		if (firstColumnZero) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}

	}
}
