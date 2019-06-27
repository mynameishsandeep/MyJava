package com.interview.leetcode.facebook.hard;

/*
 * https://leetcode.com/problems/regular-expression-matching/
 *
 * 			'.' Matches any single character.
 * 			'*' Matches zero or more of the preceding element.
 *
 * 1) same character on pattern and input
 * 2) . in pattern.
 * 3) * in pattern. 2 cases arrive here
 * 		a) character before *
 * 		b) . before *
 *
 * ======Note=============
 * For "." and "alpha" we check for character at index 0.
 * For "*" we check at index1.
 *
 * ======
 * 1) The second character of p is *, now p string can match any number of character before *.
 * if(isMatch(s, p.substring(2)) means we can match the remaining s string, otherwise,
 * we check if the first character matches or not.
 * 2) If the second character is not *, we need match character one by one.
 *
 *
 * Ex:
 *
 *  ""
 *  ""
 *
 * 	abc
 * 	a*
 *
 *  aa
 *  a*
 *
 *  a
 *  a*
 *
 *  abcd
 *  a*b.d
 *
 */
public class RegularExpressionMatching_Recursion {

  // Base Condition Alone.
  public boolean isMatch_Step1(String s, String p) {
    if (p.length() == 0) {
      if (s.length() == 0) {
        return true;
      } else {
        return false;
      }
    }
    return false;
  }

  // Base Condition with check for "." or s[0]==p[0]
  public boolean isMatch_Step2(String s, String p) {
    if (p.length() == 0) {
      return s.length() == 0;
    } else if (p.charAt(1) == '*') { // second char is '*'

    } else { // second char is not '*'
      if (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0)) {
        return isMatch(s.substring(1), p.substring(1));
      }
      return false;
    }
    return false;
  }

  // Base Condition, with check for '*"
  public boolean isMatch_Step3(String s, String p) {
    if (p.length() == 0) {
      return s.length() == 0;
    } else if (p.charAt(1) == '*') { // second char is '*'
      if (isMatch(s, p.substring(2))) {
        return true;
      }
      if (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0)) {
        return isMatch(s.substring(1), p); // Note we are sending p and not p.substring(1)
      }
      return false;
    } else { // second char is . or alpha

    }
    return false;
  }

  public boolean isMatch(String s, String p) {
    if (p.length() == 0) {
      return s.length() == 0;
    } else if (p.length() > 1 && p.charAt(1) == '*') { // second char is '*'
      if (isMatch(s, p.substring(2))) {
        return true;
      }
      if (s.length() > 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))) {
        return isMatch(s.substring(1), p);
      }
      return false;
    } else { // second char is . or alpha
      if (s.length() > 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))) {
        return isMatch(s.substring(1), p.substring(1));
      }
      return false;
    }
  }

  public static void main(String[] args) {
    RegularExpressionMatching_Recursion r = new RegularExpressionMatching_Recursion();
    // System.out.println(r.isMatch("abc", "a*"));
    // System.out.println(r.isMatch("abc", "*"));
    // System.out.println(r.isMatch("aaaa", "a*"));
    System.out.println(r.isMatch("adceb", "*a*b")); // false
  }
}
