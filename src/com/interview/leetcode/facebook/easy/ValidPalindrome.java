package com.interview.leetcode.facebook.easy;

/*
 * https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {
  public boolean isPalindrome(String s) {
    for (int left = 0, right = s.length() - 1; left < right; ) {
      Character leftChar = null;
      while (left < right) {
        leftChar = Character.toLowerCase(s.charAt(left++));
        if (Character.isDigit(leftChar) || Character.isAlphabetic(leftChar)) {
          break;
        }
        leftChar = null;
      }
      Character rightChar = null;
      while (left <= right) {
        rightChar = Character.toLowerCase(s.charAt(right--));
        if (Character.isDigit(right) || Character.isAlphabetic(right)) {
          break;
        }
        rightChar = null;
      }
      if (leftChar != null && rightChar != null && leftChar != right) return false;
    }
    return true;
  }
}
