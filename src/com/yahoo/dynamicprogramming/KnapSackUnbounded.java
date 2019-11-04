package com.yahoo.dynamicprogramming;

/*
Given the weights and profits of ‘N’ items, we are asked to put these items in a knapsack which has a capacity ‘C’. 
The goal is to get the maximum profit from the items in the knapsack. 
The only difference between the 0/1 Knapsack problem and this problem is 
that we are allowed to use an unlimited quantity of an item.

Let’s take the example of Merry, who wants to carry some fruits in the knapsack to get maximum profit. 
Here are the weights and profits of the fruits:

Items: { Apple, Orange, Melon }
Weights: { 1, 2, 3 }
Profits: { 15, 20, 50 }
Knapsack capacity: 5

Let’s try to put different combinations of fruits in the knapsack, such that their total weight is not more than 5.

5 Apples (total weight 5) => 75 profit
1 Apple + 2 Oranges (total weight 5) => 55 profit
2 Apples + 1 Melon (total weight 5) => 80 profit ------Answer
1 Orange + 1 Melon (total weight 5) => 70 profit
 =======Solution Approach==========
 The only difference between the 0/1 Knapsack problem and this one is that,
 after including the item, we recursively call to process all the items (including the current item).
 In 0/1 Knapsack, however, we recursively call to process the next items.
 ================================
 */
public class KnapSackUnbounded {
  public static void main(String[] args) {

    int weightValues[] = new int[] {15, 20, 50};
    int weights[] = new int[] {1, 2, 3};
    int knapSackWeight = 5;
    System.out.println(knapSack(weightValues, weights, knapSackWeight, 0));

    weightValues = new int[] {15, 20, 50};
    weights = new int[] {1, 2, 3};
    knapSackWeight = 6;
    System.out.println(knapSack(weightValues, weights, knapSackWeight, 0));
  }

  private static int knapSack(int weightValues[], int weights[], int knapSackWeight, int index) {
    if (knapSackWeight <= 0 || index == weights.length) {
      return 0;
    }
    int left = 0;
    if (weights[index] <= knapSackWeight) {
      left =
          weightValues[index]
              + knapSack(weightValues, weights, knapSackWeight - weights[index], index);
    }
    int right = knapSack(weightValues, weights, knapSackWeight, index + 1);
    // System.out.println(left + " : " + right);
    return Math.max(left, right);
  }
}
