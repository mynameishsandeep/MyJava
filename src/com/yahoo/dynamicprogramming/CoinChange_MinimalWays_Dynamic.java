package com.yahoo.dynamicprogramming;

/*
 * https://leetcode.com/problems/coin-change/description/
 * https://www.youtube.com/watch?v=Y0ZqKpToTic
 * =======Theory Notes======
 * Here the subProblem is individual coins to make the sum.
 * Ex: {2,3,6} sum=12
 * 2 alone to make sum 12.
 * 2 and 3 to make sum 12.(Use previous memoized value of 2)
 * 2,3,6 to make sum. (Use previous memoized value of 2 and 3
 *========================
 *
	        0 1 2 3 4 5 6 7 8 9 10 11 12
	        ============================
	 {2} || 0 0 1 0 2 0 3 0 4 0 5  0  6   ==> For 1 Coin
   {2,4} || 0 0 1 0 1 0 2 0 2 0 3  0  3   ==> For 2 Coin
 {2,4,6} || 0 0 1 0 1 0 1 0 2 0 2  0  2   ==> For 3 Coin
 * =======================
 * 1) if current coin is less than current amount, don't do anything.
 * 2) if current coin is equal to current amount, fill 1 in dp[currentAmount].
 * 3) if current coin is greater than current amount,
 * 			If previous dp amount is not 0. Then dp[currentAmount] = dp[previousAmount] + 1
 * ============== Why Math.min============
If input is not sorted. Then Result is wrong. Applying math.min will solve problem.
[2,1]
5
dp array, without math.min
[0, 0, 1, 0, 2, 0]
[0, 1, 2, 3, 4, 5]
Expected : 3
Result(without Math.min) : 5

below is dp array, if math.min is applied
[0, 0, 1, 0, 2, 0]
[0, 1, 1, 2, 2, 3]===> notice the change from 2nd row 2nd column
===========================
 */

public class CoinChange_MinimalWays_Dynamic {
  /*
   * Below works for most cases. If the input is not sorted, then it will fail.
   *
   * check for current coin is greater than current amount is not needed since current amount starts from currentCoin
   * ===current amount is represented as i===
   */
  public int coinChangeStep1(int[] coins, int amount) {
    if (amount < 1) return 0;
    int[] dp = new int[amount + 1];
    for (int currentCoin : coins) {
      for (int i = currentCoin; i <= amount; i++) {
        if (i == currentCoin) dp[i] = 1; // current coin is equal to current amount
        else if (dp[i - currentCoin] != 0) { // previous dp amount is not 0
          dp[i] = dp[i - currentCoin] + 1; // update dp current amount with dp previous amount+1
        }
      }
    }
    return dp[amount] != 0 ? dp[amount] : -1;
  }

  /*
   * Added Math.min for corner cases i.e if input is not sorted.
   * ===current amount is represented as i===
   * Since default is 0, Math.min will pick 0 all time.
   * So to avoid that, if dp[currentAmount] is 0. then math.min not needed
   */
  public int coinChange(int[] coins, int amount) {
    if (amount < 1) return 0;
    int[] dp = new int[amount + 1];
    for (int currentCoin : coins) {
      for (int i = currentCoin; i <= amount; i++) {
        if (i == currentCoin) dp[i] = 1;
        else if (dp[i - currentCoin] != 0) {
          int dpPreviousAmoutPlus1 = dp[i - currentCoin] + 1;
          dp[i] = dp[i] == 0 ? dpPreviousAmoutPlus1 : Math.min(dp[i], dpPreviousAmoutPlus1);
        }
      }
    }
    return dp[amount] != 0 ? dp[amount] : -1;
  }

  public static void main(String[] args) {
    CoinChange_MinimalWays_Dynamic c = new CoinChange_MinimalWays_Dynamic();
    // System.out.println(c.coinChange(new int[] { 2, 3, 6 }, 12));
    System.out.println(c.coinChange(new int[] {2, 4, 6}, 12));
  }
}
