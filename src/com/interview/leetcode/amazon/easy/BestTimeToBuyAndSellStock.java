package com.interview.leetcode.amazon.easy;

public class BestTimeToBuyAndSellStock {

	public int maxProfit(int[] prices) {
		Integer bestBuyPrice = Integer.MAX_VALUE;
		Integer maxProfit = 0;
		Integer currentProfit = 0;
        for(Integer currentPrice : prices) {
            bestBuyPrice = getBestBuyPrice(currentPrice, bestBuyPrice);
            currentProfit = getCurrentProfit(currentPrice,bestBuyPrice);
			maxProfit = Math.max(currentProfit, maxProfit);
		}
		return maxProfit;
	}

	public Integer getBestBuyPrice(Integer currentBuyPrice, Integer bestBuyPrice) {
		return Math.min(currentBuyPrice, bestBuyPrice);
	}

	public Integer getCurrentProfit(Integer currentSellPrice, Integer bestBuyPrice) {
		return currentSellPrice - bestBuyPrice;
	}
	
	public static void main(String[] args) {
		BestTimeToBuyAndSellStock b = new BestTimeToBuyAndSellStock();
		System.out.println(b.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
	}

}
