package com.interview.leetcode.amazon.easy;

/*
 * https://leetcode.com/problems/min-cost-climbing-stairs/description/
 * 
 * The problem is about reaching the floor after last step. So loop has to start from 0 to n rather n-1. 
 * 
 * 1) Go cost by cost. If there is only 1 cost. Then result is 0.
 * 2) If there is 2 cost. Then result will be minimum of 2 cost.
 * 
 * Note: initialize 4 variable. just go one by cost. 
 * Similar to reversing the linked list. 
 */
public class MinCostClimbingStairs {

	public int minCostClimbingStairs(int[] cost) {
		// prevStepCost
		int nMinus1StepCost = 0;
		// prevPrevStepCost
		int nMinus2StepCost = 0;
		int currentStepCost = 0;
		int minStepCost = 0;
		for (int i = 0; i <= cost.length; i++) {
			currentStepCost = i == cost.length ? 0 : cost[i];
			minStepCost = Math.min(nMinus1StepCost + currentStepCost, nMinus2StepCost + currentStepCost);
			nMinus1StepCost = nMinus2StepCost;
			nMinus2StepCost = minStepCost;
		}
		return minStepCost;
	}

	public static void main(String[] args) {
		MinCostClimbingStairs m = new MinCostClimbingStairs();
		int i[] = new int[] { 1 };
		System.out.println(m.minCostClimbingStairs(i));
		i = new int[] { 10, 15 };
		System.out.println(m.minCostClimbingStairs(i));
		i = new int[] { 10, 15, 20 };
		System.out.println(m.minCostClimbingStairs(i));
	}

}
