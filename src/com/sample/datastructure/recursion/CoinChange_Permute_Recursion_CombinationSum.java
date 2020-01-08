package com.sample.datastructure.recursion;

/*
 *
 * https://leetcode.com/problems/coin-change-2/description/

Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1

 * This solution is based on modified GroupSum recursion.
 * Tree Image is present on "US Problems" "Coin Change.jpg"
 *
 * This solution will take too much time, if sum or coin is big.
 */
public class CoinChange_Permute_Recursion_CombinationSum {
  public int coinPermutationCount(int[] coins, int sum, int index) {

    if (sum == 0) return 1;
    if (sum < 0 || index == coins.length) return 0;
    int left = coinPermutationCount(coins, sum - coins[index], index);
    int right = coinPermutationCount(coins, sum, index + 1);
    return left + right;
  }
}
