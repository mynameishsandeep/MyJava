package com.interview.leetcode.amazon.hard;

/*
https://leetcode.com/problems/interleaving-string/

s1="abc"
s2="bcd"
s3="abcbdc"
==result string=====All Total Combination=====
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
===============Solution Approach==============
1) Understand InterleavingString2 and InterleavingString.
2) The recursive approach leads to redundant computations. Ex: Remember like Fibonacci.
So avoid redundant computations by returning false. Because it failed previously for that permutation.
======Complexity Analysis=============
Time complexity : O(2^{m+n}). m is the length of s1. and n is the length of s2.
Space complexity : O(m+n). The size of stack for recursive calls can go upto m+n.
 */
public class InterleavingStringWithMemo {

  private boolean[][] isVisited;

  public boolean isInterleave(String s1, int i, String s2, int j, String result, String s3) {
    if (isVisited[i][j] || !s3.startsWith(result)) return false;
    if (result.equals(s3) && i == s1.length() && j == s2.length()) return true;
    boolean left = false, right = false;
    if (i < s1.length()) left = isInterleave(s1, i + 1, s2, j, result + s1.charAt(i), s3);
    if (j < s2.length()) right = isInterleave(s1, i, s2, j + 1, result + s2.charAt(j), s3);
    isVisited[i][j] = true;
    return left || right;
  }

  public boolean isInterleave(String s1, String s2, String s3) {
    isVisited = new boolean[s1.length() + 1][s2.length() + 1];
    return isInterleave(s1, 0, s2, 0, "", s3);
  }
}
