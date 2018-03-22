package com.interview.leetcode.google.easy;

/*
 * https://leetcode.com/problems/toeplitz-matrix/description/
 */
public class ToeplitzMatrix {

	public static boolean isToeplitzMatrix(Integer[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (i + 1 <= matrix.length - 1 && j + 1 <= matrix[i].length-1) {
					System.out.println(matrix[i][j] + " " + matrix[i + 1][j + 1]);
					if (matrix[i][j] != matrix[i + 1][j + 1]) {
						return false;
					}
				}

			}
		}
		return true;
	}

	public static void main(String[] args) {
		Integer input[][] = { { 1, 2, 3, 4 }, { 5, 1, 2, 3 }, { 9, 5, 1, 2 } };
		System.out.println(isToeplitzMatrix(input));
	}

}
