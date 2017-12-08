package com.sample.datastructure.recursion;

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

		//int coins[] = { 3, 9, 2, 1 };
		int coins[] = {10,25,5,1,10,5};
		int noOfOperation = coins.length/2;
		System.out.println(permute(coins, 0, coins.length - 1, 0, 0, noOfOperation));
	}

	public static int permute(int[] coins, int start, int end, int aMax, int bMax, int noOfOperation) {
		if (noOfOperation == 0 ) {
			System.out.println(aMax);
			System.out.println(bMax);
			return aMax;
		}

		int p1Index = start;
		int p1IndexNext = 0;
		int p2Index = 0;
		int p2IndexNext = 0;
		
		if (coins[start + 1] > coins[end]) {
			p2Index = start + 1;
			p1IndexNext = start+2;
			p2IndexNext = end;
		} else {
			p2Index = end;
			p1IndexNext = start+1;
			p2IndexNext = end-1;
		}

		int left = permute(coins, p1IndexNext, p2IndexNext, aMax + coins[p1Index], bMax + coins[p2Index], noOfOperation-1);

		p1Index = end;
		p1IndexNext = 0;
		p2Index = 0;
		p2IndexNext = 0;
		
		if (coins[start] > coins[end-1]) {
			p2Index = start;
			p1IndexNext = start+1;
			p2IndexNext = end-1;
		} else {
			p2Index = end-1;
			p1IndexNext = start;
			p2IndexNext = start+1;
		}

		int right = permute(coins, p1IndexNext, p2IndexNext, aMax + coins[p1Index], bMax + coins[p2Index], noOfOperation-1);
		return Math.max(left, right);

	}
}
