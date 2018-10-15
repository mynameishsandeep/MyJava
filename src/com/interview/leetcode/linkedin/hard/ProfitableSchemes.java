package com.interview.leetcode.linkedin.hard;

/*
 * 
 * https://leetcode.com/problems/profitable-schemes/description/ -- groupsum approach -- knapsack approach
 * 
 * Match the groupCount(G) with group and profitCount with profit.
 * 
 * 
Input: G = 10, P = 5, group = [2,3,5], profit = [6,7,8]
Output: 7

======Return Result at end of leaf level only by returning 1 at end of leaf.===========
=======If we go by resultCount then result will have bigger value. Because we are not trying to get max======= 
Draw the graph for above input and understand =========

This code is throwing TimeLimitException for bigger input. Right solution is DP

*/
public class ProfitableSchemes {

	public int profitableSchemes(int G, int P, int[] group, int[] profit) {
		return groupSum(group, profit, G, P, 0);
	}

	public int groupSum(int group[], int profit[], int g, int p, int index) {
		int curr = 0;
		if (p <= 0) {
			if (g >= 0) {
				curr = 1;
			}
		}
		if (g <= 0) {
			return curr;
		}

		if (index == profit.length) {
			return curr;
		}

		int left = groupSum(group, profit, g - group[index], p - profit[index], index + 1);
		int right = groupSum(group, profit, g, p, index + 1);
		return left + right;

	}
}