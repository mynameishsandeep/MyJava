package com.interview.leetcode.amazon.easy;

/*
 *
 *  Simple Rule
 *  1) For Each entry, buy first
 *  2) Then sell.
 *  3) When buying, find bestBuy.
 *  4) Selling is simple. Which will give profit. Either + or - or some value
 *  5) Compare profit with maxProfit and update maxProfit
 *
For Each Entry, do the below...
1) Assume current entry as buy and calculate the lowestBuyPrice. lowestBuyPrice=Math.min(currentEntry,lowestBuyPrice)
2) Assume current entry as sell and calculate currentProfit. currentProfit=currentEntry-lowestBuyPrice
3) Calculate maxProfit. maxProfit = Math.max(currentProfit, maxProfit);
*/

public class BestTimeToBuyAndSellStock {

  public int maxProfit(int[] prices) {
    int maxProfit = 0;
    int lowestBuyPrice = Integer.MAX_VALUE;
    for (int i = 0; i < prices.length; i++) {
      lowestBuyPrice = Math.min(prices[i], lowestBuyPrice);
      int currentProfit = prices[i] - lowestBuyPrice;
      maxProfit = Math.max(currentProfit, maxProfit);
    }
    return maxProfit;
  }

  public static void main(String[] args) {
    BestTimeToBuyAndSellStock b = new BestTimeToBuyAndSellStock();
    System.out.println(b.maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
  }
}
