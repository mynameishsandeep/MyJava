package com.interview.leetcode.linkedin.hard;

import java.util.HashMap;

public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		if (s == null || s.length() < t.length() || s.length() == 0) {
			return "";
		}
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : t.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		int left = 0;
		int minLeft = 0;
		int minLen = s.length() + 1;
		int count = 0;
		for (int right = 0; right < s.length(); right++) {
			if (map.containsKey(s.charAt(right))) {
				map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
				if (map.get(s.charAt(right)) >= 0) {
					count++;
				}
				while (count == t.length()) {
					if (right - left + 1 < minLen) {
						minLeft = left;
						minLen = right - left + 1;
					}
					if (map.containsKey(s.charAt(left))) {
						map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
						if (map.get(s.charAt(left)) > 0) {
							count--;
						}
					}
					left++;
				}
			}
			System.out.println(map);
			System.out.println("leftIndex = " + left + " rightIndex =" + right);

		}
		if (minLen > s.length()) {
			return "";
		}

		return s.substring(minLeft, minLeft + minLen);
	}

	public static void main(String[] args) {
		MinimumWindowSubstring m = new MinimumWindowSubstring();
		System.out.println("ADOBECODEBANC");
		System.out.println(m.minWindow("ADOBECODEBANC", "ABC"));
		//System.out.println(m.minWindow("AA", "AA"));
		//System.out.println(m.minWindow("acbbaca", "aba"));
		//System.out.println(m.minWindow("aaflslflsldkalskaaa", "aaa"));
		//System.out.println(m.minWindow("bba", "ab"));

	}

}
