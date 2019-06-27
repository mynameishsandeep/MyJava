package com.interview.leetcode.facebook.hard;

/*
 * https://leetcode.com/problems/wildcard-matching/description/
 * 
 * ==Difference between Regex and WildCard Matching=======
 * The difference is that: the * in wildcard problem can match any sequence independently, 
 * while the * in Regex Matching would only match duplicates, if any, of the character prior to it.
 * 
 * 		'?' Matches any single character.
 * 		'*' Matches any sequence of characters (including the empty sequence).
 * 
 * 		"adcab", "*a*b" ==> true
 * 		"adcab", "*a*" ==> true
 * 
 */
public class WildcardMatching_Recursion {

	public boolean isMatch(String s, String p) {
		int i = 0, j = 0, match = 0, star = -1;
		while (i < s.length()) {
			if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
				i++;
				j++;
			} else if (j < p.length() && p.charAt(j) == '*') {
				match = i;
				star = j++;
			} else if (star >= 0) {
				i = ++match;
				j = star + 1;
			} else {
				return false;
			}
		}
		while (j < p.length()) {
			if (p.charAt(j++) != '*')
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		WildcardMatching_Recursion w = new WildcardMatching_Recursion();
		//System.out.println(r.isMatch("abc", "a*"));
		//System.out.println(w.isMatch("abc", "*"));
		//System.out.println(w.isMatch("adcab", "*a*"));
		//System.out.println(w.isMatch("adceb", "*a*b")); // true
		System.out.println(w.isMatch("acdcb", "a*c?b")); // false
	}

}
