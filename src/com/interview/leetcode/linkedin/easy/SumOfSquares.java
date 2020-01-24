package com.interview.leetcode.linkedin.easy;

/*
* https://leetcode.com/problems/sum-of-square-numbers/description/
*
* 1) aSquare+bSquare=c
* 2) Set a = 0, b = SquareRoot Of C.
* 3) Reason is b cannot go more than SquareRoot Of C
* 4) Ex1: 0^2 + 2^2 = 4 Ex2: for 8. b cannot go more than 2.
* 5) So use 2 pointer approach. left=0, right=SquareRoot Of C.
* 6) Move left or right pointer based on below condition.
  if (left * left + right * right == c) return true;
  else if (left * left + right * right > c) right--;
  else left++;
*
*
*
*/
public class SumOfSquares {
  public boolean judgeSquareSum(int c) {
    int left = 0;
    int right = (int) Math.sqrt(c);
    while (left <= right) {
      if (left * left + right * right == c) return true;
      else if (left * left + right * right > c) right--;
      else left++;
    }
    return false;
  }
}
