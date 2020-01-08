package com.interview.leetcode.amazon.hard;
/*
https://leetcode.com/problems/interleaving-string/

s1="abc"
s2="bcd"
s3="abcbdc"
==result string=====All Total Combination=====
abc
a
ab
abc
abcb
abcbc
abb
ab
abb
abc
abcb
abcbc
abcbd
abcbdc
abcd
b
======Complexity Analysis=============
Time complexity : O(2^{m+n}). m is the length of s1. and n is the length of s2.

Space complexity : O(m+n). The size of stack for recursive calls can go upto m+n.
 */
public class InterleavingString2 {

  public boolean isInterleave(String s1, int i, String s2, int j, String result, String s3) {
    if (!s3.startsWith(result)) return false;
    if (result.equals(s3) && i == s1.length() && j == s2.length()) return true;
    boolean left = false, right = false;
    if (i < s1.length()) left = isInterleave(s1, i + 1, s2, j, result + s1.charAt(i), s3);
    if (j < s2.length()) right = isInterleave(s1, i, s2, j + 1, result + s2.charAt(j), s3);
    return left || right;
  }

  public boolean isInterleave(String s1, String s2, String s3) {
    return isInterleave(s1, 0, s2, 0, "", s3);
  }
}
