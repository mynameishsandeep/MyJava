package com.sample.tricky;

/**
 * https://leetcode.com/problems/number-of-islands/description/
 * 
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * 
 * Solution:
 * Check the problem IslandsInMatrix. 
 * In IslandsInMatrix we travel in 4 directions LeftToRight, LeftToBottomRight, TopTOBottom,RightToBottomLeft
 * 
 * 
 * It is the copied code from IslandsInMatrix.java. But we travel in 4 different directions.
 * LeftToRight, RightToLeft, TopToBottom, BottomToTop.
 *  
 */
public class IslandsInMatrixType2 {

	public static void main(String[] args) {

		int[][] input = { 
				{ 1, 1, 0, 0, 0 }, 
				{ 1, 1, 0, 0, 0 }, 
				{ 0, 0, 1, 0, 0 }, 
				{ 0, 0, 0, 1, 1 }, 
				};

		int[][] isProcessed = new int[input.length][input[0].length];
		int result = 0;
		for (int row = 0; row < input.length; row++) {
			for (int col = 0; col < input[0].length; col++) {
				if (!isProcessed(isProcessed, row, col) && 1 == input[row][col]) {
					findIsland(input, row, col, input.length - 1, input[0].length - 1, isProcessed);
					result++;
				}
			}
		}
		System.out.println(result);

	}

	public static boolean isProcessed(int[][] isProcessed, int row, int col) {
		return 1 == isProcessed[row][col];
	}

	public static boolean isValidRowCol(int row, int col, int rowMax, int colMax) {
		return row <= rowMax && row >= 0 && col <= colMax && col >= 0;
	}

	public static void findIsland(int[][] a, int row, int col, int rowMax, int colMax, int[][] isProcessed) {
		if (!isValidRowCol(row, col, rowMax, colMax)) {
			return;
		}
		if (isProcessed(isProcessed, row, col)) {
			return;
		}
		isProcessed[row][col] = 1;
		if (a[row][col] == 0) {
			return;
		}

		// leftToRight
		findIsland(a, row, col + 1, rowMax, colMax, isProcessed);

		//rightToLeft
		findIsland(a, row , col - 1, rowMax, colMax, isProcessed);

		// topToBottom
		findIsland(a, row + 1, col, rowMax, colMax, isProcessed);
        
        // BottomToTop
		findIsland(a, row - 1, col, rowMax, colMax, isProcessed);

	}

}
