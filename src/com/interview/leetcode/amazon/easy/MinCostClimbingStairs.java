package com.interview.leetcode.amazon.easy;

/*
 * https://leetcode.com/problems/min-cost-climbing-stairs/description/
 */
public class MinCostClimbingStairs {

	public int minCostClimbingStairs(int[] cost) {
		int step1 = cost[0];
		int step2 = cost[1];
		int current = 0;
		int result = 0;
		for (int i = 2; i <= cost.length; i++) {
			current = i == cost.length ? 0 : cost[i];
			result = Math.min(step1 + current, step2 + current);
			step1 = step2;
			step2 = result;
		}
		return result;
	}

	public static void main(String[] args) {
		MinCostClimbingStairs m = new MinCostClimbingStairs();
		int i[] = new int[] { 0, 0, 0, 1 };
		System.out.println(m.minCostClimbingStairs(i));
	}
}
