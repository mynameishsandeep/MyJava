package com.interview.leetcode.amazon.easy;

/*
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 *
 * 1) Instead of adding String to charArray or linkedList and then parsing
 * 2) Add it StringBuilder or String
 *
 */
public class RemoveAllAdjacentDuplicatesInString {

  // 3ms. Best Approach. Using 2 Pointers
  public String removeDuplicates(String S) {
    int left = 0, n = S.length();
    char[] res = S.toCharArray();
    for (int right = 0; right < n; ++right, ++left) {
      res[left] = res[right]; // copy from right to left
      if (left > 0 && res[left - 1] == res[left]) left -= 2;
    }
    return new String(res, 0, left);
  }
  // 16 ms. better
  public String removeDuplicates1(String S) {
    StringBuilder s = new StringBuilder();
    for (Character c : S.toCharArray()) {
      if (s.length() > 0 && c == s.charAt(s.length() - 1)) {
        s.deleteCharAt(s.length() - 1);
      } else {
        s.append(c);
      }
    }
    return s.toString();
  }

  // 710 ms. worst approach. Because of String
  public String removeDuplicates2(String S) {
    String s = "";
    for (Character c : S.toCharArray()) {
      if (s.length() > 0 && c == s.charAt(s.length() - 1)) {
        s = s.substring(0, s.length() - 1);
      } else {
        s += c;
      }
    }
    return s;
  }
}
