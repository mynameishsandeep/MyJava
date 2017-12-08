package com.yahoo.dynamicprogramming;

import java.util.Arrays;

/**
 *
 *

https://www.youtube.com/watch?v=sVAB0p58tlg

Result Matrix Formation. 0th row indicates, if i put 0 weight into sack, then its value is 0. 
This is mandate to get the 1st row formation

[0, 0, 0, 0, 0, 0]
[0, 60, 60, 60, 60, 60]
[0, 60, 100, 160, 160, 160]
[0, 60, 100, 160, 180, 220]
 
 */
public class KnapSackGeeks {

	// Returns the maximum value that can be put in a knapsack of capacity W
	static int knapSack(int knapSackWeight, int weights[], int weightValues[], int n) {
		int result[][] = new int[n+1][knapSackWeight + 1];


		// Start from 1st row and 1st column. 0th column always contains 0. 
		for (int i = 1; i <= n; i++) {
			int currentWeight = weights[i - 1];
			int currentWeightValue = weightValues[i - 1];
			for (int j = 1; j <= knapSackWeight; j++) {
				int previousWeightValue = result[i - 1][j];
				if (currentWeight <= j)
					result[i][j] = Math.max(currentWeightValue + result[i - 1][j - currentWeight], previousWeightValue);
				else
					result[i][j] = previousWeightValue;
			}
			System.out.println(Arrays.toString(result[i]));
		}

		return result[n][knapSackWeight];
	}

	// Driver program to test above function
	public static void main(String args[]) {
		int weightValues[] = new int[] { 60, 100, 120 };
		int weights[] = new int[] { 1, 2, 3 };
		int knapSackWeight = 5;
		int n = weightValues.length;
		System.out.println(knapSack(knapSackWeight, weights, weightValues, n));
	}
}
