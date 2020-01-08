package com.sample.datastructure.recursion;

import java.util.ArrayList;
import java.util.List;

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
public class CoinChange_Permute_Recursion_GetCombination {
  public static void main(String[] args) {
    int[] coins = {2, 3, 7};
    int sum = 12;

    List<List<Integer>> allCombo = new ArrayList<>();
    coinPermutations(coins, sum, new ArrayList<>(), allCombo, 0);
    System.out.println(allCombo);
  }

  public static void coinPermutations(
      int coins[], int sum, List<Integer> currentCoins, List<List<Integer>> result, int index) {
    if (sum == sum(currentCoins)) {
      result.add(currentCoins);
      return;
    }
    if (sum(currentCoins) > sum) {
      return;
    }
    if (index == coins.length) {
      return;
    }
    coinPermutations(coins, sum, copyList(currentCoins, coins[index]), result, index);
    coinPermutations(coins, sum, currentCoins, result, index + 1);
  }

  private static List<Integer> copyList(List<Integer> input, Integer data) {
    List<Integer> result = new ArrayList<>();
    result.addAll(input);
    result.add(data);
    return result;
  }

  private static int sum(List<Integer> coins) {
    int result = 0;
    for (Integer coin : coins) {
      result += coin;
    }
    return result;
  }
}
