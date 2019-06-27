package com.yahoo.dynamicprogramming;
import java.util.Arrays;

/*
https://leetcode.com/problems/coin-change-2/description/
https://www.youtube.com/watch?v=jaNZ83Q3QGc

 * ==========Implementation NOTES=====
 * Filling the first row is the key to the solution and arrayIndex[0]=1 is the trick to the solution itself.
 * Filling first row has various logic. Below has lot of loop holes. Dont waste time
 * 1) mod the i by coin. But it will fail in many cases.
==================

1) We don't need 2 dimensional array, since we can retrieve both current value and previous value from same row.
  as mentioned in https://www.youtube.com/watch?v=PafJOaMzstY&t=347s.
  
	      0  1  2  3  4  5
	     =================
	1 || [1, 1, 1, 1, 1, 1]
	2 || [1, 1, 2, 2, 3, 3]
	3 || [1, 1, 2, 3, 4, 5]
	
 */
public class CoinChange_Permute_Dynamic_BestApproach {
	public static void main(String[] args) {
		int money = 5;
		int[] coins = { 1, 2, 3 };
		System.out.println(findCombinationsCount(money, coins));
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
