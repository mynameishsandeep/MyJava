package com.interview.leetcode.linkedin.medium;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 *Given a string, find the length of the longest substring without repeating characters.
 *
=================Key========
1) In the actual sliding window, when a duplicate found.
I will slide "startWindow" from left to right, till the index of duplicate character.
during the move I will delete all character in set.
2) delete and move is costlier operation.
3) In this optimized solution, save the index of each character.
4) When a duplicate found, move windowStart to duplicateIndex+1  if previousRightCharIndex >= windowStart.
4a) windowStart remain in same place, even if there is duplicate,
 if above(previousRightCharIndex >= windowStart) condition is not satisfied.
5) So map will not be cleaned up. which will have redundant data.

====================
    input : abccbad
    windowStart duplicate dulplicateIndex longSize
    0               No                      0
    0               No                      1
    0               No                      2
    3               Yes     2               3 ---> windowStart updated
    3               Yes     1               3 ---> windowStart not updated
    3               Yes     0               3 ---> windowStart not updated
    3               No                      3 ---> windowStart not updated

    input : abcabcab
    windowStart duplicate dulplicateIndex longSize
    0           No                          0
    0           No                          1
    0           No                          2
    1           Yes         0               3 ---> windowStart updated
    2           Yes         1               3 ---> windowStart updated
    3           Yes         2               3 ---> windowStart updated
    4           Yes         4               3 ---> windowStart updated
    5           Yes         6               3 ---> windowStart updated

*/

public class LongestSubstringWithoutRepeatingCharactersSlidingWindowOptimized {

  public int lengthOfLongestSubstring(String str) {
    int windowStart = 0, longestSubstring = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (int windowEnd = windowStart; windowEnd < str.length(); windowEnd++) {
      Character rightChar = str.charAt(windowEnd);
      if (map.containsKey(rightChar)) {
        int previousIndexOfDuplicate = map.get(rightChar); // 2
        if (previousIndexOfDuplicate >= windowStart) {
          windowStart = previousIndexOfDuplicate + 1;
        }
      }
      map.put(rightChar, windowEnd);

      longestSubstring = Math.max(longestSubstring, windowEnd - windowStart + 1);
    }
    return longestSubstring;
  }
}
