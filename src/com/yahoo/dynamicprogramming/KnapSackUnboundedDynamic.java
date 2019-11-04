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
		int weightValues[] = new int[] { 15, 20, 50 };
		int weights[] = new int[] { 1, 2, 3 };
		int knapSackWeight = 5;

		0   1   2   3   4   5
		==========================
{1}		[0, 15, 30, 45, 60, 75]
{1,2}	[0, 15, 30, 45, 60, 75]
{1,2,3}	[0, 15, 30, 50, 65, 80]
==============================
currentWeight = weight newly added to set
condition 1) currentWeight equals indexWeight --> Math.max(previousWeightValues, currentWeightValues)
condition 2) currentWeight less than indexWeight --> fill previousWeightValues.
condition 3) currentWeight greater than indexWeight -->  Math.max(currentWeightValues+previousNegatedWeightValue, previousWeightValues)
 */
public class KnapSackUnboundedDynamic {}
