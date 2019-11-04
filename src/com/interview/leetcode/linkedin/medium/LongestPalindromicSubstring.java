package com.interview.leetcode.linkedin.medium;

/*
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * Below is BruteForce algorithm based on "PalindromicSubstrings"
 *
 * 1) Start from 0 th character. Do it for Odd Length Palindrome and then Even Length Palindrome
 * 2) Save the index of left and right.
 * 3) Code can be optimized using memoization.
 */
public class LongestPalindromicSubstring {

  public String longestPalindrome(String s) {
    if (s.length() < 2) return s;
    String longest = s.substring(0, 1);
    for (int i = 0; i < s.length(); i++) {
      // get longest palindrome with center of i
      String tmp = getPalindromeString(s, i, i);
      if (tmp.length() > longest.length()) longest = tmp;

      // get longest palindrome with center of i, i+1
      tmp = getPalindromeString(s, i, i + 1);
      if (tmp.length() > longest.length()) longest = tmp;
    }
    return longest;
  }

  public String getPalindromeString(String s, int begin, int end) {
    while (begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)) {
      begin--;
      end++;
    }
    return s.substring(begin + 1, end);
  }
}
