package com.interview.leetcode.amazon.easy;

/*
 * https://leetcode.com/problems/implement-strstr/
 *
 * 1) Don't create logic to increment i. Because inside inner loop i = i+j, because j always starts from 0.
 * 2) Another keypoint is
 * 			if (i + needle.length() <= haystack.length()) Then only do logic else -1.
 * 	Because (i.e) No sufficient space to compare in haystack
 *
 */
public class ImplementStrStr {

  public int strStr(String haystack, String needle) {
    for (int i = 0; ; i++) {
      for (int j = 0; ; j++) {
        if (j == needle.length()) return i;
        if (i + needle.length() <= haystack.length()) {
          if (needle.charAt(j) != haystack.charAt(i + j)) {
            break;
          }
        } else {
          return -1;
        }
      }
    }
  }
}
