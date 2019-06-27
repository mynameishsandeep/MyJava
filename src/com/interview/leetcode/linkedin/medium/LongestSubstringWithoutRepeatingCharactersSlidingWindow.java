package com.interview.leetcode.linkedin.medium;

import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 *Given a string, find the length of the longest substring without repeating characters.
 *
"abcad" output:4
"abcbad" output:4

*/

public class LongestSubstringWithoutRepeatingCharactersSlidingWindow {

  public int lengthOfLongestSubstring(String s) {
    int maxWindow = 0;
    Set<Character> set = new HashSet<>();
    int left = 0;
    for (int right = 0; right < s.length(); right++) {
      char rightChar = s.charAt(right);
      if (set.add(rightChar)) {
        maxWindow = Math.max(set.size(), maxWindow);
      } else { // duplicate. shrink window till previous
        char leftChar = s.charAt(left);
        while (leftChar != rightChar) {
          set.remove(leftChar);
          leftChar = s.charAt(++left);
        }
        left++;
        set.add(rightChar); // duplicate failed adding. So add it back.
      }
    }
    return maxWindow;
  }
}
