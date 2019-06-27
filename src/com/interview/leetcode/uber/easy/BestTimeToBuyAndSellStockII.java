package com.interview.leetcode.uber.easy;

/*
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii
 *
 * Hint to this problem is "at any point, just buy when you get profit".
 * ===================================================
 * It might seem like we are doing multiple transactions.
 * Ex: 1 2 3 4 5.... MaxProfit 4
 * How it should be: Buy at 1 and sell at 5 . Profit 4
 *
 * But how it was : buy at 1-> sell at 2, Profit 1
 * 					buy at 2-> sell at 3, Profit 1
 * 					buy at 3-> sell at 4, Profit 1
 * 					buy at 4-> sell at 5, Profit 1
 *
 * Coding to "How it should be" is pretty large. Still we achieve the same.
 * It is working because numbers are in ascending order.
 * Even if the case is different Ex:2, it still works. Because of number magic.
 *=====================================================
 * Ex2: 1 5 3 7... MaxProfit 8
 * Still the answer is 1->5, 3->7
 *
 *
 * ======Solution Approach======
 * next - previous = profit ---->then buy and sell. else ignore it.
 * ====================
 */
public class BestTimeToBuyAndSellStockII {
  public int maxProfit(int[] prices) {
    int maxProfit = 0;
    for (int i = 1; i < prices.length; i++) {
      int profit = prices[i] - prices[i - 1]; // current and previous
      if (profit > 0) {
        maxProfit += profit;
      }
    }
    return maxProfit;
  }
}
