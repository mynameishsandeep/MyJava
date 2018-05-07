package com.sample.datastructure.recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * You are given coins of different denominations and a total amount of money. 
 * Write a function to compute the number of combinations that make up that amount. 
 * You may assume that you have infinite number of each kind of coin. 
 * 
 * https://leetcode.com/problems/coin-change-2/description/
 * 
 * This solution is based on modified GroupSum recursion.
 * Tree Image is present on "US Problems" "Coin Change.jpg"
 * 
 * This solution will take too much time, if sum or coin is big. 
 */
public class CoinChange_Permute {
	public static void main(String[] args) {
		int coins[] = { 2, 3, 7 };
		int sum = 12;
		System.out.println(maxCoinCombination(coins, sum, 0));

		List<List<Integer>> allCombo = new ArrayList<>();
		coinPermutations(coins, sum, new ArrayList<>(), allCombo, 0);
		System.out.println(allCombo);

	}

	public static int maxCoinCombination(int coins[], int sum, int index) {

		if (sum == 0) {
			return 1;
		}
		if (sum < 0) {
			return 0;
		}
		if (index == coins.length) {
			return 0;
		}
		int left = maxCoinCombination(coins, sum - coins[index], index);
		int right = maxCoinCombination(coins, sum, index + 1);
		return left + right;
	}

	public static void coinPermutations(int coins[], int sum, List<Integer> currentCoins, List<List<Integer>> result,
			int index) {

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
