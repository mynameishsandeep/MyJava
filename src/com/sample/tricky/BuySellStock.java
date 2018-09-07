package com.sample.tricky;

import com.interview.leetcode.amazon.easy.BestTimeToBuyAndSellStock;

/*
		1) Buy at low price and sell at max price.
		2) Keep Max Profit constant.
		3) Update low buy price
		4) Update max profit.

 */
public class BuySellStock {

	public int maxProfit(int[] prices) {
		int maxProfit = 0;
		int bestBuyPrice = Integer.MAX_VALUE;
		for (int i = 0; i < prices.length; i++) {
			int currentProfit = prices[i] - bestBuyPrice;
			// Update max Profit
			if (currentProfit > maxProfit) {
				maxProfit = currentProfit;
			}
			// Update minimum buy price.
			if (prices[i] < bestBuyPrice) {
				bestBuyPrice = prices[i];
			}
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		BestTimeToBuyAndSellStock b = new BestTimeToBuyAndSellStock();
		System.out.println(b.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
	}
}
