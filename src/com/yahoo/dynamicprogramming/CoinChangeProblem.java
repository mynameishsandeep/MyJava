package com.yahoo.dynamicprogramming;

public class CoinChangeProblem {

	public static int dynamic(int[] v, int amount) {
		int[][] solution = new int[v.length + 1][amount + 1];

		// if amount=0 then just return empty set to make the change
		for (int i = 0; i <= v.length; i++) {
			solution[i][0] = 1;
		}

		// if no coins given, 0 ways to change the amount
		for (int i = 1; i <= amount; i++) {
			solution[0][i] = 0;
		}

		// now fill rest of the matrix.

		for (int i = 1; i <= v.length; i++) {
			for (int j = 1; j <= amount; j++) {
				// check if the coin value is less than the amount needed
				if (v[i - 1] <= j) {
					// reduce the amount by coin value and
					// use the subproblem solution (amount-v[i]) and
					// add the solution from the top to it
					solution[i][j] = solution[i - 1][j] + solution[i][j - v[i - 1]];
				} else {
					// just copy the value from the top
					solution[i][j] = solution[i - 1][j];
				}
			}	
		}
		return solution[v.length][amount];
	}

	public static void main(String[] args) {
		int amount = 6;
		Integer[] v = { 1, 3, 5 };
		System.out.println("By Dynamic Programming " + dynamicBottomUp(v, amount));
	}

	/*
	 * This code was written by me and above method is taken from below site
	 * http://algorithms.tutorialhorizon.com/dynamic-programming-coin-change-problem/
	 */
	public static Integer dynamicBottomUp(Integer[] coins, Integer total) {
		Integer combinations[][] = new Integer[coins.length][total+1];
		for (int i = 0; i < coins.length; i++) {
			combinations[i][0] = 1;
		}
		for (int i = 0; i <= total; i++) {
			combinations[0][i] = 1;
		}
		for (int outer = 1; outer < coins.length; outer++) {
			for (int inner = 0; inner <= total; inner++) {
				if(coins[outer]>inner) {
					combinations[outer][inner] = combinations[outer-1][inner]; 
				}
				else {
					combinations[outer][inner] = combinations[outer-1][inner]+combinations[outer][inner-coins[outer]]; 
				}
			}
		}
		return combinations[coins.length-1][total];
	}
}