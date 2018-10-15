package com.interview.leetcode.google.hard;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		Map<Character, Integer> map = new HashMap<>();

		int j = 0;
		int i = 0;
		int len = 0;

		for (i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!map.containsKey(c)) {
				map.put(c, i);
			} else {
				int pos = map.get(c);
				map.put(c, i);
			}

			if (map.size() > 2) {
				len = Math.max(len, i - j);

				// Then shrink the window size
				while (map.size() > 2) {
					if (map.containsKey(s.charAt(j)) && map.get(s.charAt(j)) == j) {
						map.remove(s.charAt(j));
					}
					j++;
				}
			}
		}

		if (j < s.length()) {
			len = Math.max(len, i - j);
		}

		return len;
	}

	public static void main(String[] args) {
		LongestSubstringWithAtMostTwoDistinctCharacters l = new LongestSubstringWithAtMostTwoDistinctCharacters();
		System.out.println(l.lengthOfLongestSubstringTwoDistinct("eceba"));
		System.out.println(l.lengthOfLongestSubstringTwoDistinct("caabbbc"));
		System.out.println(l.lengthOfLongestSubstringTwoDistinct("caab"));
		System.out.println(l.lengthOfLongestSubstringTwoDistinct("aaab"));
	}
}
