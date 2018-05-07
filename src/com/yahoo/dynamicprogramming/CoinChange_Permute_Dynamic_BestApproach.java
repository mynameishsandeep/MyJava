package com.yahoo.dynamicprogramming;
import java.util.Arrays;

/*
https://leetcode.com/problems/coin-change-2/description/
https://www.youtube.com/watch?v=jaNZ83Q3QGc

1) We don't need 2 dimensional array, since we can retrieve both current value and previous value from same row.
  as mentioned in https://www.youtube.com/watch?v=PafJOaMzstY&t=347s.
  
	     0   1  2  3  4  5
	     =================
	1 || [1, 1, 1, 1, 1, 1]
	2 || [1, 1, 2, 2, 3, 3]
	3 || [1, 1, 2, 3, 4, 5]
 */
public class CoinChange_Permute_Dynamic_BestApproach {
	public static void main(String[] args) {
		int money = 5;
		int[] coins = { 1, 2, 3 };
		System.out.println(findCombinationsCount(money, coins));
	}

	public static int findCombinationsCount(int amount, int coins[]) {
		int dp[] = new int[amount + 1];
		dp[0] = 1;
		for (int i = 0; i < coins.length; ++i) {
			for (int j = coins[i]; j <= amount; ++j) {
				dp[j] += dp[j - coins[i]];
			}
			System.out.println(Arrays.toString(dp));
		}
		return dp[amount];
	}
}
