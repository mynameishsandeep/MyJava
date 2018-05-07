package com.sample.datastructure.recursion;

/**
 * Almost similar to groupSum Problem. 
 */

public class KnapSack {

	public static void main(String[] args) {

		int weightValues[] = new int[] { 60, 100, 120, 80, 40, 200 };
		int weights[] = new int[] { 1, 2, 3, 6, 4, 5 };
		int knapSackWeight = 11;
		System.out.println(knapSack(weightValues, weights, knapSackWeight, 0, 0));
		
		weightValues = new int[] { 60, 100, 120 };
		weights = new int[] { 1, 2, 3 };
		knapSackWeight = 3;
		System.out.println(knapSack(weightValues, weights, knapSackWeight, 0, 0));

	}

	private static int knapSack(int weightValues[], int weights[], int knapSackWeight, int currentSackWeightValues, int index) {
		if(knapSackWeight<0 ) {
			return currentSackWeightValues-weightValues[index-1];
		}
		if(knapSackWeight==0 || index == weights.length) {
			return currentSackWeightValues;
		}
		
		Integer left = knapSack(weightValues, weights, knapSackWeight-weights[index], currentSackWeightValues+weightValues[index], index+1);
		Integer right = knapSack(weightValues, weights, knapSackWeight, currentSackWeightValues, index+1);
		//System.out.println(left + " : " + right);
		return Math.max(left, right);
	}
}
