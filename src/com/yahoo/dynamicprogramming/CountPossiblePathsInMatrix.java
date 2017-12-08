package com.yahoo.dynamicprogramming;

import java.util.Arrays;
/**
 * https://www.youtube.com/watch?v=5E3se3Gm4aQ
 *
 */
public class CountPossiblePathsInMatrix {
	static int numberOfPaths(int m, int n) {
		int count[][] = new int[m][n];

		//If the input is a[n][1]. i.e multiple rows with 1 column, then output is 1. So fill 1.
		for (int i = 0; i < m; i++) {
			count[i][0] = 1;
		}
		//If the input is a[1][n]. i.e 1 row with multiple column, then output is 1. So fill 1.
		for (int j = 0; j < n; j++) {
			count[0][j] = 1;
		}

		for (int i = 0; i < m; i++) {
			System.out.println(Arrays.toString(count[i]));
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				count[i][j] = count[i - 1][j] + count[i][j - 1];
				//+ count[i-1][j-1];//If Diagonal movement is allowed.
			}

		}
		for (int i = 0; i < m; i++) {
			System.out.println(Arrays.toString(count[i]));
		}
		return count[m - 1][n - 1];
	}

	public static void main(String args[]) {
		System.out.println(numberOfPaths(4, 4));
	}

}
