package com.yahoo.dynamicprogramming;

/*
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/CoinChangingMinimumCoin.java
 * 
 * https://www.youtube.com/watch?v=Y0ZqKpToTic
 */
public class CoinChange_MinimalWays_Dynamic {
	public int coinChange(int[] coins, int amount) {
		int T[] = new int[amount + 1];
		int R[] = new int[amount + 1];
		T[0] = 0;
		for (int i = 1; i <= amount; i++) {
			T[i] = Integer.MAX_VALUE - 1;
			R[i] = -1;
		}
		for (int j = 0; j < coins.length; j++) {
			for (int i = 1; i <= amount; i++) {
				if (i >= coins[j]) {
					if (T[i - coins[j]] + 1 < T[i]) {
						T[i] = 1 + T[i - coins[j]];
						R[i] = j;
					}
				}
			}
		}
		return T[amount];
	}

	public static void main(String[] args) {
		CoinChange_MinimalWays_Dynamic c = new CoinChange_MinimalWays_Dynamic();
		System.out.println(c.coinChange(new int[] { 2, 5 }, 12));
	}
}
