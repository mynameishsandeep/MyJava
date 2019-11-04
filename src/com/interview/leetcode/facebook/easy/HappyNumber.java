package com.interview.leetcode.facebook.easy;

/*

https://leetcode.com/problems/happy-number/

1) Split the number.
2) Do Square and sum of number.
3) Do until, if it repeats or 1. 
4) If it repeats output false, If it reached 1 then true.

======Solution Approach========
1) Use and fast and slow pointer approach.
2) It will reach either loop or 1.
=================
 
Input: 19
Output: true
Explanation: 
1square + 9square = 82
8square + 2square = 68
6square + 8square = 100
1square + 0square + 0square = 1


 */
public class HappyNumber {
  public boolean isHappy(int n) {
    int slow = n;
    int fast = n;
    do {
      slow = count(slow);
      fast = count(count(fast));
    } while (slow != fast);
    return slow == 1;
  }

  private int count(int num) {
    int ans = 0, digit = 0;
    while (num > 0) {
      digit = num % 10;
      ans = ans + (digit * digit);
      num = num / 10;
    }

    return ans;
  }
}
