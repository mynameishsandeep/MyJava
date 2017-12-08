package com.yahoo.dynamicprogramming;

import java.util.Arrays;

/**
 * http://algorithms.tutorialhorizon.com/dynamic-programming-coin-change-problem/
 * 
 * https://www.youtube.com/watch?v=PafJOaMzstY

int amount = 5;
int[] v = { 1, 2, 3 };

Output Matrix:
[1, 0, 0, 0, 0, 0]
[1, 1, 1, 1, 1, 1]
[1, 1, 2, 2, 3, 3]
[1, 1, 2, 3, 4, 5]

 */
public class CoinChangeProblem {

	public static int dynamic(int[] coins, int amount) {
		
		
		// Oth row represents number of ways to make coin by 0, which is 0 always. 
		// This step is mandate needed for the first coin calculation, because we calculate value from top
		int[][] solution = new int[coins.length + 1][amount + 1];
		// if amount=0 then just return empty set to make the change
		for (int i = 0; i <= coins.length; i++) {
			solution[i][0] = 1;
		}

		// if no coins given, 0 ways to change the amount
		for (int i = 1; i <= amount; i++) {
			solution[0][i] = 0;
		}
		for (int i = 0; i < solution.length; i++) {
			System.out.println(Arrays.toString(solution[i]));
		}
		// now fill rest of the matrix.

		for (int i = 1; i <= coins.length; i++) {
			int currentCoin = coins[i-1];
			for (int j = 1; j <= amount; j++) {
				// check if the coin value is less than the amount needed
				if (currentCoin <= j) {
					// copy the value from the top + copy the value from the left by j-currentCoin
					solution[i][j] = solution[i - 1][j] + solution[i][j - currentCoin];
				} else {
					// just copy the value from the top
					solution[i][j] = solution[i - 1][j];
				}
			}
		}
		System.out.println("Output Matrix");
		for (int i = 0; i < solution.length; i++) {
			System.out.println(Arrays.toString(solution[i]));
		}

		return solution[coins.length][amount];
	}

	public static void main(String[] args) {
		int amount = 5;
		int[] v = { 1, 2, 3 };
		System.out.println("By Dynamic Programming " + dynamic(v, amount));
	}

}