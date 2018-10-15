package com.interview.leetcode.linkedin.easy;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/isomorphic-strings/description/
 * 
Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. 
No two characters may map to the same character but a character may map to itself.

1) Map the source character to destination character in a HashMap.
2) If it is not matching return false.
3) Do Step1 and Step2 for String1 as source and String2 as destination and vice versa. 
 
 */
public class IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
		return isMatched(s, t) && isMatched(t, s);
	}

	private boolean isMatched(String s, String t) {
		Map<Character, Character> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char chS = s.charAt(i);
			char chT = t.charAt(i);
			if (map.containsKey(chS)) {
				if (map.get(chS) != chT) {
					return false;
				}
			} else {
				map.put(chS, chT);
			}
		}
		return true;
	}

	public boolean isIsomorphicBestApproach(String s, String t) {
		Map<Character, Character> sMap = new HashMap<>();
		Map<Character, Character> tMap = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (sMap.containsKey(s.charAt(i))) {
				if (sMap.get(s.charAt(i)) != t.charAt(i)) {
					return false;
				}
			} else if (tMap.containsKey(t.charAt(i))) {
				return false;
			} else {
				sMap.put(s.charAt(i), t.charAt(i));
				tMap.put(t.charAt(i), t.charAt(i));
			}
		}
		return true;
	}
}
