package com.interview.leetcode.ebay;

import java.util.Arrays;

import com.yahoo.dynamicprogramming.GroupSum_Dynamic;

/*
* https://leetcode.com/problems/partition-equal-subset-sum/description/
*
* Solution Note using GroupSum Approach : Verify whether array can be split into 2 equal parts.
* If we able to get a result of sum/2 using groupsum. Then remaining number is remaining half of array.

*/
public class PartitionEqualSubsetSumDynamic {
  public static void main(String[] args) {
    PartitionEqualSubsetSumDynamic p = new PartitionEqualSubsetSumDynamic();
    int[] input = new int[] {1, 5, 11, 5};
    System.out.println(p.canPartition(input));
  }

  public boolean canPartition(int[] nums) {
    int sum = Arrays.stream(nums).sum();
    if (sum % 2 == 1) {
      return false;
    }
    System.out.println("Target to achieve is " + sum / 2);
    GroupSum_Dynamic g = new GroupSum_Dynamic();
    return g.groupSum(nums, sum / 2);
  }
}
