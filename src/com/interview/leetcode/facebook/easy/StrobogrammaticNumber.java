package com.interview.leetcode.facebook.easy;

public class StrobogrammaticNumber {

  /*
  ==========Tricky and nice code using Two Pointer Approach========

  1) Compare one side with actual number. Another side with rotated number.
  1a) Save the rotated number in map.
  2) Rotated number for "0,1,8" is itself and for "6,9" is "9,6". For rest of chars, save any dummy char
  3) Last trick is for loop runs "i<=j". i.e for 1 input loop runs 1 time. and 3 input 2 times.
  Ex: 6. In this case run loop 1 time. 6 compared with 9. So fails
  Ex: 699. In this case run loop 2 times. Middle 9 compared with 6. So fails

  */
  public boolean isStrobogrammatic(String num) {
    // d for dummy
    char[] map = {'0', '1', 'd', 'd', 'd', 'd', '9', 'd', '8', '6'};

    for (int i = 0, j = num.length() - 1; i <= j; i++, j--)
      if (num.charAt(i) != map[num.charAt(j) - '0']) {
        return false;
      }

    return true;
  }

  public boolean isStrobogrammaticMap(String num) {

    for (int i = 0, j = num.length() - 1; i < j; i++, j--)
      if (num.charAt(i) != num.charAt(j)) return false;

    if (num.length() % 2 == 1) {
      return num.charAt(num.length() / 2) != '6' || num.charAt(num.length() / 2) != '9';
    }

    return true;
  }
}
