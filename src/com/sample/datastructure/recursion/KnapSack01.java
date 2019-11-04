package com.sample.datastructure.recursion;

/*
 * It is similar to groupSum Problem with additional condition sackWeight
 *
	Time complexity of algorithm is exponential O(2^n).
	For 4 weights recursion will take 31 combinations. i.e approximately equal to 2 power 4
​​* 							0
* 					60				0
* 			160    		60      100       0
*        280   160   180  60  220 100  120  0

 */

public class KnapSack01 {

  public static void main(String[] args) {

    int weightValues[] = new int[] {60, 100, 120, 80, 40, 200};
    int weights[] = new int[] {1, 2, 3, 6, 4, 5};
    int knapSackWeight = 11;
    System.out.println(knapSack(weightValues, weights, knapSackWeight, 0)); // 480

    weightValues = new int[] {60, 100, 120};
    weights = new int[] {1, 2, 3};
    knapSackWeight = 3;
    System.out.println(knapSack(weightValues, weights, knapSackWeight, 0)); // 160
  }

  private static int knapSack(int weightValues[], int weights[], int knapSackWeight, int index) {
    if (knapSackWeight <= 0 || index == weights.length) {
      return 0;
    }
    int left = 0;
    if (weights[index] <= knapSackWeight) {
      left =
          weightValues[index]
              + knapSack(weightValues, weights, knapSackWeight - weights[index], index + 1);
    }
    int right = knapSack(weightValues, weights, knapSackWeight, index + 1);
    // System.out.println(left + " : " + right);
    return Math.max(left, right);
  }
}
