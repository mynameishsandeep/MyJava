package com.yahoo.dynamicprogramming;
import java.util.Arrays;

/*
https://leetcode.com/problems/coin-change-2/description/
https://www.youtube.com/watch?v=jaNZ83Q3QGc

Given an infinite supply of ‘n’ coin denominations and a total money amount, 
we are asked to find the total number of distinct ways to make up that amount.

 * ==========Implementation NOTES=====
 * Filling the first row is the key to the solution and arrayIndex[0]=1 is the trick to the solution itself.
 * Filling first row has various logic. Below has lot of loop holes. Dont waste time
 * 1) mod the i by coin. But it will fail in many cases.
==================

1) We don't need 2 dimensional array, since we can retrieve both current value and previous value from same row.
  as mentioned in https://www.youtube.com/watch?v=PafJOaMzstY&t=347s.
  
====================================
 		    0  1  2  3  4  5  6  7  8  9 10  11 12
 		    ======================================
	{2}	|| [1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1] ==> For 1 Coin
  {2,4}	|| [1, 0, 1, 0, 2, 0, 2, 0, 3, 0, 3, 0, 4] ==> For 2 Coin
{2,4,6} || [1, 0, 1, 0, 2, 0, 3, 0, 4, 0, 5, 0, 7] ==> For 3 Coin

2,2,2,2,2,2
2,2,2,2,4
2,2,2,6
2,2,4,4
2,4,6
4,4,4
6,6

 */
public class CoinChange_Permute_Dynamic_BestApproach {
	public static void main(String[] args) {
		int amount = 12;
		int[] coins = { 2, 4, 6 };
		System.out.println(findCombinationsCount(amount, coins));
	}

	public static int findCombinationsCount(int amount, int coins[]) {
		int dp[] = new int[amount + 1];
		dp[0] = 1;
		for (int coin : coins) {
			for (int i = coin; i <= amount; ++i) {
				int currentCoinResult = dp[i];
				int previousCoinResult = dp[i - coin]; 
				dp[i] = currentCoinResult + previousCoinResult; 
			}
			System.out.println(Arrays.toString(dp));
		}
		return dp[amount];
	}
}
