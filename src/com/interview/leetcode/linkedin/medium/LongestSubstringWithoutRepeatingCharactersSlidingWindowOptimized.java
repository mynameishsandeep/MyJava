package com.interview.leetcode.linkedin.medium;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 *Given a string, find the length of the longest substring without repeating characters.
 *
=================Key============================================================================
1) In the actual sliding window, when a duplicate found. I will slide from left to index of duplicate character.
during the move I will delete all character in set.
2) delete and move is costlier operation.
3) In this optimized solution, save the index of each character.
4) When a duplicate found, move left to duplicateIndex+1.
4a) If duplicateIndex is less than left, then left is not updated... that means those duplicateIndex data should have already deleted.
Ex: abba. When index at 3. for "a" duplicate is found but left should not be updated.
5) Finally map will not be cleaned up, so it will have redundant data.

    input : abccbad
    left           dulplicate        dulplicate
    					             Index             maxSize
    =============================================================================
    0               No                      			0
    0               No                      			1
    0               No                      			2
    3               Yes     		2               	3 ---> left updated
    3               Yes     		1               	3 ---> left not updated
    3               Yes     		0               	3 ---> left not updated
    3               No                      			3 ---> left not updated

    input : abcabcab
    left   		dulplicate		dulplicate
    							Index 				  maxSize
    =============================================================================
    0           No                        			   0
    0           No                       			   1
    0           No                     			       2
    1           Yes         	0          			   3 ---> left updated
    2           Yes         	1          			   3 ---> left updated
    3           Yes         	2           		   3 ---> left updated
    4           Yes         	4          			   3 ---> left updated
    5           Yes         	6          			   3 ---> left updated
	=============================================================================
*/

public class LongestSubstringWithoutRepeatingCharactersSlidingWindowOptimized {

  public int lengthOfLongestSubstring(String str) {
    int left = 0, longestSubstring = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (int right = left; right < str.length(); right++) {
      Character rightChar = str.charAt(right);
      if (map.containsKey(rightChar)) {
        int duplicateIndex = map.get(rightChar); // 2
        if (duplicateIndex >= left) {
          left = duplicateIndex + 1;
        }
      }
      map.put(rightChar, right);
      longestSubstring = Math.max(longestSubstring, right - left + 1);
    }
    return longestSubstring;
  }
}
