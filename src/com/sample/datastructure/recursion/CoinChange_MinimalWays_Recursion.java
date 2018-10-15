package com.sample.datastructure.recursion;

public class CoinChange_MinimalWays_Recursion {

	public static void main(String[] args) {
		CoinChange_MinimalWays_Recursion c = new CoinChange_MinimalWays_Recursion();
		int[] coins = new int[] { 1, 5 };
		int target = 11;
		System.out.println(c.coinChange(coins, target, 0, 0));

		coins = new int[] { 9, 6, 5, 1, 11 };
		target = 11;
		System.out.println(c.coinChange(coins, target, 0, 0));

	}

	private int coinChange(int[] coins, int target, int index, int coinCount) {
		if (target == 0) { // Match found, return count of coins
			return coinCount;
		}
		if (target < 0) {
			return Integer.MAX_VALUE; // To indicate couldn't find target, since coins cannot be negative, stop here.
		}
		if (index == coins.length) {
			return Integer.MAX_VALUE; // To indicate couldn't find target, reached maximum index
		}
		int left = coinChange(coins, target - coins[index], index, coinCount + 1);
		int right = coinChange(coins, target, index + 1, coinCount);
		return Math.min(left, right);

	}
}
