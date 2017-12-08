package com.sample.datastructure.recursion;

/**
 * 
 * Count all possible paths from top left(0,0) to bottom right(row-1, col-1) of a mXn matrix
 * 
 * http://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
 */
public class CountPossiblePathsInMatrix {

	public static int numberOfPathsOptimal(int i, int j, int row, int col) {
		// If row end is reached or column end is reached, 
		// then there is only way to reach the result corner. So returning 1
		if (i == row || j == col) {
			return 1;
		}
		int left = numberOfPathsOptimal(i, j + 1, row, col);
		int right = numberOfPathsOptimal(i + 1, j, row, col);
		int diagonal = numberOfPathsOptimal(i + 1, j + 1, row, col); // For diagonal move
		return left + right;
	}

	public static int numberOfPaths(int i, int j, int row, int col) {
		// when result corner(m*n) is reached, returning 1. 
		// But this is unnecessary. 
		// Look above method "numberOfPaths(int m, int n)" which has optimal solution. 
		if (i == row && j == col) {
			return 1;
		}
		int left = 0;
		int right = 0;
		if (j != col) {
			left = numberOfPaths(i, j + 1, row, col);
		}
		if (i != row) {
			right = numberOfPaths(i + 1, j, row, col);
		}
		return left + right;
	}

	public static void main(String args[]) {
		int row = 4;
		int col = 4;
		System.out.println(numberOfPaths(0, 0, row - 1, col - 1));

		System.out.println(numberOfPathsOptimal(0, 0, row - 1, col - 1));
	}

}
