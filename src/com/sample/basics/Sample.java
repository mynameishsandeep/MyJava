package com.sample.basics;

import java.util.HashMap;
import java.util.Map;

/**
 * implement addTask, getList, have a service to send notification if its due..
 * mark_done
 * 
 * @author chandrasekhar
 *
 */
public class Sample {


	public static void main(String[] args) {

		int[][] input = { 
				{ 1, 1, 0, 0, 0 }, 
				{ 1, 1, 0, 0, 0 }, 
				{ 0, 0, 1, 0, 0 }, 
				{ 0, 0, 0, 1, 1 }, 
				};

		int[][] isProcessed = new int[input.length][input[0].length];
		int result = 0;
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[0].length; j++) {
				if (!isProcessed(isProcessed, i, j) && 1 == input[i][j]) {
					findIsland(input, i, j, input.length - 1, input[0].length - 1, isProcessed);
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

		//leftToRightDiagnonal
		findIsland(a, row + 1, col + 1, rowMax, colMax, isProcessed);

		// topToBottom
		findIsland(a, row + 1, col, rowMax, colMax, isProcessed);

		//rightToLeftDiagonal
		findIsland(a, row + 1, col - 1, rowMax, colMax, isProcessed);

	}

}