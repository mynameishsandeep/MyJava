package com.interview.leetcode.facebook.hard;

/*
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 *
 * Just change logic of "lowestBuyPrice2"
 * 
 * 
 * ================
input:[1,2,3,4,5]... 
maxProfit1:0 maxProfit2:0
maxProfit1:1 maxProfit2:1
maxProfit1:2 maxProfit2:2
maxProfit1:3 maxProfit2:3
maxProfit1:4 maxProfit2:4
==========================

input:[3,3,5,0,0,3,1,4]
maxProfit1:0 maxProfit2:0
maxProfit1:0 maxProfit2:0
maxProfit1:2 maxProfit2:2
maxProfit1:2 maxProfit2:2
maxProfit1:2 maxProfit2:2
maxProfit1:3 maxProfit2:5----change here
maxProfit1:3 maxProfit2:5
maxProfit1:4 maxProfit2:6
=========================
 */
public class BestTimeToBuyAndSellStockIII {

  public int maxProfit(int[] prices) {
    int maxProfit1 = 0;
    int maxProfit2 = 0;
    int lowestBuyPrice1 = Integer.MAX_VALUE;
    int lowestBuyPrice2 = Integer.MAX_VALUE;

    for (int p : prices) {
      lowestBuyPrice1 = Math.min(lowestBuyPrice1, p);
      int currentProfit1 = p - lowestBuyPrice1;
      maxProfit1 = Math.max(maxProfit1, currentProfit1);

      lowestBuyPrice2 = Math.min(lowestBuyPrice2, p - maxProfit1); // This is the only trick
      int currentProfit2 = p - lowestBuyPrice2;
      maxProfit2 = Math.max(maxProfit2, currentProfit2);
    }
    return maxProfit2;
  }
}
