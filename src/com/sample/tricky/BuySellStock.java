package com.sample.tricky;

public class BuySellStock {

	public static void main(String[] args) {
		System.out.println(maxProfitBuyOneSellOne(new int[] { 7, 1, 5, 3, 6, 4 }));
	}

	public static int maxProfitBuyOneSellOne(int[] prices) {
		int profit = 0;
		int bestBuyPrice = Integer.MAX_VALUE;
		for (int i = 0; i < prices.length; i++) {

			bestBuyPrice = Math.min(bestBuyPrice, prices[i]);
			profit = Math.max(prices[i] - bestBuyPrice, profit);
		}
		return profit;

	}
}
