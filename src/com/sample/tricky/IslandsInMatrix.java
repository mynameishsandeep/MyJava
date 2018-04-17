package com.sample.tricky;

/**
 * Problem : Given a boolean 2D matrix, find the number of islands. A group of connected 1s forms an island.
 * 
 * http://www.geeksforgeeks.org/find-number-of-islands/
 * 
 * Complexity: O(row*column)
 * Solution:
 *  1) Construct an isProcessed array with all 0s.  
 *  2) Call row*col times findIsland() method for 
 *  		a) not processed elements in array and
 *  	 	b) data with value 1 
 *  to fill isProcessed array with 1s.
 *  3) Each time findIsand() method is called. We find 1 island. 
 *  Objective of findIsland() method is to fill isProcessed array.
 *  4) FindIsland method splits in 8 direction in most of online codes. But it is not necessary, 
 *  four direction is enough to find the connection of forms. 
 *  Because we are calling the loop from left to right for all 1s.
 *  
 *  In the below code findIsland() method 4 direction is commented. Enabling them will yield same result.    
 *
 */
public class IslandsInMatrix {

	public static void main(String[] args) {

		int[][] input = { 
				{ 1, 1, 0, 0, 0 }, 
				{ 1, 1, 0, 0, 0 }, 
				{ 0, 0, 1, 0, 0 }, 
				{ 0, 0, 0, 1, 1 }, };

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

		//leftToRightBottomDiagnonal
		findIsland(a, row + 1, col + 1, rowMax, colMax, isProcessed);

		// topToBottom
		findIsland(a, row + 1, col, rowMax, colMax, isProcessed);

		//rightToLeftBottomDiagonal
		findIsland(a, row + 1, col - 1, rowMax, colMax, isProcessed);

//		//rightToLeft
//		findIsland(a, row , col - 1, rowMax, colMax, isProcessed);
//		
//		//rightToLeftTopDiagonal
//		findIsland(a, row-1 , col - 1, rowMax, colMax, isProcessed);
//
//        // BottomToTop
//		findIsland(a, row - 1, col, rowMax, colMax, isProcessed);
//		
//		//leftToRightTopDiagnonal
//		findIsland(a, row - 1, col +  1, rowMax, colMax, isProcessed);

	}

}