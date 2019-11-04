package com.yahoo.array;

/*
 * https://leetcode.com/problems/maximum-subarray/description/
 *
 * =====Look for method "maxSubArrayMathematicalApproach" and compare with "MaximumProductSubarray.java"========
 */
public class MaximumSubArraySum_Maths {

  public static void main(String[] args) {
    // the contiguous subarray [4,-1,2,1] has the largest sum = 6.
    int[] input = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println(maxSubArray(input));

    int[] input2 = {-2, -6, -4, -1, -3};
    System.out.println(maxSubArray(input2));
  }

  /*
   * Below is the clean and mathematical approach.
   * Use this logic in interview.
   * 1) Take firstNumber as maxSum
   * 2) If (previousMax + currentMax) is greater than currentMax then set currentMax to (previousMax + currentMax).
   * 3) Update max.
   * 4) Update previousMax.
   */
  public static int maxSubArrayMathematicalApproach(int[] nums) {
    int max = nums[0];
    int previousMax = nums[0];
    for (int i = 1; i < nums.length; i++) {
      int currentMax = Math.max(nums[i], previousMax + nums[i]);
      max = Math.max(max, currentMax);
      previousMax = currentMax;
    }
    return max;
  }

  /*
   * below logic works only for positive numbers.
   * Because when resetting it has to min and not 0
   */
  public static int maxSubArray(int[] nums) {
    int sum = 0;
    // If i put maxSum to 0. Then it will not work for case {-1,-2,-3} . i.e all negative value.
    int maxSum = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      sum = sum + nums[i];
      // Adjust maxSum to current sum
      if (sum > maxSum) {
        maxSum = sum;
      }
      // Set the sum to zero in case value went negative
      if (sum < 0) {
        sum = 0;
      }
    }
    return maxSum;
  }
}
