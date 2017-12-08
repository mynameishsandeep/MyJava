package com.sample.datastructure.recursion;

/**
 * Almost similar to groupSum Problem. 
 */

public class KnapSack {

	public static void main(String[] args) {

		int weightValues[] = new int[] { 60, 100, 120 };
		int weights[] = new int[] { 1, 2, 3 };

		int knapSackWeight = 50;
		int n = weights.length;
		System.out.println(knapSack(weightValues, weights, knapSackWeight, n, 0, 0, 0));
	}

	public static int knapSack(int[] weightValues, int[] weights, int knapSackWeight, int n, int start,
			int runTimeWeightValues, int runTimeWeights) {

		if (runTimeWeights == knapSackWeight) {
			return runTimeWeightValues;
		}
		if (runTimeWeights > knapSackWeight) {
			return runTimeWeightValues - weightValues[start - 1];
		}
		if (start == n) {
			return runTimeWeightValues;
		}
		int left = knapSack(weightValues, weights, knapSackWeight, n, start + 1,
				runTimeWeightValues + weightValues[start], runTimeWeights + weights[start]);

		int right = knapSack(weightValues, weights, knapSackWeight, n, start + 1, runTimeWeightValues, runTimeWeights);
		//System.out.println(left + " : " + right);
		return Math.max(left, right);
	}
}
