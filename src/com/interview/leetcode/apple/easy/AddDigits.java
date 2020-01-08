package com.interview.leetcode.apple.easy;

/*
https://leetcode.com/problems/add-digits/

Input: 38
Output: 2
Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
             Since 2 has only one digit, return it.

 */
public class AddDigits {
  public int addDigitsMath(int num) {
    return (num - 1) % 9 + 1;
  }

  public int addDigits(int num) {
    while (num >= 10) {
      int q = num % 10;
      num = num / 10 + q;
    }
    return num;
  }
}
