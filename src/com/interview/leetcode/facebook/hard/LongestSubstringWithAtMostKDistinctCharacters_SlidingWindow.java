package com.interview.leetcode.facebook.hard;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/

1) First, we will insert characters from the beginning of the string until we have ‘K’ distinct characters in the HashMap.
2) These characters will constitute our sliding window.
3) We are asked to find the longest such window having no more than ‘K’ distinct characters.
We will remember the length of this window as the longest window so far.
4) After this, we will keep adding one character in the sliding window (i.e. slide the window ahead), in a stepwise fashion.
5) In each step, we will try to shrink the window from the beginning,
6) If the count of distinct characters in the HashMap is larger than ‘K’.
 We will shrink the window until we have no more than ‘K’ distinct characters in the HashMap.
 This is needed as we intend to find the longest window.
7) While shrinking, we’ll decrement the frequency of the character going out of the window and
remove it from the HashMap if its frequency becomes zero.
8) At the end of each step, we’ll check if the current window length is the longest so far, and if so, remember its length.

			"aabababcd"
			2
			Output: 7
			When loop reaches 'c'. It has to delete "aababa"


"aa"
2
Output:2

"ccaabbb"
2
Output:5


 */
public class LongestSubstringWithAtMostKDistinctCharacters_SlidingWindow {
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    Map<Character, Integer> map = new HashMap<>();
    int longest = 0;
    int left = 0;
    for (int right = 0; right < s.length(); right++) {
      Character rightChar = s.charAt(right);
      map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
      if (map.size() == k + 1) { // window crossed
        while (true) {
          Character leftChar = s.charAt(left++);
          map.put(leftChar, map.get(leftChar) - 1);
          if (map.get(leftChar) == 0) {
            map.remove(leftChar);
            break;
          }
        }
      }
      longest = Math.max(longest, right - left + 1);
    }
    return longest;
  }
}
