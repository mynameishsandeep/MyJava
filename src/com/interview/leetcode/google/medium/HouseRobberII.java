package com.interview.leetcode.google.medium;

/*
 * 
 * https://leetcode.com/problems/house-robber-ii/
 * 
 * 
	Use the previous Robber Solution to rob adjacent house.
	1 trick is house is circular. So use below solution.
	1) Rob from 0 to n-1 house.
	2) Rob from 1 to n house.
	Whichever is the max is the answer.
*/

public class HouseRobberII {

  public int rob(int[] nums) {
    if (nums.length == 1) return nums[0];
    int firstToNMinus1 = rob(nums, 0, nums.length - 1);
    int secondToN = rob(nums, 1, nums.length);
    return Math.max(firstToNMinus1, secondToN);
  }

  /*
   * f(n) = Math.max(f(n-2)+f(n),f(n-1))
   *
   * 1) If there are 1 house to rob, then max benefit would be f(n)
   * 2) If there are 2 house to rob, then max benefit would be Max of "f(n)", "f(n-1)"
   * 3) If there are 3 house to rob, then max benefit would be Max of "f(n)+f(n-2)", "f(n-1)"...
   * 	  Rob "house1 and house3" or "house1" alone. Max benefit is whichever is max
   *
   * Thats it, code for the formula
   */
  public int rob(int[] nums, int low, int high) {

    int fN = 0;
    int fNMinus1 = 0;
    int fNMinus2 = 0;
    for (int i = low; i < high; i++) {
      fN = Math.max(fNMinus2 + nums[i], fNMinus1);
      fNMinus2 = fNMinus1;
      fNMinus1 = fN;
    }
    return fN;
  }
}
