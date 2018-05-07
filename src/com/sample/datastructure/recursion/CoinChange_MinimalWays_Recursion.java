package com.sample.datastructure.recursion;

public class CoinChange_MinimalWays_Recursion {

	public static void main(String[] args) {
		CoinChange_MinimalWays_Recursion c = new CoinChange_MinimalWays_Recursion();
		int[] coins = new int[] { 1, 5, 5 };
		int amount = 11;
		System.out.println(c.coinChange(coins, amount, 0, 0));
		
		coins = new int[] { 9, 6, 5, 1, 11 };
		amount = 11;
		System.out.println(c.coinChange(coins, amount, 0, 0));

	}

	private int coinChange(int[] coins, int amount, int index, int count) {
		if (amount == 0) {
			return count;
		}
		if (amount < 0) {
			return Integer.MAX_VALUE;
		}
		if (index == coins.length) {
			return Integer.MAX_VALUE;
		}
		int left = coinChange(coins, amount - coins[index], index, count + 1);
		int right = coinChange(coins, amount, index + 1, count);
		return Math.min(left, right);

	}
}
