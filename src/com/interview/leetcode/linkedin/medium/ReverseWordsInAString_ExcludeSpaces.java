package com.interview.leetcode.linkedin.medium;

import java.util.Arrays;
import java.util.Collections;

/*
https://leetcode.com/problems/reverse-words-in-a-string/description/

Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.
		// step 1. reverse the whole string
		// step 2. reverse each word
		// step 3. clean up spaces
 */
public class ReverseWordsInAString_ExcludeSpaces {

  public String reverseWords(String s) {
    if (s == null) return null;

    char[] a = s.toCharArray();
    int n = a.length;

    // step 1. reverse the whole string
    reverse(a, 0, n - 1);
    // step 2. reverse each word
    reverseWords(a, n);
    // step 3. clean up spaces
    return cleanSpaces(a, n);
  }

  void reverseWords(char[] a, int n) {
    int i = 0, j = 0;

    while (i < n) {
      while (i < j || i < n && a[i] == ' ') i++; // skip spaces
      while (j < i || j < n && a[j] != ' ') j++; // skip non spaces
      reverse(a, i, j - 1); // reverse the word
    }
  }

  // trim leading, trailing and multiple spaces
  String cleanSpaces(char[] a, int n) {
    int i = 0, j = 0;

    while (j < n) {
      while (j < n && a[j] == ' ') j++; // skip spaces
      while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
      while (j < n && a[j] == ' ') j++; // skip spaces
      if (j < n) a[i++] = ' '; // keep only one space
    }

    return new String(a).substring(0, i);
  }

  // reverse a[] from a[i] to a[j]
  private void reverse(char[] a, int i, int j) {
    while (i < j) {
      char t = a[i];
      a[i++] = a[j];
      a[j--] = t;
    }
  }

  public static String reverseWordsJavaUtility(String s) {
    // RegEx to split string by one or more spaces.
    String[] words = s.trim().split(" +");
    Collections.reverse(Arrays.asList(words));
    return String.join(" ", words);
  }

  public static void main(String[] args) {
    String s = " 12 34 ";
    ReverseWordsInAString_ExcludeSpaces r = new ReverseWordsInAString_ExcludeSpaces();
    System.out.println(r.reverseWords(s));
  }
}
