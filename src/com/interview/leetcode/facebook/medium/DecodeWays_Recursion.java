package com.interview.leetcode.facebook.medium;

/*
* https://leetcode.com/problems/decode-ways/description/
*
* A message containing letters from A-Z is being encoded to numbers using the following mapping:

	'A' -> 1
	'B' -> 2
	...
	'Z' -> 26

* Look into the tree structure "DecodeWays_Recursion.jpg" in US Problems
*
* 1) Single character match ( 1 to 9)
* 2) Two character match (10 to 26)
* 3) If there is a zero in the beginning, then result 0. Because 0 cannot be used with any next combination of digits.
* 4) 0 in the middle can("1201") or cannot(301) be used to get result count
* 4) For Empty String "". result is 0.
*
*
* 1201 --> [1,20,1] // only 1 result count. Because need to use all characters for decoding
* 0121 --> 0 count
* 301 --> 0 count
*
*
*/
public class DecodeWays_Recursion {
  public int numDecodings(String s) {
    if (s.length() == 1 && s.charAt(0) != '0') {
      return 1;
    }
    int left = 0;
    if (s.charAt(0) != '0') {
      left = numDecodings(s.substring(1));
    }
    int right = 0;
    if (s.length() > 1) {
      int twoDigit = Integer.parseInt(s.substring(0, 2));
      if (twoDigit > 9 && twoDigit < 27) {
        if (s.length() > 2) {
          right = numDecodings(s.substring(2));
        } else {
          right += 1;
        }
      }
    }
    return left + right;
  }

  public static void main(String[] args) {
    DecodeWays_Recursion d = new DecodeWays_Recursion();
    System.out.println(d.numDecodings("1234")); // [1234] [12,3,4][1,23,4]
    System.out.println(d.numDecodings("12"));
  }
}
