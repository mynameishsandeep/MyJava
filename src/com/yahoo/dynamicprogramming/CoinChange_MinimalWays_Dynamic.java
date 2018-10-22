package com.yahoo.dynamicprogramming;

import java.util.Arrays;

/*
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/CoinChangingMinimumCoin.java
 * 
 * https://www.youtube.com/watch?v=Y0ZqKpToTic
 * 
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
					dp[i] = Math.min(dp[i], dp[i - coin] + 1);
				}
			}
			System.out.println(Arrays.toString(dp));
		}

		return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
	}

	public static void main(String[] args) {
		CoinChange_MinimalWays_Dynamic c = new CoinChange_MinimalWays_Dynamic();
		System.out.println(c.coinChange(new int[] { 2, 5 }, 12));
	}
}
