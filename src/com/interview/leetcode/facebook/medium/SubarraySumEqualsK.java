package com.interview.leetcode.facebook.medium;

import java.util.HashMap;

/*
 * https://leetcode.com/problems/subarray-sum-equals-k/

==================================
====================BruteForce======O(n^2)======================================================================
1) Simple sliding window. start left from 0 and right 1.
2) Move right till n. Find all sums.
3) Reason why we go all the way end is at any point if a negative number found it can get a result.
4) If a result found. Increase resultCount.
5) Increase left by 1 and right=left+1. Do step2.
=====================Best Approach=== O(n)========================================================================
1) Key to the problem is "Maintaining count of previous currentSum in a map"

2ways resultCount can increase
1) If currentSum reaches sum Ex: [0,0,0] with target=2, when i=0.
2) If prevSum contains (currSum - sum), increase currentSum by count of prevSum.
Ex:[0,0,0] with target = 0, when i=1 and i=2
		i=0,	resultCount=1,		{0=1}
		i=1,	resultCount=3,      {0=3}
		i=2,	resultCount=6,      {0=6}

=======Note: below case is enough to cover all test case during interview===========================================
[0,0,0]
0
Output : 6(1+2+3)
================================================================================================================
[3,2,1]
3
Output : 2

[1,1,1]
2
Output : 2
 */
public class SubarraySumEqualsK {
  public int subarraySumBruteForce(int[] nums, int sum) {
    int resultCount = 0;
    for (int left = 0; left < nums.length; left++) {
      int currentSum = nums[left];
      if (currentSum == sum) {
        resultCount++;
      }
      for (int right = left + 1; right < nums.length; right++) {
        currentSum += nums[right];
        if (currentSum == sum) {
          resultCount++;
        }
      }
    }
    return resultCount;
  }

  /*
   * 1) While traversing the array, store sum so far in currentSum.
   * 2) Maintain count of different values of currentSum in a map.
   * 3) If value of currentSum is equal to desired sum at any instance increment count of subArrays by one.
   * 4) From the map find number of subArrays previously found having sum equal to currentSum-sum.
   *
   */
  public int subarraySum(int[] arr, int sum) {
    HashMap<Integer, Integer> prevSumMap = new HashMap<>();
    int resultCount = 0;
    int currentSum = 0;
    for (int i = 0; i < arr.length; i++) {
      currentSum += arr[i];
      // If else not possible. Because of case [0,0] target=0 O/P=3
      if (currentSum == sum) resultCount++;
      Integer prevSum = prevSumMap.get(currentSum - sum);
      if (prevSum != null) resultCount += prevSum;

      Integer existingCount = prevSumMap.get(currentSum);
      if (existingCount == null) prevSumMap.put(currentSum, 1);
      else prevSumMap.put(currentSum, existingCount + 1);
    }
    return resultCount;
  }
}
