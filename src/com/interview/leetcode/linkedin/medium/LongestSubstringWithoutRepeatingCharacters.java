package com.interview.leetcode.linkedin.medium;

import java.util.HashSet;
import java.util.Set;

/*
It is based on sliding window.
Keep 2 variable i and j at index 0.
add each character to Set and move j.
when a duplicate found at index j. 
Delete 1 or more character in Set, till you delete the element found at index j.
Deleting the character in Set is obtained from index of i++ (window moves from 0 to till element)

input : abcdbe
i ->0 , j->3 till d
i ->0 , j->4 found duplicate "b".
charAt(0)--> a removed -->set contains "bcd"
charAt(1)--> b removed -->set contains "cd"
Now 
i ->2 j->4
No Dublicates for "b" --> b added to set..

*/

public class LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int ans = 0, i = 0, j = 0;
		while (i < n && j < n) {
			// try to extend the range [i, j]
			if (!set.contains(s.charAt(j))) {
				System.out.println("Adding " + s.charAt(j));
				set.add(s.charAt(j++));
				ans = Math.max(ans, j - i);
			} else {
				System.out.println("removing " + s.charAt(i));
				set.remove(s.charAt(i++));
			}
		}
		return ans;
	}

}
