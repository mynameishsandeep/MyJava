package com.yahoo.dynamicprogramming;

import java.util.Arrays;

/*
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/CoinChangingMinimumCoin.java
 * https://leetcode.com/problems/coin-change/description/
 * https://www.youtube.com/watch?v=Y0ZqKpToTic
 * =======Theory Notes======
 * Here the subProblem is individual coins to make the sum.
 * Ex: {2,3,6} sum=12
 * 2 alone to make sum 12.
 * 2 and 3 to make sum 12.(Use previous memoized value of 2) 
 * 2,3,6 to make sum. (Use previous memoized value of 2 and 3
 * 
 * Step1: For the 1 coin alone.
 * 
 *    0 1 2 3 4 5 6 7 8 9 10 11 12 
 * 2  0 0 1 0 2 0 3 0 4 0 5  0  6
 * 4  0 0 1 0 1 0 2 0 2 0 3  0  3
 * 6  0 0 1 0 1 0 1 0 2 0 2  0  2 
 *   
 * ==========Implementation NOTES=====
 * Filling the first row is the key to the solution and Max_Value and arrayIndex[0]=0 is the trick to the solution itself.
 * Filling first row has various logic. Below has lot of loop holes. Dont waste time
 * 1) mod the i by coin. But it will fail in many cases.
 * 
 * 
 * ==============
 * 1) multi-dimension array not needed - can be done in single array
 * 2) Fill 0th column with 0. Fill 
 */

public class CoinChange_MinimalWays_Dynamic {
	public int coinChange(int[] coins, int amount) {
		if (amount < 1)
			return 0;
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int coin : coins) {
			for (int i = coin; i <= amount; i++) {
				// Calculate only when coin matches or previous time it is calculated
				if (dp[i - coin] != Integer.MAX_VALUE) { // First time if coin is 2. Then 2,4,6,8 filled.
					int currentCoinResult = dp[i - coin] + 1;
					int previousCoinResult = dp[i];
					dp[i] = Math.min(currentCoinResult, previousCoinResult);
				}
			}
			System.out.println(Arrays.toString(dp));
		}
		return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];

	}

	public static void main(String[] args) {
		CoinChange_MinimalWays_Dynamic c = new CoinChange_MinimalWays_Dynamic();
		//System.out.println(c.coinChange(new int[] { 2, 3, 6 }, 12));
		System.out.println(c.coinChange(new int[] { 2, 4, 6 }, 12));
	}
}
