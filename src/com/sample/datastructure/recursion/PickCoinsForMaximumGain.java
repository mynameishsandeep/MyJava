package com.sample.datastructure.recursion;

import java.util.Arrays;
import java.util.List;

/**
 * In the pick-up-coins game, an even number of coins are placed in a line. 
 * Two players take turns at choosing one coin each—they can only choose 
 * from the coins from start of line or ends of the line. 
 * The game ends when all the coins have been picked up. 
 * The player whose coins have the higher total value wins.
 * The requirement is choose coin such that player1 win always.
 * 
 * Ex: 3 9 2 1
 * Always P1 starts picking. 
 * If we go by greedy. Then P1 picks 3, then P2 picks 9. P1 picks 2, P2 picks 1. 
 * P1=3+2=5, P2=9+1. P2 wins.
 *
 *
 */
public class PickCoinsForMaximumGain {
	public static void main(String[] args) {

		//Integer coins[] = { 3, 9, 2, 1 };
		Integer coins[] = { 10, 25, 5, 1, 10, 5 };
		System.out.println(max_coin(coins, 0, coins.length - 1));

		List<Integer> coinsList = Arrays.asList(coins);
		int[][] maximumRevenueForRange = new int[coins.length][coins.length];
		System.out.println(computeMaximumRevenueForRange(coinsList, 0, coins.length - 1, maximumRevenueForRange));

		System.out.println(dp(coins, coins.length));
	}

	/*
	 * http://tech-queries.blogspot.com/2011/06/get-maximum-sum-from-coins-in-line.html
	 */
	private static int computeMaximumRevenueForRange(List<Integer> coins, int start, int end,
			int[][] maximumRevenueForRange) {
		if (start > end) {
			// No coins left. return 0;
			return 0;
		}

		if (maximumRevenueForRange[start][end] == 0) {
			int maximumRevenueByChoosingStart = coins.get(start)
					+ Math.min(computeMaximumRevenueForRange(coins, start + 2, end, maximumRevenueForRange),
							computeMaximumRevenueForRange(coins, start + 1, end - 1, maximumRevenueForRange));

			int maximumRevenueByChoosingEnd = coins.get(end)
					+ Math.min(computeMaximumRevenueForRange(coins, start + 1, end - 1, maximumRevenueForRange),
							computeMaximumRevenueForRange(coins, start, end - 2, maximumRevenueForRange));
			maximumRevenueForRange[start][end] = Math.max(maximumRevenueByChoosingStart, maximumRevenueByChoosingEnd);
		}
//		for (int i = 0; i < maximumRevenueForRange.length; i++) {
//			System.out.println(Arrays.toString(maximumRevenueForRange[i]));
//		}
		return maximumRevenueForRange[start][end];
	}

	public static int dp(Integer A[], int N) {
		int C[][] = new int[N][N];
		int x, y, z;
		for (int i = 0; i < N; i++) {
			for (int m = 0, n = i; n < N; m++, n++) {
				x = (m + 2 < N) ? C[m + 2][n] : 0;
				y = (m + 1 < N && n - 1 >= 0) ? C[m + 1][n - 1] : 0;
				z = (n - 1 > 0) ? C[m][n - 2] : 0;
				C[m][n] = Math.max(A[m] + Math.min(x, y), A[n] + Math.min(y, z));
			}
		}
		return C[0][N - 1];
	}

	public static int max_coin(Integer[] coin, Integer start, Integer end) {
		if (start > end) {
			return 0;
		}
		// If player1 chooses 1st coin. 
		// Option1:player2 can choose start+1. So player1 is left with start+2 to end.
		// Option2:player2 choose end. So player1 is left with start+1 to end-1
		// Since the player2 goes by greedy we will get minimum of Option1 and Option2 
		int leftLeft = max_coin(coin, start + 2, end);
		int leftRight = max_coin(coin, start + 1, end - 1);
		int left = coin[start] + Math.min(leftLeft, leftRight);

		// If player2 chooses last coin. 
		// Option1:player2 can choose start. So player1 is left with start+1 to end-1.
		// Option2:player2 choose end-1. So player1 is left with start to end-2
		// Since the player2 goes by greedy we will get minimum of Option1 and Option2
		int rightLeft = max_coin(coin, start + 1, end - 1);
		int rightRight = max_coin(coin, start, end - 2);
		int right = coin[end] + Math.min(rightLeft, rightRight);

		// Finally we will get the maximum of left and right
		return Math.max(left, right);

	}
}
