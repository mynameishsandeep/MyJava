package com.sample.tricky;

/*
 * https://leetcode.com/problems/sqrtx/description/
 *
 * The logic is to breakdown the problem using binary search.
 * Start from number/2
 * Ex: for 1000. 1 to 500, 1 to 250, 1 to 125, 1 to 62, 62 to 125... etc....
 *
 * ======return "high"========
 * Ex:
 *  input is 15, low will be 4 and high will be 3.
 *  input is 8, low will be 3 and high will be 2.
 *
 *  At anypoint low exceeds high we break the logic.
 *  So high will be lower and low will be higher
 *
 */
public class SquareRoot {

  public int mySqrt(int x) {
    if (x <= 1) return x;
    return binSearch(2, x / 2, x);
  }

  private int binSearch(int low, int high, int target) {
    if (low <= high) {
      long mid = low + (high - low) / 2;
      if (mid * mid == target) return (int) mid;
      else if (mid * mid > target) return binSearch(low, (int) mid - 1, target);
      else return binSearch((int) mid + 1, high, target);
    }
    return high;
  }
}
