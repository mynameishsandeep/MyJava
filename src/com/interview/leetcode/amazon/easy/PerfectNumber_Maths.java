package com.interview.leetcode.amazon.easy;

/*
 * https://leetcode.com/problems/perfect-number/
 */
public class PerfectNumber_Maths {

  public boolean checkPerfectNumber(int num) {
    if (num <= 1) {
      return false;
    }
    int count = 0;
    for (int i = 1; i <= num / 2; i++) {
      if (num % i == 0) {
        count += i;
      }
    }
    return count == num;
  }

  public boolean checkPerfectNumberBetter(int num) {
    if (num <= 1) {
      return false;
    }
    int count = 1;
    for (int i = 2; i <= Math.sqrt(num); i++) {
      if (num % i == 0) {
        count = count + i + num / i;
      }
    }
    return count == num;
  }
}
